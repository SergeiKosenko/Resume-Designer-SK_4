package ru.devteam.resume.converters;

import org.springframework.stereotype.Component;
import ru.devteam.resume.dtos.ResumeDto;
import ru.devteam.resume.entities.Resume;

@Component
public class ResumeConverter {
    public ResumeDto entityToDto(Resume r) {
        ResumeDto resumeDto = new ResumeDto();
        resumeDto.setId(r.getId());
        resumeDto.setUserId(r.getUserId());
        resumeDto.setPost(r.getPost());
        resumeDto.setSalary(r.getSalary());
        resumeDto.setSchedule(r.getSchedule());
        resumeDto.setAboutMyself(r.getAboutMyself());
        return resumeDto;
    }
}
