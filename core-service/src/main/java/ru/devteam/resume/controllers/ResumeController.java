package ru.devteam.resume.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devteam.resume.dtos.ResumeDto;
import ru.devteam.resume.entities.Resume;
import ru.devteam.resume.services.ResumeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/resumes")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.findAll();
    }


    @GetMapping("/{id}")
    public ResumeDto getResumeById(@PathVariable Long id) {
        return resumeService.findResumeById(id);

    }
}
