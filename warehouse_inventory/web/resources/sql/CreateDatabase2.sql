-- MySQL Script generated by MySQL Workbench
-- 05/20/17 12:22:22
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `inventory` ;

-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventory` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema inventory_warehouse
-- -----------------------------------------------------
USE `inventory` ;

-- -----------------------------------------------------
-- Table `inventory`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`items` (
  `itemId` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lot` INT NULL,
  `color` INT NULL,
  `size` INT NULL,
  `price` DECIMAL(16,4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`itemId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`.`users_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`users_type` (
  `idusers_type` INT NOT NULL AUTO_INCREMENT,
  `name_type` VARCHAR(45) NULL,
  `code_type` VARCHAR(2) NULL,
  PRIMARY KEY (`idusers_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`users` (
  `users_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `password_user` VARCHAR(45) NULL,
  `idusers_type` INT NOT NULL,
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_users_users_type`
    FOREIGN KEY (`idusers_type`)
    REFERENCES `inventory`.`users_type` (`idusers_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_users_users_type_idx` ON `inventory`.`users` (`idusers_type` ASC);


-- -----------------------------------------------------
-- Table `inventory`.`warehouses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`warehouses` (
  `warehouses_Id` INT NOT NULL,
  `code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`warehouses_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`.`type_doc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`type_doc` (
  `type_doc_Id` INT NOT NULL,
  `code` VARCHAR(4) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`type_doc_Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`document` (
  `document_id` INT AUTO_INCREMENT,
  `type_doc_Id` INT NOT NULL,
  `consecutive` INT not null,
  `document_date` DATETIME NOT NULL,
  PRIMARY KEY (`document_id`),
  CONSTRAINT `fk_document_type_doc1`
    FOREIGN KEY (`type_doc_Id`)
    REFERENCES `inventory`.`type_doc` (`type_doc_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_document_type_doc1_idx` ON `inventory`.`document` (`type_doc_Id` ASC);


-- -----------------------------------------------------
-- Table `inventory`.`document_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`document_detail` (
  `document_datail_Id` INT NOT NULL,
  `document_id` INT NOT NULL,
  `Quantity` INT NOT NULL,
  `warehouses_Id` INT NOT NULL,
  `itemId` INT NOT NULL,
  PRIMARY KEY (`document_datail_Id`, `document_id`, `warehouses_Id`, `itemId`),
  CONSTRAINT `fk_document_datail_document1`
    FOREIGN KEY (`document_id`)
    REFERENCES `inventory`.`document` (`document_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_document_detail_warehouses1`
    FOREIGN KEY (`warehouses_Id`)
    REFERENCES `inventory`.`warehouses` (`warehouses_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_document_detail_items1`
    FOREIGN KEY (`itemId`)
    REFERENCES `inventory`.`items` (`itemId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_document_datail_document1_idx` ON `inventory`.`document_detail` (`document_id` ASC);

CREATE INDEX `fk_document_detail_warehouses1_idx` ON `inventory`.`document_detail` (`warehouses_Id` ASC);

CREATE INDEX `fk_document_detail_items1_idx` ON `inventory`.`document_detail` (`itemId` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `inventory`.`users_type` (`name_type`, `code_type`) VALUES ('Consultas', 'C');
INSERT INTO `inventory`.`users_type` (`name_type`, `code_type`) VALUES ('Jefe de Bodega', 'J');


INSERT INTO `inventory`.`users` (`name`, `password_user`, `idusers_type`) VALUES ('Javier', '123456', 1);
INSERT INTO `inventory`.`users` (`name`, `password_user`, `idusers_type`) VALUES ('Ramiro', '123456', 2);
INSERT INTO `inventory`.`users` (`name`, `password_user`, `idusers_type`) VALUES ('David', '123456', 1);
INSERT INTO `inventory`.`users` (`name`, `password_user`, `idusers_type`) VALUES ('Dz', '123456', 2);