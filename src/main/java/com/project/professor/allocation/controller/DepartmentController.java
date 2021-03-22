package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	public DepartmentController (DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Department>> findAll(){
		List<Department> departments= departmentService.findAll(null);
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
		
	}
	


}
