package ru.devteam.resume.converters;

import org.springframework.stereotype.Component;
import ru.devteam.resume.dtos.CreateNewEducationDto;
import ru.devteam.resume.entities.Education;

@Component
public class EducationConverter {
    public CreateNewEducationDto entityToDto(Education e) {
        CreateNewEducationDto createNewEducationDto = new CreateNewEducationDto();
//        createNewEducationDto.setUserId(e.getUserId());
        createNewEducationDto.setOrganization(e.getOrganization());
        createNewEducationDto.setSpeciality(e.getSpeciality());
        createNewEducationDto.setYearStart(e.getYearStart());
        createNewEducationDto.setYearEnd(e.getYearEnd());
        return createNewEducationDto;
    }
}
