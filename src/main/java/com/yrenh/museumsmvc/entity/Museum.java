package com.yrenh.museumsmvc.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Museum")
public class Museum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String title;
	@Column()
	private String address;
	@Column()
	private String phone;
	@Column()
	private String site;
	@Column(name = "founding_date")
	private LocalDate foundingDate;
	@OneToMany(mappedBy = "museum")
	private List<Picture> pictures;
	@ManyToMany(mappedBy = "museums")
	private List<Visitor> visitors;
	
	public Museum() {
		super();
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}


	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}


	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}


	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getSite() {
		return site;
	}

	public LocalDate getFoundingDate() {
		return foundingDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setFoundingDate(LocalDate foundingDate) {
		this.foundingDate = foundingDate;
	}
	
	
}
