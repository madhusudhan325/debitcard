package com.mindtree.collegebranch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.collegebranch.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
