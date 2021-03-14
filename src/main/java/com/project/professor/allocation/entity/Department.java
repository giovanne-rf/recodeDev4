package com.project.professor.allocation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;
	
	/*
	 * Cascade all operations ALL,
	 * 
	 * Cascade persist operation PERSIST,
	 * 
	 * Cascade merge operation MERGE,
	 * 
	 * Cascade remove operation REMOVE,
	 * 
	 * Cascade refresh operation REFRESH,
	 * 
	 * Cascade detach operation
	 * 
	 * DETACH
	 */

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "department")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Professor> professors;
}
