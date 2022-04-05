package com.lms.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book")
@AllArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	
	@NotNull(message = "Please enter book title")
	@NotBlank(message = "Plese enter book title")
	@Column(name="title")
	
	private String title;
	
	
	@NotNull(message = "Please enter book tag")
	@NotBlank(message = " Please enter book tag")
	@Column(name="tag")
	private String tag;
	
	@NotNull(message = " Please enter book authhors")
	@NotBlank(message = " Please enter book authors")
	@Column(name = "authors")
	private String authors;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = " isbn")
	private String isbn;
	
	@Column(name = " status")
	private Integer status;
	
	@Column(name = "create_date")
	private Date createDate;
	
	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "Please select category")
	private Category category;
	
	
}
