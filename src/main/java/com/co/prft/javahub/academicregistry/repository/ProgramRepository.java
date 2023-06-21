package com.co.prft.javahub.academicregistry.repository;

import com.co.prft.javahub.academicregistry.entity.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgramRepository extends PagingAndSortingRepository<Program, UUID> {

    Page<Program> findAllByIsDeletedIsFalse(Pageable pageable);

}