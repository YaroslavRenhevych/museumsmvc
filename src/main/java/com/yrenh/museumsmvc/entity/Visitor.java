package com.yrenh.museumsmvc.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "Visitor",
		uniqueConstraints = @UniqueConstraint(columnNames = { "first_name", "last_name" }))
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column()
	private String email;
	@Column
	private String phone;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@ManyToMany
	@JoinTable(
			name = "visitor_museum",
			joinColumns = { @JoinColumn(name = "visitor_id") },
			inverseJoinColumns = { @JoinColumn(name = "museum_id") }
	)
	private List<Museum> museums;
	
	public Visitor() {
		super();
	}
	
	public List<Museum> getMuseums() {
		return museums;
	}

	public void setMuseums(List<Museum> museums) {
		this.museums = museums;
	}

	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
