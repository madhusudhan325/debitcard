package com.mindtree.passportgeneration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.passportgeneration.entity.Person;

@Service
public interface PassportpersonService {

	public String insertPersonDataAndGeneratePassportId(Person person);

	public List<Person> getPersonDataByPassportId(String passportId);

}
