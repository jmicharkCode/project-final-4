package com.example.demo.model;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.helper.enumm.Entitle;
import com.example.demo.helper.enumm.Progress;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "citizenv_commune")
public class CitizenvCommune {
	@Id
	private String communeID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "entitled")
	@Enumerated(EnumType.STRING)
	private Entitle entitled = Entitle.Không;
	
	@Column(name = "progress")
	@Enumerated(EnumType.STRING)
	private Progress progress = Progress.Chưa;
	
	
	@ManyToOne()
	@JoinColumn(name = "belongToDistrict")
	private CitizenvDistrict district;
	
	@OneToMany(mappedBy = "commune", cascade = CascadeType.ALL)
	private List<CitizenvVillage> villages;
	
}
