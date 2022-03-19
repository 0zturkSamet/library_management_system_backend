package com.lms.library.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements Serializable {
	
	public User(@NotNull String displayName, @NotNull String username, @NotNull String password,
			@NotNull Integer active, @NotNull String role, @NotNull Date createdDate, Date lastModifiedDate) {
		super();
		this.displayName = displayName;
		this.username = username;
		this.password = password;
		this.active = active;
		this.role = role;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@NotNull
	@Column(name = "display_name")
	private String displayName;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "active")
	private Integer active;
	
	@NotNull
	@Column(name = "role")
	private String role;
	
	@NotNull
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	
	
	
	
	
	
	
	
}
