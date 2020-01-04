package com.mindtree.collegebranch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.collegebranch.entity.Branch;
import com.mindtree.collegebranch.entity.College;
import com.mindtree.collegebranch.service.CollegeBranchService;

@Controller
public class CollegeBranchController {

	@Autowired
	private CollegeBranchService collegeBranchService;
	Branch branchh = new Branch();

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/form")
	public String index1() {
		return "college";
	}

	@RequestMapping("/addCollege")
	public String addCollegeDetails(@ModelAttribute("college") College college) {

		collegeBranchService.insertCollegeDataIntoDataBase(college);
		return "index";
	}

	@GetMapping("/form1")
	public String index1(Model model) {
		List<College> colleges = collegeBranchService.getAllCollegesFromDataBase();
		model.addAttribute("colleges", colleges);
		return "branch";
	}

	@RequestMapping("/addBranch")
	public String addBranchDetailsToCollge(@RequestParam("collegeId") int collegeId,
			@ModelAttribute("branch") Branch branch, Model model) {

		model.addAttribute("message", collegeBranchService.addBranchDetails(collegeId, branch));
		return "message";
	}

	@GetMapping("/form2")
	public String index2(Model model) {
		List<College> colleges = collegeBranchService.getAllCollegesFromDataBase();
		model.addAttribute("colleges", colleges);
		return "view";
	}

	@GetMapping("/getdata")
	public String getAllStudentDetails(@RequestParam("collegeName") String collegeName, Model model) {
		List<Branch> branchs = collegeBranchService.getAllBranchesOfParticularCollege(collegeName);
		List<College> colleges = collegeBranchService.getAllCollegesFromDataBase();
		model.addAttribute("branchs", branchs);
		model.addAttribute("colleges", colleges);
	//	model.addAttribute("totalStrength", collegeBranchService.getStrengthOfParticularCollege(collegeName));
		return "view";

	}

	@GetMapping("/update/{branchId}")
	public String updatBranchDetails(Model model, @PathVariable int branchId) {
		Branch branch = collegeBranchService.updateBranchData(branchId);
		branchh = branch;
		model.addAttribute("branch", branch);
		return "update";
	}

	@RequestMapping("/updatestrength")
	public String updateStrenthOfCollege(@RequestParam("branchTotalStrength") int branchTotalStrength) {
		collegeBranchService.updateStrengthOfBranch(branchh, branchTotalStrength);
		return "index";
	}

}
