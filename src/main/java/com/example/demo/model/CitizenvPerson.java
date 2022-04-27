package com.example.demo.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "citizenv_person")
public class CitizenvPerson {
	@Id
	@Type(type = "uuid-char")
	private UUID id;
	
	private String hoVaTen;
	
	
	private Date ngaySinh;
	
		
	private String gioiTinh;
	
		
	private String cmnd;
	
	
	private String ngheNghiep;
	
	
	private String danToc;
	
	private String tonGiao;
	
	private String trinhDoVanHoa;
	
	private String diaChiThuongTru;
	
	private String diaChiTamTru;
	
	private String queQuan;
	
	private String belongToVillage;

}
