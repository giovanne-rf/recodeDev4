package com.project.project.allocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Professor")
@Data
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false)
    @JoinColumn(name = "departament_id", nullable = false)
    private Departament departament;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "professor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Allocation> alocations;
}
