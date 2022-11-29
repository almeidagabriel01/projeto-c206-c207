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
  `celular` INT NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Empréstimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Empréstimo` (
  `idEmpréstimo` INT NOT NULL AUTO_INCREMENT,
  `dataEmpréstimo` DATE NOT NULL,
  `dataDevolução` DATE NOT NULL,
  `itens` VARCHAR(100) NOT NULL,
  `qtdRenovados` INT NOT NULL,
  PRIMARY KEY (`idEmpréstimo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Conta` (
  `idConta` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(40) NOT NULL,
  `Usuário_cpf` VARCHAR(11) NOT NULL,
  `Empréstimo_idEmpréstimo` INT NOT NULL,
  PRIMARY KEY (`idConta`),
  INDEX `fk_Conta_Usuário_idx` (`Usuário_cpf` ASC) VISIBLE,
  INDEX `fk_Conta_Empréstimo1_idx` (`Empréstimo_idEmpréstimo` ASC) VISIBLE,
  CONSTRAINT `fk_Conta_Usuário`
    FOREIGN KEY (`Usuário_cpf`)
    REFERENCES `Biblioteca`.`Usuário` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_Empréstimo1`
    FOREIGN KEY (`Empréstimo_idEmpréstimo`)
    REFERENCES `Biblioteca`.`Empréstimo` (`idEmpréstimo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Acervo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Acervo` (
  `idAcervo` INT NOT NULL AUTO_INCREMENT,
  `numRegistro` INT NOT NULL,
  `cdu` VARCHAR(45) NOT NULL,
  `título` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAcervo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Conta_reserva_Acervo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Conta_reserva_Acervo` (
  `Acervo_idAcervo` INT NOT NULL,
  `Conta_idConta` INT NOT NULL,
  PRIMARY KEY (`Acervo_idAcervo`, `Conta_idConta`),
  INDEX `fk_Acervo_has_Conta_Conta1_idx` (`Conta_idConta` ASC) VISIBLE,
  INDEX `fk_Acervo_has_Conta_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  CONSTRAINT `fk_Acervo_has_Conta_Acervo1`
    FOREIGN KEY (`Acervo_idAcervo`)
    REFERENCES `Biblioteca`.`Acervo` (`idAcervo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acervo_has_Conta_Conta1`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `Biblioteca`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`Livro` (
  `idLivro` INT NOT NULL AUTO_INCREMENT,
  `autor` VARCHAR(100) NOT NULL,
  `editora` VARCHAR(100) NOT NULL,
  `edição` VARCHAR(100) NOT NULL,
  `Conta_idConta` INT NOT NULL,
  `Acervo_idAcervo` INT NOT NULL,
  PRIMARY KEY (`idLivro`),
  INDEX `fk_Livro_Conta1_idx` (`Conta_idConta` ASC) VISIBLE,
  INDEX `fk_Livro_Acervo1_idx` (`Acervo_idAcervo` ASC) VISIBLE,
  CONSTRAINT `fk_Livro_Conta1`
    FOREIGN KEY (`Conta_idConta`)
    REFERENCES `Biblioteca`.`Conta` (`idConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
