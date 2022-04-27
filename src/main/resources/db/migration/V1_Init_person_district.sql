CREATE TABLE citizenv_person (
  id varchar(200) NOT NULL,
  hoVaTen varchar(100) NOT NULL,
  ngaySinh date NOT NULL,
  gioiTinh varchar(10) NOT NULL,
  cmnd varchar(100) NOT NULL,
  ngheNghiep varchar(30) NOT NULL,
  danToc varchar(20) NOT NULL,
  tonGiao varchar(10) DEFAULT 'Không',
  trinhDoVanHoa varchar(10) NOT NULL,
  diaChiThuongTru varchar(100) NOT NULL,
  diaChiTamTru varchar(100) NOT NULL,
  queQuan varchar(100) NOT NULL,
  belongToVillage varchar(50) NOT NULL,
  PRIMARY KEY ( ID )
);
CREATE TABLE citizenv_village (
  id varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  entitled varchar(50) DEFAULT 'Không',
  progress varchar(50) NOT NULL DEFAULT 'Chưa Hoàn Thành',
  belongToCommune varchar(50) NOT NULL,
  PRIMARY KEY ( id ) 
);

ALTER TABLE citizenv_person
  ADD CONSTRAINT FK_PERSON_VILLAGE FOREIGN KEY (belongToVillage) REFERENCES citizenv_village(id);
