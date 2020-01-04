package com.mindtree.passportgeneration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.passportgeneration.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
