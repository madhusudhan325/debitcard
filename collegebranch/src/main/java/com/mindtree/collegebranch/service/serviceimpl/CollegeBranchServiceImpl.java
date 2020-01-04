package com.mindtree.collegebranch.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.collegebranch.entity.Branch;
import com.mindtree.collegebranch.entity.College;
import com.mindtree.collegebranch.repository.BranchRepository;
import com.mindtree.collegebranch.repository.CollegeRepository;
import com.mindtree.collegebranch.service.CollegeBranchService;

@Service
public class CollegeBranchServiceImpl implements CollegeBranchService {
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public College insertCollegeDataIntoDataBase(College college) {

		return collegeRepository.save(college);
	}

	@Override
	public List<College> getAllCollegesFromDataBase() {
		return collegeRepository.findAll();
	}

	@Override
	public String addBranchDetails(int collegeId, Branch branch) {
		College college = collegeRepository.findById(collegeId).get();
		int size = college.getTotalBranches();
		if (size > college.getBranches().size()) {
			branch.setCollege(college);
			branchRepository.save(branch);
		} else {
			return "college is full";
		}
		return "assigned succesfully";
	}

	@Override
	public List<Branch> getAllBranchesOfParticularCollege(String collegeName) {
		List<Branch> branchs = new ArrayList<Branch>();
		for (College college : collegeRepository.findAll()) {
			if (collegeName.equalsIgnoreCase(college.getCollegeName())) {
				for (Branch branch : college.getBranches()) {
					branchs.add(branch);
				}
			}
		}
		return branchs;
	}

	@Override
	public int getStrengthOfParticularCollege(String collegeName) {
		int totalStrenth = 0;
		for (College college : collegeRepository.findAll()) {
			if (collegeName.equalsIgnoreCase(college.getCollegeName())) {
				for (Branch branch : college.getBranches()) {
					totalStrenth = totalStrenth + branch.getBranchTotalStrength();

				}
			}
		}
		return totalStrenth;
	}

	@Override
	public Branch updateBranchData(int branchId) {

		return branchRepository.findById(branchId).get();
	}

	@Override
	public void updateStrengthOfBranch(Branch branchh, int branchTotalStrength) {
		branchh.setBranchTotalStrength(branchTotalStrength);
		branchRepository.save(branchh);

	}
}
