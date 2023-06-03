package com.employee.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.employee.contact.model.EmpContact;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name ="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ecode")
	private Integer eCode;
	@Column(name = "efirstname")
	private String efirstname;
	@Column(name = "emiddlename")
	private String emiddlename;
	@Column(name = "elastname")
	private String elastname;
	@Column(name = "edob")
	private LocalDate edob;
	@Column(name = "egender")
	private String egender;
	@Column(name = "edoj")
	private LocalDate edoj;
	
	@OneToMany
	@JoinColumn(name="FK_eCode")
	private List<EmpContact> econ = new ArrayList<EmpContact>();
}
