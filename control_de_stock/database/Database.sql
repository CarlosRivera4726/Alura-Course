-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema control_de_stock
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema control_de_stock
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `control_de_stock` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `control_de_stock` ;

-- -----------------------------------------------------
-- Table `control_de_stock`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_de_stock`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `control_de_stock`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `control_de_stock`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `cantidad` INT NOT NULL DEFAULT '0',
  `categoria_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `categoria_id` (`categoria_id` ASC) VISIBLE,
  CONSTRAINT `producto_ibfk_1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `control_de_stock`.`categoria` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
