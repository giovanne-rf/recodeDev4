package com.project.professor.allocation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

/*
 Todas essas anotações sao substituidas pela anotacao @Data (getters, setters e construtores)
 */

@Entity
@Data
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
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

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "course")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Allocation> allocations;

}
