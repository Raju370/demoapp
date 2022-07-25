package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.domain.Faculty;

@Repository
public interface FacultyRespository extends JpaRepository<Faculty, Integer> {

}
