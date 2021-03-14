package com.project.professor.allocation.entity;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Table(name = "professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = false, unique = true, length = 16)
	private String cpf;
	@ManyToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
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
	
	/*
	   @ToString.Exclude para evitar o looping
	 */

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "professor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
	private List<Allocation> allocation;

}
