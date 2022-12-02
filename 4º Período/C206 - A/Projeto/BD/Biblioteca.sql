-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `Biblioteca` ;

-- -----------------------------------------------------
-- Table `Biblioteca`.`Usuário`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Usuário` (
  `cpf` VARCHAR(11) NOT NULL,
  `nomeCompleto` VARCHAR(100) NOT NULL,
  `idade` INT NOT NULL,
  `celular` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Conta` (
  `user` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(40) NOT NULL,
  `Usuário_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`user`),
  INDEX `fk_Conta_Usuário_idx` (`Usuário_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_Conta_Usuário`
    FOREIGN KEY (`Usuário_cpf`)
    REFERENCES `Biblioteca`.`Usuário` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Acervo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Acervo` (
  `idAcervo` INT NOT NULL AUTO_INCREMENT,
  `cdu` VARCHAR(45) NOT NULL,
  `título` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAcervo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Livro` (
  `idLivro` INT NOT NULL AUTO_INCREMENT,
  `autor` VARCHAR(100) NOT NULL,
  `editora` VARCHAR(100) NOT NULL,
  `edição` VARCHAR(100) NOT NULL,
  `Acervo_idAcervo` INT NOT NULL,
  PRIMARY KEY (`idLivro`),
  INDEX `fk_Livro_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Revista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Revista` (
  `idRevista` INT NOT NULL AUTO_INCREMENT,
  `editora` VARCHAR(100) NOT NULL,
  `ano` INT NOT NULL,
  `Acervo_idAcervo` INT NOT NULL,
  PRIMARY KEY (`idRevista`),
  INDEX `fk_Revista_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  CONSTRAINT `fk_Revista_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Artigo` (
  `idArtigo` INT NOT NULL AUTO_INCREMENT,
  `autor` VARCHAR(100) NOT NULL,
  `Acervo_idAcervo` INT NOT NULL,
  PRIMARY KEY (`idArtigo`),
  INDEX `fk_Artigo_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  CONSTRAINT `fk_Artigo_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Conta_fazEmpréstimo_Acervo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Conta_fazEmpréstimo_Acervo` (
  `Conta_user` VARCHAR(30) NOT NULL,
  `Acervo_idAcervo` INT NOT NULL,
  `dataEmpréstimo` VARCHAR(20) NOT NULL,
  `dataDevolução` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Conta_user`, `Acervo_idAcervo`),
  INDEX `fk_Conta_has_Acervo_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  INDEX `fk_Conta_has_Acervo_Conta1_idx` (`Conta_user` ASC) VISIBLE,
  CONSTRAINT `fk_Conta_has_Acervo_Conta1`
    FOREIGN KEY (`Conta_user`)
    REFERENCES `Biblioteca`.`Conta` (`user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_has_Acervo_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
