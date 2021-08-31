-- MySQL Script generated by MySQL Workbench
-- Tue 17 Aug 2021 09:28:14 PM EEST
-- Model: New Model    Version: 1.0userconnected
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema linkeDIn
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `linkeDIn` ;

-- -----------------------------------------------------
-- Schema linkeDIn
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `linkeDIn` DEFAULT CHARACTER SET utf8 ;
USE `linkeDIn` ;

-- -----------------------------------------------------
-- Table `linkeDIn`.`InformationPage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`InformationPage` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`InformationPage` (
  `idInformationPage` BIGINT NOT NULL AUTO_INCREMENT,
  `bio` LONGTEXT NULL,
  `work_experience` MEDIUMTEXT NULL,
  PRIMARY KEY (`idInformationPage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`User` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`User` (
  `idUser` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `profile_picture_dir` TINYTEXT NOT NULL,
  `settings` LONGTEXT NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Proffessional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Proffessional` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Proffessional` (
  `idProffessional` BIGINT NOT NULL AUTO_INCREMENT,
  `InformationPage_idInformationPage` BIGINT NOT NULL DEFAULT 1,
  `User_idUser` BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idProffessional`),
  INDEX `fk_Proffessional_InformationPage1_idx` (`InformationPage_idInformationPage` ASC) VISIBLE,
  INDEX `fk_Proffessional_User1_idx` (`User_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Proffessional_InformationPage1`
    FOREIGN KEY (`InformationPage_idInformationPage`)
    REFERENCES `linkeDIn`.`InformationPage` (`idInformationPage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proffessional_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `linkeDIn`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Moderator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Moderator` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Moderator` (
  `idModerator` BIGINT NOT NULL AUTO_INCREMENT,
  `User_idUser` BIGINT NOT NULL,
  PRIMARY KEY (`idModerator`),
  INDEX `fk_Moderator_User1_idx` (`User_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Moderator_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `linkeDIn`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Moderator_moderates_Proffessional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Moderator_moderates_Proffessional` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Moderator_moderates_Proffessional` (
  `Moderator_idModerator` BIGINT NOT NULL,
  `Proffessional_idProffessional` BIGINT NOT NULL,
  PRIMARY KEY (`Moderator_idModerator`, `Proffessional_idProffessional`),
  INDEX `fk_Moderator_has_Proffessional_Proffessional1_idx` (`Proffessional_idProffessional` ASC) VISIBLE,
  INDEX `fk_Moderator_has_Proffessional_Moderator_idx` (`Moderator_idModerator` ASC) VISIBLE,
  CONSTRAINT `fk_Moderator_has_Proffessional_Moderator`
    FOREIGN KEY (`Moderator_idModerator`)
    REFERENCES `linkeDIn`.`Moderator` (`idModerator`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Moderator_has_Proffessional_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Post` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Post` (
  `idPost` BIGINT NOT NULL AUTO_INCREMENT,
  `Proffessional_idProffessional` BIGINT NOT NULL,
  `title` TINYTEXT NOT NULL,
  `body` LONGTEXT NULL,
  INDEX `fk_Post_Proffessional1_idx` (`Proffessional_idProffessional` ASC) VISIBLE,
  PRIMARY KEY (`idPost`),
  CONSTRAINT `fk_Post_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Job_Offer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Job_Offer` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Job_Offer` (
  `idJob_Offer` BIGINT NOT NULL AUTO_INCREMENT,
  `Proffessional_idProffessional` BIGINT NOT NULL,
  `title` TINYTEXT NOT NULL,
  `body` LONGTEXT NULL,
  INDEX `fk_Job Offer_Proffessional1_idx` (`Proffessional_idProffessional` ASC) VISIBLE,
  PRIMARY KEY (`idJob_Offer`),
  CONSTRAINT `fk_Job Offer_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Interest_Declaration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Interest_Declaration` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Interest_Declaration` (
  `Proffessional_idProffessional` BIGINT NOT NULL,
  `Post_idPost` BIGINT NOT NULL,
  INDEX `fk_Interest_Declaration_Proffessional1_idx` (`Proffessional_idProffessional` ASC) VISIBLE,
  PRIMARY KEY (`Proffessional_idProffessional`, `Post_idPost`),
  CONSTRAINT `fk_Interest_Declaration_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Interest_Declaration_Post1`
    FOREIGN KEY (`Post_idPost`)
    REFERENCES `linkeDIn`.`Post` (`idPost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Connected`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Connected` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Connected` (
  `Proffessional_idProffessional1` BIGINT NOT NULL,
  `Proffessional_idProffessional2` BIGINT NOT NULL,
  PRIMARY KEY (`Proffessional_idProffessional1`, `Proffessional_idProffessional2`),
  INDEX `fk_Proffessional_has_Proffessional_Proffessional2_idx` (`Proffessional_idProffessional2` ASC) VISIBLE,
  INDEX `fk_Proffessional_has_Proffessional_Proffessional1_idx` (`Proffessional_idProffessional1` ASC) VISIBLE,
  CONSTRAINT `fk_Proffessional_has_Proffessional_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional1`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proffessional_has_Proffessional_Proffessional2`
    FOREIGN KEY (`Proffessional_idProffessional2`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Comment` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Comment` (
  `Proffessional_idProffessional` BIGINT NOT NULL,
  `Post_idPost` BIGINT NOT NULL,
  PRIMARY KEY (`Proffessional_idProffessional`, `Post_idPost`),
  INDEX `fk_Comment_Post1_idx` (`Post_idPost` ASC) VISIBLE,
  CONSTRAINT `fk_Comment_Proffessional1`
    FOREIGN KEY (`Proffessional_idProffessional`)
    REFERENCES `linkeDIn`.`Proffessional` (`idProffessional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Post1`
    FOREIGN KEY (`Post_idPost`)
    REFERENCES `linkeDIn`.`Post` (`idPost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Picture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Picture` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Picture` (
  `idPictures` BIGINT NOT NULL AUTO_INCREMENT,
  `picture_dir` TINYTEXT NOT NULL,
  `Post_idPost` BIGINT NOT NULL,
  PRIMARY KEY (`idPictures`),
  INDEX `fk_Picture_Post1_idx` (`Post_idPost` ASC) VISIBLE,
  CONSTRAINT `fk_Picture_Post1`
    FOREIGN KEY (`Post_idPost`)
    REFERENCES `linkeDIn`.`Post` (`idPost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkeDIn`.`Video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkeDIn`.`Video` ;

CREATE TABLE IF NOT EXISTS `linkeDIn`.`Video` (
  `idVideo` BIGINT NOT NULL AUTO_INCREMENT,
  `video_dir` TINYTEXT NOT NULL,
  `Post_idPost` BIGINT NOT NULL,
  PRIMARY KEY (`idVideo`),
  INDEX `fk_Video_Post1_idx` (`Post_idPost` ASC) VISIBLE,
  CONSTRAINT `fk_Video_Post1`
    FOREIGN KEY (`Post_idPost`)
    REFERENCES `linkeDIn`.`Post` (`idPost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
