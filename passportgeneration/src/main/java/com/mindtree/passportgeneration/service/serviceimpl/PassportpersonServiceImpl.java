package com.mindtree.passportgeneration.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.passportgeneration.entity.Person;
import com.mindtree.passportgeneration.repository.PersonRepository;
import com.mindtree.passportgeneration.service.PassportpersonService;

@Service
public class PassportpersonServiceImpl implements PassportpersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public String insertPersonDataAndGeneratePassportId(Person person) {

		String passport = "";
		String first = person.getFirstName();
		passport = passport + first.charAt(0);
		String last = person.getLastName();
		passport = passport + last.charAt(0);
		int num = person.getAge();
		passport = passport + num;
		String data = person.getCountry();
		passport = passport + data.charAt(0) + data.charAt(1) + data.charAt(2);
		person.setPassportId(passport);
		personRepository.save(person);
		return passport;

	}

	@Override
	public List<Person> getPersonDataByPassportId(String passportId) {
		List<Person> persons = new ArrayList<Person>();
		for (Person person : personRepository.findAll()) {
			if (passportId.equalsIgnoreCase(person.getPassportId())) {
				persons.add(person);
			}
		}
		return persons;
	}

}
