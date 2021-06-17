package com.associationmtm.demo.manytomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.associationmtm.demo.manytomany.entities.Programmer;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer> {

}
