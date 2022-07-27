package ru.devteam.resume.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.devteam.resume.dtos.CreateNewUserDto;
import ru.devteam.resume.entities.Role;
import ru.devteam.resume.entities.User;
import ru.devteam.resume.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id){userRepository.deleteById(id);}

    public void createNewUser(CreateNewUserDto createNewUserDto) {
        User user = new User();
        user.setPhoto(createNewUserDto.getPhoto());
        user.setFirstName(createNewUserDto.getFirstName());
        user.setLastName(createNewUserDto.getLastName());
        user.setGender(createNewUserDto.getGender());
        user.setEmail(createNewUserDto.getEmail());
        user.setPassword(createNewUserDto.getPassword());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format("Пользователь с электронным адресом '%s' не найден", email)));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
