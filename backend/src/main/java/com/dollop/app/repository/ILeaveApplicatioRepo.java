package com.dollop.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.dollop.app.model.LeaveApplication;


public interface ILeaveApplicatioRepo extends JpaRepository<LeaveApplication, Integer> {
	@Modifying
	@Query("DELETE FROM LeaveApplication l WHERE l.employee.id = :employeeId")
	void deleteByEmployeeId(@Param("employeeId") Integer employeeId);
	
	List<LeaveApplication> findByEmployeeEmpId(Integer empId);

}
