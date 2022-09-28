package com.leave.tracker.repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leave.tracker.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query(value = "select e from Employee e where e.empId = :empid")
	List<Employee> getDetailsById(@Param("empid") int empid);

	@Transactional
	@Modifying
	@Query(value = "update Employee e set e.startDate = :sdate,e.endDate = :edate, e.reason = :reason where e.id = :id")
	void updateLeave(@Param("sdate") Date sdate, @Param("edate") Date edate, @Param("reason") String reason,
			@Param("id") int id);

}
