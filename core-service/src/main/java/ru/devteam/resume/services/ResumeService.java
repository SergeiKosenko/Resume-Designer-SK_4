package ru.devteam.resume.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.devteam.resume.converters.ResumeConverter;
import ru.devteam.resume.converters.UserConverter;
import ru.devteam.resume.dtos.ResumeDto;

import ru.devteam.resume.entities.Resume;
import ru.devteam.resume.repositories.EducationRepository;
import ru.devteam.resume.repositories.ResumeRepository;
import ru.devteam.resume.repositories.UserRepository;
import ru.devteam.resume.repositories.WorkRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final ResumeConverter resumeConverter;
    private final EducationRepository educationRepository;
    private final WorkRepository workRepository;
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    public ResumeDto findResumeById(Long id) {
        ResumeDto resume = resumeConverter.entityToDto(resumeRepository.findByUserId(id));
        resume.setUserData(userConverter.entityToDto(userRepository.getReferenceById(id)));
        resume.setEducations(educationRepository.findByUserId(id));
        resume.setWorks(workRepository.findByUserId(id));
        return resume;

    }

}
