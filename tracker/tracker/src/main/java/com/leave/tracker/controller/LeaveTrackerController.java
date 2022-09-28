package com.leave.tracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.leave.tracker.client.AuthClient;
import com.leave.tracker.entity.Employee;
import com.leave.tracker.services.LeaveService;

@RestController
@CrossOrigin
public class LeaveTrackerController {

	@Autowired
	LeaveService leaveService;

	@Autowired
	AuthClient authClient;

/*	
	To get all Leaves 
	of Employee
*/
	@GetMapping(value = "leaves", produces = "application/json")
	public List<Employee> getAllLeave() {
		return leaveService.allEmployeeLeave();

	}

/*	
	To get the Leaves of
	Employee according to Employee Id.
	
	Id is passed as uri path variable
	
	Parameter : Id from the pathvariable
*/
	
	@GetMapping("leaves/{id}")
	public List<Employee> getLeavesById(@PathVariable int id) {
		return leaveService.singleEmployeeLeave(id);
	}
	
/*	
	To Add new Leave From Employee 
	Parameter : Employee object
*/
	@PostMapping("addleave")
	public Employee addLeave(@RequestBody Employee emp) {
		return leaveService.addEmployeeLeave(emp);
	}
	
/*	
	To Add new Leave From Employee 
	Parameter : Employee object
*/	
	@PutMapping("addleave")
	public void updateEmployee(@RequestBody Employee emp) {
		leaveService.updateEmployee(emp);
	}

}
