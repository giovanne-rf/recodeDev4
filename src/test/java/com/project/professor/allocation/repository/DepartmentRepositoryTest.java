package com.project.professor.allocation.repository;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	
	@Test
	public void findAll() {
		List<Department> departments = departmentRepository.findAll();
		
		System.out.println(departments);

	}
	
	@Test
	public void  findByid() {
		//range
		Long id = 1L;
		
		//act
		Optional<Department> departmentOptional =  departmentRepository.findById(id);
		Department departament = departmentOptional.orElse(null);
		
		//print
		System.out.println(departament);
	}
	
	@Test
	public void saveCreate() {
		
		//Range
		Department d = new Department();
		d.setName("Departamento de Física Cinética");
	
	
		
		//Act
		Department department =  departmentRepository.save(d);
		
		
		
		//Print
		System.out.println(department);
	}
}
