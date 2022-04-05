package com.lms.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	
	@NotNull(message = "Please enter category name")
	@NotBlank(message = "Please enter category name")
	@Column(name = "name")
	private String name;
	
	
	
	@NotNull(message = "Please enter category short name")
	@NotBlank(message = "Please enter category short name")
	@Length(max = 4, message = "Must not exceed 4 characters.")
	@Column(name = "short_name")
	private String shortName;
	
	
	@Column(name = "notes")
	@Length(max = 1000, message = "*Must not exceed 1000 characters.")
	private String notes;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Book> books;
	
	
	
}
