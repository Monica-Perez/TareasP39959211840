CREATE SCHEMA IF NOT EXISTS `cineVision` DEFAULT CHARACTER SET utf8 ;
USE `cineVision` ;

-- -----------------------------------------------------
-- Tabla Usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblUsuarios (
  idUsuarios INT NOT NULL AUTO_INCREMENT,
  Usuario VARCHAR(45) NULL,
  contra VARCHAR(45) NULL,
  PRIMARY KEY (idUsuarios)
  );

insert into tblUsuarios(Usuario,contra)values("monica","1234"); 
select * from tblUsuarios;
drop table tblUsuarios;
