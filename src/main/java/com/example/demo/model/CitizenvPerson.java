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
@Table(name = "citizenv_person")
public class CitizenvPerson {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "hoVaTen")
	private String hoVaTen;
	
	@Column(name = "ngaySinh")
	private Date ngaySinh;
	
	@Column(name = "gioiTinh")
	private String gioiTinh;
	
	@Column(name = "cmnd")
	private String cmnd;
	
	@Column(name = "ngheNghiep")
	private String ngheNghiep;
	
	@Column(name = "danToc")
	private String danToc;
	
	@Column(name = "tonGiao")
	private String tonGiao;
	
	@Column(name = "trinhDoVanHoa")
	private String trinhDoVanHoa;
	
	@Column(name = "diaChiThuongTru")
	private String diaChiThuongTru;
	
	@Column(name = "diaChiTamTru")
	private String diaChiTamTru;
	
	@Column(name = "queQuan")
	private String queQuan;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "belongToVillage")
	private CitizenvVillage village;
	
}
