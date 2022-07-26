package ru.devteam.resume.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResumeDto {
    private Long id;
    private Long userId;
    private String post;
    private Long salary;
    private String schedule;
    private String aboutMyself;

}
