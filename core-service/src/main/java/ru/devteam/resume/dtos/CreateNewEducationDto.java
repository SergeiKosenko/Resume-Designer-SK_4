package ru.devteam.resume.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CreateNewEducationDto {
    private String organization;
    private String speciality;
    private Date yearEnd;
    private Date yearStart;
}
