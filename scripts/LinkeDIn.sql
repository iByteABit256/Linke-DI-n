SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema linkeDIn
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS linkeDIn ;

-- -----------------------------------------------------
-- Schema linkeDIn
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS linkeDIn DEFAULT CHARACTER SET utf8 ;
USE linkeDIn ;

-- -----------------------------------------------------
-- Table linkeDIn.information_page
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.information_page ;

CREATE TABLE IF NOT EXISTS linkeDIn.information_page (
  id_information_page BIGINT NOT NULL AUTO_INCREMENT,
  bio LONGTEXT NULL,
  work_experience MEDIUMTEXT NULL,
  PRIMARY KEY (id_information_page))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.user
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.user ;

CREATE TABLE IF NOT EXISTS linkeDIn.user (
  id_user BIGINT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE,
  UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.proffessional
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.proffessional ;

CREATE TABLE IF NOT EXISTS linkeDIn.proffessional (
  id_proffessional BIGINT NOT NULL AUTO_INCREMENT,
  id_information_page BIGINT NOT NULL DEFAULT 1,
  id_user BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_proffessional),
  INDEX fk_proffessional_information_page1_idx (id_information_page ASC) VISIBLE,
  INDEX fk_proffessional_User1_idx (id_user ASC) VISIBLE,
  CONSTRAINT fk_proffessional_information_page1
    FOREIGN KEY (id_information_page)
    REFERENCES linkeDIn.information_page (id_information_page)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_proffessional_User1
    FOREIGN KEY (id_user)
    REFERENCES linkeDIn.user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.moderator
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.moderator ;

CREATE TABLE IF NOT EXISTS linkeDIn.moderator (
  id_moderator BIGINT NOT NULL AUTO_INCREMENT,
  id_user BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_moderator),
  INDEX fk_moderator_User1_idx (id_user ASC) VISIBLE,
  CONSTRAINT fk_moderator_User1
    FOREIGN KEY (id_user)
    REFERENCES linkeDIn.User (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.moderator_moderates_proffessional
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.moderator_moderates_proffessional ;

CREATE TABLE IF NOT EXISTS linkeDIn.moderator_moderates_proffessional (
  moderator_id BIGINT NOT NULL DEFAULT 1,
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (moderator_id, id_proffessional),
  INDEX fk_moderator_has_proffessional_proffessional1_idx (id_proffessional ASC) VISIBLE,
  INDEX fk_moderator_has_proffessional_moderator_idx (moderator_id ASC) VISIBLE,
  CONSTRAINT fk_moderator_has_proffessional_moderator
    FOREIGN KEY (moderator_id)
    REFERENCES linkeDIn.moderator (id_moderator)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_moderator_has_proffessional_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.post
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.post ;

CREATE TABLE IF NOT EXISTS linkeDIn.post (
  id_post BIGINT NOT NULL AUTO_INCREMENT,
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  title TINYTEXT NOT NULL,
  body LONGTEXT NULL,
  dt DATETIME NOT NULL,
  INDEX fk_post_proffessional1_idx (id_proffessional ASC) VISIBLE,
  PRIMARY KEY (id_post),
  CONSTRAINT fk_post_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.job_offer
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.job_offer ;

CREATE TABLE IF NOT EXISTS linkeDIn.job_offer (
  id_job_offer BIGINT NOT NULL AUTO_INCREMENT,
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  title TINYTEXT NOT NULL,
  body LONGTEXT NULL,
  INDEX fk_job_offer_proffessional1_idx (id_proffessional ASC) VISIBLE,
  PRIMARY KEY (id_job_offer),
  CONSTRAINT fk_job_offer_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table linkeDIn.job_offer_application
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.job_offer_application ;

CREATE TABLE IF NOT EXISTS linkeDIn.job_offer_application (
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  id_job_offer BIGINT NOT NULL DEFAULT 1,
  INDEX fk_job_offer_application_proffessional1_idx (id_proffessional ASC) VISIBLE,
  PRIMARY KEY (id_proffessional, id_job_offer),
  CONSTRAINT fk_job_offer_application_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_job_offer_application_job_offer1
    FOREIGN KEY (id_job_offer)
    REFERENCES linkeDIn.job_offer (id_job_offer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.job_offer_seen
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.job_offer_seen ;

CREATE TABLE IF NOT EXISTS linkeDIn.job_offer_seen (
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  id_job_offer BIGINT NOT NULL DEFAULT 1,
  INDEX fk_job_offer_seen_proffessional1_idx (id_proffessional ASC) VISIBLE,
  PRIMARY KEY (id_proffessional, id_job_offer),
  CONSTRAINT fk_job_offer_seen_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_job_offer_seen_job_offer1
    FOREIGN KEY (id_job_offer)
    REFERENCES linkeDIn.job_offer (id_job_offer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.interest_declaration
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.interest_declaration ;

CREATE TABLE IF NOT EXISTS linkeDIn.interest_declaration (
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  id_post BIGINT NOT NULL DEFAULT 1,
  INDEX fk_interest_declaration_proffessional1_idx (id_proffessional ASC) VISIBLE,
  PRIMARY KEY (id_proffessional, id_post),
  CONSTRAINT fk_interest_declaration_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_interest_declaration_post1
    FOREIGN KEY (id_post)
    REFERENCES linkeDIn.post (id_post)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.connection_requests
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.connection_requests ;

CREATE TABLE IF NOT EXISTS linkeDIn.connection_requests (
  id_proffessional1 BIGINT NOT NULL DEFAULT 1,
  id_proffessional2 BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_proffessional1, id_proffessional2),
  INDEX fk_proffessional_has_proffessional_proffessional2_idx (id_proffessional2 ASC) VISIBLE,
  INDEX fk_proffessional_has_proffessional_proffessional1_idx (id_proffessional1 ASC) VISIBLE,
  CONSTRAINT fk_connection_request_has_id_proffessional1
  FOREIGN KEY (id_proffessional1)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_connection_request_has_id_proffessional2
    FOREIGN KEY (id_proffessional2)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.connected
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.connected ;

CREATE TABLE IF NOT EXISTS linkeDIn.connected (
  id_proffessional1 BIGINT NOT NULL DEFAULT 1,
  id_proffessional2 BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_proffessional1, id_proffessional2),
  INDEX fk_proffessional_has_proffessional_proffessional2_idx (id_proffessional2 ASC) VISIBLE,
  INDEX fk_proffessional_has_proffessional_proffessional1_idx (id_proffessional1 ASC) VISIBLE,
  CONSTRAINT fk_connected_has_id_proffessional1
    FOREIGN KEY (id_proffessional1)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_connected_has_id_proffessional2
    FOREIGN KEY (id_proffessional2)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.discussion
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.discussion ;

CREATE TABLE IF NOT EXISTS linkeDIn.discussion (
  id_discussion BIGINT NOT NULL AUTO_INCREMENT,
  id_proffessional1 BIGINT NOT NULL DEFAULT 1,
  id_proffessional2 BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_discussion),
  INDEX fk_discussion_id_discussion_idx (id_discussion ASC) VISIBLE,
  CONSTRAINT fk_discussion_id_proffessional1
    FOREIGN KEY (id_proffessional1)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_discussion_id_proffessional2
    FOREIGN KEY (id_proffessional2)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.message
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.message ;

CREATE TABLE IF NOT EXISTS linkeDIn.message (
  id_message BIGINT NOT NULL AUTO_INCREMENT,
  id_discussion BIGINT NOT NULL DEFAULT 1,
  id_sender BIGINT NOT NULL DEFAULT 1,
  message TINYTEXT NOT NULL,
  dt DATETIME NOT NULL,
  INDEX fk_message_id_message_idx (id_message ASC) VISIBLE,
  PRIMARY KEY (id_message),
  CONSTRAINT fk_message_sender
    FOREIGN KEY (id_sender)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_message_discussion
    FOREIGN KEY (id_discussion)
    REFERENCES linkeDIn.discussion (id_discussion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.comment
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.comment ;

CREATE TABLE IF NOT EXISTS linkeDIn.comment (
  id_comment BIGINT NOT NULL AUTO_INCREMENT, 
  id_proffessional BIGINT NOT NULL DEFAULT 1,
  id_post BIGINT NOT NULL DEFAULT 1,
  body MEDIUMTEXT NOT NULL,
  PRIMARY KEY (id_comment),
  INDEX fk_comment_post1_idx (id_post ASC) VISIBLE,
  CONSTRAINT fk_comment_proffessional1
    FOREIGN KEY (id_proffessional)
    REFERENCES linkeDIn.proffessional (id_proffessional)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comment_post1
    FOREIGN KEY (id_post)
    REFERENCES linkeDIn.post (id_post)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.picture
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.picture ;

CREATE TABLE IF NOT EXISTS linkeDIn.picture (
  id_picture BIGINT NOT NULL AUTO_INCREMENT,
  picture_dir TINYTEXT NOT NULL,
  id_post BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_picture),
  INDEX fk_picture_post1_idx (id_post ASC) VISIBLE,
  CONSTRAINT fk_picture_post1
    FOREIGN KEY (id_post)
    REFERENCES linkeDIn.post (id_post)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table linkeDIn.video
-- -----------------------------------------------------
DROP TABLE IF EXISTS linkeDIn.video ;

CREATE TABLE IF NOT EXISTS linkeDIn.video (
  id_video BIGINT NOT NULL AUTO_INCREMENT,
  video_dir TINYTEXT NOT NULL,
  id_post BIGINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id_video),
  INDEX fk_video_post1_idx (id_post ASC) VISIBLE,
  CONSTRAINT fk_video_post1
    FOREIGN KEY (id_post)
    REFERENCES linkeDIn.post (id_post)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
