package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.helper.enumm.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "citizenv_account")
public class CitizenvAccount {
	@Id
	private String usernameAccount;
	
	private String password;
	
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = CitizenvProvince.class)
	@JoinColumn(name = "manageToProvince", referencedColumnName = "id")
	private CitizenvProvince manageToProvince;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = CitizenvDistrict.class)
	@JoinColumn(name = "manageToDistrict", referencedColumnName = "id")
	private CitizenvDistrict manageToDistrict;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = CitizenvCommune.class)
	@JoinColumn(name = "manageToCommune", referencedColumnName = "id")
	private CitizenvCommune manageToCommune;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = CitizenvVillage.class)
	@JoinColumn(name = "manageToVillage", referencedColumnName = "id")
	private CitizenvVillage manageToVillage;
	
}
