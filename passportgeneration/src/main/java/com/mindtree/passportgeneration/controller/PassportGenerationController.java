package com.mindtree.passportgeneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.passportgeneration.entity.Person;
import com.mindtree.passportgeneration.service.PassportpersonService;

@Controller
public class PassportGenerationController {

	@Autowired
	private PassportpersonService passportpersonService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/form")
	public String index1() {
		return "person";
	}

	@RequestMapping("/addPerson")
	public String addPersonDetails(@ModelAttribute("person") Person person, Model model) {

		model.addAttribute("passportNum", passportpersonService.insertPersonDataAndGeneratePassportId(person));
		return "passport";
	}

	@GetMapping("/form1")
	public String index2() {
		return "view";
	}

	@GetMapping("/showdata")
	public String getPersonDetailsByPassportId(@RequestParam("passportId") String passportId, Model model) {
		List<Person> result = passportpersonService.getPersonDataByPassportId(passportId);
		model.addAttribute("result", result);
		return "view";

	}

}
