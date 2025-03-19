package com.in.ims.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="marks_table")
public class MarksTable implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name="hindi")
	private Integer hindi;

	@Column(name="english")
	private Integer english;


	@Column(name="maths")
	private Integer maths;

	@Column(name="science")
	private Integer science;

	@Column(name="rollnumber")
	private Integer rollnumber;

	@Column(name="studyingclass")
	private Integer studyingclass;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Integer getHindi() {
		return hindi;
	}

	public void setHindi(Integer hindi) {
		this.hindi = hindi;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(Integer rollnumber) {
		this.rollnumber = rollnumber;
	}

	public Integer getStudyingclass() {
		return studyingclass;
	}

	public void setStudyingclass(Integer studyingclass) {
		this.studyingclass = studyingclass;
	}
}
