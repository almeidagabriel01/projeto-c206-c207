-- Gabriel Almeida Dias - 145
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema RedeFaculdade
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema RedeFaculdade
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RedeFaculdade` DEFAULT CHARACTER SET utf8 ;
USE `RedeFaculdade` ;

-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Diretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Diretor` (
  `idDiretor` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Idade` INT NOT NULL,
  `Cpf` VARCHAR(11) NULL,
  PRIMARY KEY (`idDiretor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Faculdade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Faculdade` (
  `idFaculdade` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Endereço` VARCHAR(60) NOT NULL,
  `Telefone` VARCHAR(20) NULL,
  `Diretor_idDiretor` INT NOT NULL,
  PRIMARY KEY (`idFaculdade`),
  INDEX `fk_Faculdade_Diretor_idx` (`Diretor_idDiretor` ASC) VISIBLE,
  CONSTRAINT `fk_Faculdade_Diretor`
    FOREIGN KEY (`Diretor_idDiretor`)
    REFERENCES `RedeFaculdade`.`Diretor` (`idDiretor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Cursos` (
  `idCursos` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Faculdade_idFaculdade` INT NOT NULL,
  PRIMARY KEY (`idCursos`),
  INDEX `fk_Cursos_Faculdade1_idx` (`Faculdade_idFaculdade` ASC) VISIBLE,
  CONSTRAINT `fk_Cursos_Faculdade1`
    FOREIGN KEY (`Faculdade_idFaculdade`)
    REFERENCES `RedeFaculdade`.`Faculdade` (`idFaculdade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Alunos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Alunos` (
  `Matrícula` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Idade` INT NOT NULL,
  `Período` INT NOT NULL,
  `Cursos_idCursos` INT NOT NULL,
  PRIMARY KEY (`Matrícula`),
  INDEX `fk_Alunos_Cursos1_idx` (`Cursos_idCursos` ASC) VISIBLE,
  CONSTRAINT `fk_Alunos_Cursos1`
    FOREIGN KEY (`Cursos_idCursos`)
    REFERENCES `RedeFaculdade`.`Cursos` (`idCursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Professor` (
  `idProfessor` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Idade` INT NOT NULL,
  `CursoDeFormação` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfessor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Professor_Trabalha_Faculdade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Professor_Trabalha_Faculdade` (
  `Professor_idProfessor` INT NOT NULL,
  `Faculdade_idFaculdade` INT NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`, `Faculdade_idFaculdade`),
  INDEX `fk_Professor_has_Faculdade_Faculdade1_idx` (`Faculdade_idFaculdade` ASC) VISIBLE,
  INDEX `fk_Professor_has_Faculdade_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_has_Faculdade_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `RedeFaculdade`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Faculdade_Faculdade1`
    FOREIGN KEY (`Faculdade_idFaculdade`)
    REFERENCES `RedeFaculdade`.`Faculdade` (`idFaculdade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RedeFaculdade`.`Professor_LecionaPara_Alunos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RedeFaculdade`.`Professor_LecionaPara_Alunos` (
  `Alunos_Matrícula` INT NOT NULL,
  `Professor_idProfessor` INT NOT NULL,
  PRIMARY KEY (`Alunos_Matrícula`, `Professor_idProfessor`),
  INDEX `fk_Alunos_has_Professor_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  INDEX `fk_Alunos_has_Professor_Alunos1_idx` (`Alunos_Matrícula` ASC) VISIBLE,
  CONSTRAINT `fk_Alunos_has_Professor_Alunos1`
    FOREIGN KEY (`Alunos_Matrícula`)
    REFERENCES `RedeFaculdade`.`Alunos` (`Matrícula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alunos_has_Professor_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `RedeFaculdade`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
