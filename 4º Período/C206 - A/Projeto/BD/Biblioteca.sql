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
-- Table `Biblioteca`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Usuario` (
  `idUsuario` INT AUTO_INCREMENT,
  `cpf` VARCHAR(12) NOT NULL,
  `nomeCompleto` VARCHAR(100) NOT NULL,
  `idade` INT NOT NULL,
  `celular` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Conta` (
  `idConta` INT AUTO_INCREMENT,
  `user` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(40) NOT NULL,
  `Usuario_idUsuario` INT,
  PRIMARY KEY (`idConta`),
  CONSTRAINT `fk_Conta_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Biblioteca`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Acervo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Acervo` (
  `idAcervo` INT AUTO_INCREMENT,
  `cdu` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAcervo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Livro` (
  `idLivro` INT AUTO_INCREMENT,
  `autor` VARCHAR(100) NOT NULL,
  `editora` VARCHAR(100) NOT NULL,
  `edição` VARCHAR(100) NOT NULL,
  `Acervo_idAcervo` INT,
  PRIMARY KEY (`idLivro`),
  CONSTRAINT `fk_Livro_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Revista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Revista` (
  `idRevista` INT AUTO_INCREMENT,
  `editora` VARCHAR(100) NOT NULL,
  `ano` INT NOT NULL,
  `Acervo_idAcervo` INT NULL,
  PRIMARY KEY (`idRevista`),
  CONSTRAINT `fk_Revista_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Artigo` (
  `idArtigo` INT AUTO_INCREMENT,
  `autor` VARCHAR(100) NOT NULL,
  `Acervo_idAcervo` INT,
  PRIMARY KEY (`idArtigo`),
  CONSTRAINT `fk_Artigo_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Acervo_fazEmprestimo_Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Acervo_fazEmprestimo_Conta` (
  `Conta_idConta` INT,
  `Acervo_idAcervo` INT,
  `user` VARCHAR(30) NOT NULL,
  `dataEmprestimo` VARCHAR(30) NOT NULL,
  `dataDevolucao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Conta_idConta`, `Acervo_idAcervo`),
  CONSTRAINT `fk_Conta_has_Acervo_Conta1`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `Biblioteca`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_has_Acervo_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
