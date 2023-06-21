package com.co.prft.javahub.academicregistry.service.impl;

import com.co.prft.javahub.academicregistry.mapper.ProgramMapper;
import com.co.prft.javahub.academicregistry.model.program.ProgramDto;
import com.co.prft.javahub.academicregistry.repository.ProgramRepository;
import com.co.prft.javahub.academicregistry.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final ProgramMapper programMapper;

    @Override
    public List<ProgramDto> getPrograms() {
        return programRepository
                .findAllByIsDeletedIsFalse(Pageable.unpaged())
                .map(programMapper::map)
                .stream()
                .toList();
    }
}