package com.leave.tracker.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.tracker.entity.Employee;
import com.leave.tracker.repo.EmployeeRepo;


@Service
public class LeaveService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> allEmployeeLeave() {
		return employeeRepo.findAll();
	}

	public Employee addEmployeeLeave(Employee emp) {
		employeeRepo.save(emp);
		return emp;
	}

	public List<Employee> singleEmployeeLeave(int id) {
		return employeeRepo.getDetailsById(id);
	}

	public void updateEmployee(Employee emp) {
			employeeRepo.updateLeave(emp.getStartDate(), emp.getEndDate(), emp.getReason(), emp.getId());
		
	}

}
