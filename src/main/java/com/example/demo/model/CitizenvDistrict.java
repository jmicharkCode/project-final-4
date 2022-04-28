package com.example.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "citizenv_district")
public class CitizenvDistrict {
	@Id
	private String id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Entitle entitled = Entitle.KHÔNG;
	
   
	@Enumerated(EnumType.STRING)
	private Progress progress = Progress.CHƯA_HOÀN_THÀNH;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = CitizenvProvince.class)
	@JoinColumn(name = "belongToProvice", referencedColumnName = "id")
	private CitizenvProvince belongToProvice;
	
}
