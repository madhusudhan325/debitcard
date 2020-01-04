package com.mindtree.collegebranch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.collegebranch.entity.Branch;
import com.mindtree.collegebranch.entity.College;

@Service
public interface CollegeBranchService {

	/**
	 * @param college
	 * @return college data which i have inserted
	 */
	public College insertCollegeDataIntoDataBase(College college);

	/**
	 * @return list of colleges
	 */
	public List<College> getAllCollegesFromDataBase();

	/**
	 * @param collegeId
	 * @param branch
	 * @return message based on branch strength of college
	 */
	public String addBranchDetails(int collegeId, Branch branch);

	/**
	 * @param collegeName
	 * @return list of branches for given college
	 */
	public List<Branch> getAllBranchesOfParticularCollege(String collegeName);

	/**
	 * @param collegeName
	 * @return strength of college
	 */
	public int getStrengthOfParticularCollege(String collegeName);

	/**
	 * @param branchId
	 * @return branch object along with data
	 */
	public Branch updateBranchData(int branchId);

	/**
	 * @param branchh
	 * @param branchTotalStrength update strength of branch
	 */
	public void updateStrengthOfBranch(Branch branchh, int branchTotalStrength);

}
