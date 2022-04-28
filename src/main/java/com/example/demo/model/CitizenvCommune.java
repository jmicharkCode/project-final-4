package com.example.demo.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
	private String id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Entitle entitled = Entitle.KHÔNG;
	
   
	@Enumerated(EnumType.STRING)
	private Progress progress = Progress.CHƯA_HOÀN_THÀNH;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = CitizenvDistrict.class)
	@JoinColumn(name = "belongToDistrict", referencedColumnName = "id")
	private CitizenvDistrict belongToDistrict;
	
}
