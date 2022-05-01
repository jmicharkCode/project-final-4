package com.example.demo.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@OneToOne()
	@JoinColumn(name = "manageToProvince")
	private CitizenvProvince manageToProvince;
	
	
	
	@OneToOne()
	@JoinColumn(name = "manageToDistrict")
	private CitizenvDistrict manageToDistrict;

	
	
	@OneToOne()
	@JoinColumn(name = "manageToCommune")
	private CitizenvCommune manageToCommune;
	
	@OneToOne()
	@JoinColumn(name = "manageToVillage")
	private CitizenvVillage manageToVillage;
	
	@OneToMany(mappedBy = "usernameDeclared", cascade = CascadeType.ALL)
	private List<CitizenvDeclared> declared;
	
	/*@OneToOne()
	@JoinColumn(name = "provinceID")
	private CitizenvProvince manageProvince;
	
	@OneToOne()
	@JoinColumn(name = "districtID")
	private CitizenvDistrict manageDistrict;
	
	@OneToOne()
	@JoinColumn(name = "communeID")
	private CitizenvCommune manageCommune;
	
	@OneToOne()
	@JoinColumn(name = "villageID")
	private CitizenvVillage manageVillage;*/
	
}
