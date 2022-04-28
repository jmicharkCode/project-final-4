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
  PRIMARY KEY ( id )
);
CREATE TABLE citizenv_village (
  id varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  entitled varchar(50) DEFAULT 'Không',
  progress varchar(50) NOT NULL DEFAULT 'Chưa Hoàn Thành',
  belongToCommune varchar(50) NOT NULL,
  PRIMARY KEY ( id ) 
);
CREATE TABLE citizenv_commune (
  id varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  entitled varchar(50) DEFAULT 'Không',
  progress varchar(50) NOT NULL DEFAULT 'Chưa Hoàn Thành',
  belongToDistrict varchar(50) NOT NULL,
  PRIMARY KEY ( id )
);
CREATE TABLE citizenv_district (
  id varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  entitled varchar(50) DEFAULT 'Không',
  progress varchar(50) NOT NULL DEFAULT 'Chưa Hoàn Thành',
  belongToProvince varchar(50) NOT NULL,
  PRIMARY KEY ( id )
);
CREATE TABLE citizenv_province (
  id varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  entitled varchar(50) DEFAULT 'Không',
  progress varchar(50) NOT NULL DEFAULT 'Chưa Hoàn Thành',
  PRIMARY KEY ( id )
);
CREATE TABLE citizenv_declared (
  id varchar(255),
  usernameDeclared varchar(50) NOT NULL,
  startTime date NOT NULL,
  endTime date NOT NULL,
  PRIMARY KEY ( id )
);
CREATE TABLE citizenv_account (
  usernameAccount varchar(50) NOT NULL,
  password varchar(100) NOT NULL,
  role varchar(20) NOT NULL,
  manageToProvince varchar(50) DEFAULT NULL,
  manageToDistrict varchar(50) DEFAULT NULL,
  manageToCommune varchar(50) DEFAULT NULL,
  manageToVillage varchar(50) DEFAULT NULL,
  PRIMARY KEY ( usernameAccount )
);



ALTER TABLE citizenv_person
  ADD CONSTRAINT FK_PERSON_VILLAGE FOREIGN KEY (belongToVillage) REFERENCES citizenv_village(id);
ALTER TABLE citizenv_village
  ADD CONSTRAINT FK_VILLAGE_COMMUNE FOREIGN KEY (belongToCommune) REFERENCES citizenv_commune(id);
ALTER TABLE citizenv_commune
  ADD CONSTRAINT FK_COMMUNE_DISTRICT FOREIGN KEY (belongToDistrict) REFERENCES citizenv_district(id);
ALTER TABLE citizenv_district
  ADD CONSTRAINT FK_DISTRICT_PROVINCE FOREIGN KEY (belongToProvince) REFERENCES citizenv_province(id);
ALTER TABLE citizenv_account
  ADD CONSTRAINT FK_ACCOUNT_PROVINCE FOREIGN KEY (manageToProvince) REFERENCES citizenv_province(id);
ALTER TABLE citizenv_account
  ADD CONSTRAINT FK_ACCOUNT_DISTRICT FOREIGN KEY (manageToDistrict) REFERENCES citizenv_district(id);
ALTER TABLE citizenv_account
  ADD CONSTRAINT FK_ACCOUNT_COMMUNE FOREIGN KEY (manageToCommune) REFERENCES citizenv_commune(id);
ALTER TABLE citizenv_account
  ADD CONSTRAINT FK_ACCOUNT_VILLAGE FOREIGN KEY (manageToVillage) REFERENCES citizenv_village(id);
ALTER TABLE citizenv_declared
  ADD CONSTRAINT FK_DECLARED_ACCOUNT FOREIGN KEY (usernameDeclared) REFERENCES citizenv_account(usernameAccount);
 