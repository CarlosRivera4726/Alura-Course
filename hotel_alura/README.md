[![forthebadge made-with-java](https://forthebadge.com/images/badges/made-with-java.svg)](https://www.java.com/es/)

[![forthebadge](https://github.com/CarlosRivera4726/Alura-Course/blob/main/hotel_alura/made-with-mysql.svg)](https://www.mysql.com/downloads/)
# Hotel Alura 📝  
En este artículo voy a explicar cómo crear un programa en Java que realice las funciones de un sistema de gestión de reservas para un hotel llamado Alura. El programa tendrá las siguientes características:

- El programa permitirá registrar las reservas de los huéspedes, asignando un valor automático según la fecha de entrada y salida. El valor se calculará multiplicando el número de días de estancia por 5000 pesos colombianos.
- El programa también permitirá registrar los datos básicos de los huéspedes, como nombre, apellido, fecha de nacimiento, nacionalidad, teléfono y el id de la reserva correspondiente.
- El programa ofrecerá la opción de buscar las reservas o los huéspedes por id o por apellido, respectivamente. Además, se podrá editar o eliminar la información de las reservas o los huéspedes si se desea.
- El programa se conectará a una base de datos MySQL donde se almacenará toda la información del sistema.

Para realizar este programa se necesitará tener instalado el JDK de Java, el IDE Eclipse y el gestor de base de datos MySQL Workbench. A continuación se detallan los pasos para crear el programa desde cero:
## Get Started 🚀  
Las clases modelo son aquellas que representan los datos o la lógica de negocio de una aplicación. Por ejemplo, si estamos desarrollando un sistema de gestión de reservas de hotel, podemos tener clases modelo como Huespedes y Reservas, que almacenan la información de los clientes y las habitaciones reservadas. Estas clases nos permiten encapsular los atributos y los métodos relacionados con cada entidad, facilitando el diseño y el mantenimiento del código. A continuación, veremos cómo definir y utilizar estas clases modelo en Java.

# Clase Huesped:
## Usage/Examples  
~~~java  
  package models;

import java.sql.Date;

public class Huesped {
	private int id;
	private String nombre;
	private String apellido;
	private Date FECHA_NACIMIENTO;
	private String nacionalidad;
	private Integer telefono;
	private Integer ID_RESERVA;
	
	//Constructor
	public Huesped(String nombre, String apellido, Date fECHA_NACIMIENTO, String nacionalidad, Integer telefono, Integer iD_RESERVA) {
		this.nombre = nombre;
		this.apellido = apellido;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		ID_RESERVA = iD_RESERVA;
	}
	public Huesped(Integer id, String nombre, String apellido, Date fECHA_NACIMIENTO, String nacionalidad, Integer telefono, Integer iD_RESERVA) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		ID_RESERVA = iD_RESERVA;
	}

	
	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}

	public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
		this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getID_RESERVA() {
		return ID_RESERVA;
	}

	public void setID_RESERVA(Integer iD_RESERVA) {
		ID_RESERVA = iD_RESERVA;
	}


	@Override
	public String toString() {
		return "Huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", FECHA_NACIMIENTO="
				+ FECHA_NACIMIENTO + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", ID_RESERVA="
				+ ID_RESERVA + "]";
    }
}
~~~  

# MySQL - database
~~~ SQL
DROP DATABASE IF EXISTS HOTEL_ALURA;
CREATE DATABASE IF NOT EXISTS HOTEL_ALURA;
USE HOTEL_ALURA;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel_alura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_alura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_alura` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hotel_alura` ;


-- -----------------------------------------------------
-- Table `hotel_alura`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_alura`.`reservas` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FECHA_ENTRADA` DATE NOT NULL,
  `FECHA_SALIDA` DATE NOT NULL,
  `VALOR` BIGINT NOT NULL,
  `FORMA_PAGO` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `hotel_alura`.`huespedes`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `hotel_alura`.`huespedes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NULL DEFAULT NULL,
  `APELLIDO` VARCHAR(45) NULL DEFAULT NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `NACIONALIDAD` VARCHAR(25) NULL DEFAULT NULL,
  `TELEFONO` INT NULL DEFAULT NULL,
  `ID_RESERVA` INT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_RESERVA) REFERENCES reservas (ID) ON DELETE CASCADE ON UPDATE CASCADE)
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;




CREATE TABLE IF NOT EXISTS USUARIOS(
	ID INT NOT NULL AUTO_INCREMENT,
    USUARIO VARCHAR(150) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(ID)
);

SET FOREIGN_KEY_CHECKS=0;


~~~ 
# Usuarios
~~~ 
use HOTEL_ALURA;
INSERT INTO USUARIOS (usuario, password) VALUES('admin', '21232f297a57a5a743894ae4a801fc3');
-- SELECT * FROM USUARIOS;
-- SELECT * FROM RESERVAS;
-- select * from huespedes;

-- ALTER TABLE HOTEL_ALURA.USUARIOS ADD COLUMN USUARIO VARCHAR(25) UNIQUE NOT NULL;

-- ALTER TABLE HOTEL_ALURA.USUARIOS DROP COLUMN EMAIL;

SELECT * FROM RESERVAS WHERE ID=11;

-- UPDATE HOTEL_ALURA.HUESPEDES
-- SET NOMBRE = ?, APELLIDO = ?, FECHA_NACIMIENTO=?, NACIONALIDAD=?, TELEFONO=?
-- WHERE ID=?;

-- DELETE FROM HOTEL_ALURA.RESERVAS WHERE ID=1;


commit;

~~~ 

 
## Demo  
Link del funcionamiento:

https://youtu.be/CAhDrZ3NzeE


 
## Badges  
![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCQcORX80-q_TUEHFeKmGy0w?style=social)

![Generic badge](https://img.shields.io/badge/Linkedin-Follow%20Me-blue)(https://www.linkedin.com/in/carlos-rivera-g-c/)
