package com.example.demo.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = CitizenvAccount.class)
	@JoinColumn(name = "usernameDeclared", referencedColumnName = "usernameAccount")
	private CitizenvAccount username;
	
	
	private Date startTime;
	
	private Date endTime;
	
}
