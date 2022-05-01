package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "citizenv_declared")
public class CitizenvDeclared {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;
	
	@ManyToOne()
	@JoinColumn(name = "usernameDeclared")
	private CitizenvAccount usernameDeclared;
	
	@Column(name = "startTime")
	private Date startTime;
	
	@Column(name = "endTime")
	private Date endTime;
	
	/*@ManyToOne()
	@JoinColumn(name = "usernameAccount")
	private CitizenvVillage account;*/
	
}
