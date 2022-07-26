package ru.devteam.resume.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.devteam.resume.enums.GenderType;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class CreateNewUserDto {
    private String photo;
    private String firstName;
    private String lastName;
    private String password;
    private GenderType gender;
    private Date dateOfBirth;
    private String email;
}
