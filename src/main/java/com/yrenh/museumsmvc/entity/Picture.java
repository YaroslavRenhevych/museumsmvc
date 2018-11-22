package com.yrenh.museumsmvc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Picture")
public class Picture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String title;
	@ManyToOne
	@JoinColumn(name = "painter_id")
	private Painter painter;
	@ManyToOne
	@JoinColumn(name = "museum_id")
	private Museum museum;
	@Column
	private LocalDate creationDate;
	
	public Picture() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Painter getPainter() {
		return painter;
	}

	public Museum getMuseum() {
		return museum;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPainter(Painter painter) {
		this.painter = painter;
	}

	public void setMuseum(Museum museum) {
		this.museum = museum;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
}
