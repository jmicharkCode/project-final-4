package com.example.demo.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "citizenv_village")
public class CitizenvVillage {
	@Id
	private String id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Entitle entitled = Entitle.KHÔNG;
	
   
	@Enumerated(EnumType.STRING)
	private Progress progress = Progress.CHƯA_HOÀN_THÀNH;
	
	private String belongToCommune;
	
	@OneToMany(targetEntity = CitizenvPerson.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "belongToVillage", referencedColumnName = "id")
	private List<CitizenvPerson> person;
}
