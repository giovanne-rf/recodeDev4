package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Department;

//Um componente da camada que vai permitir a 'conversa' com o banco
//interface herdando de outra -> extends
//uma classe herdando de uma interface -> implements

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findByNameIgnoreCase (String name);

}


