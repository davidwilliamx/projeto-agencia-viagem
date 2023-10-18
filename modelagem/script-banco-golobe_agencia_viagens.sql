-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema golobe_viagens
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema golobe_viagens
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `golobe_viagens` ;
USE `golobe_viagens` ;

-- -----------------------------------------------------
-- Table `golobe_viagens`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `golobe_viagens`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `enderecoCliente` VARCHAR(255) NOT NULL,
  `emailCliente` VARCHAR(145) NOT NULL,
  `telefoneCliente` VARCHAR(12) NOT NULL,
  `cpfCliente` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `cpfCliente_UNIQUE` (`cpfCliente` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `golobe_viagens`.`Destino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `golobe_viagens`.`Destino` (
  `idDestino` INT NOT NULL AUTO_INCREMENT,
  `cidadeDestino` VARCHAR(100) NOT NULL,
  `paisDestino` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idDestino`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `golobe_viagens`.`Pacote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `golobe_viagens`.`Pacote` (
  `idPacote` INT NOT NULL AUTO_INCREMENT,
  `nomePacote` VARCHAR(255) NOT NULL,
  `valorPacote` DOUBLE NOT NULL,
  `dataPartidaPacote` DATE NOT NULL,
  `dataRetornoPacote` DATE NOT NULL,
  `Destino_idDestino` INT NOT NULL,
  PRIMARY KEY (`idPacote`, `Destino_idDestino`),
  INDEX `fk_Pacote_Destino1_idx` (`Destino_idDestino` ASC) VISIBLE,
  CONSTRAINT `fk_Pacote_Destino1`
    FOREIGN KEY (`Destino_idDestino`)
    REFERENCES `golobe_viagens`.`Destino` (`idDestino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `golobe_viagens`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `golobe_viagens`.`Venda` (
  `idVenda` INT NOT NULL AUTO_INCREMENT,
  `valorVenda` DOUBLE NOT NULL,
  `dataVenda` DATE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Pacote_idPacote` INT NOT NULL,
  PRIMARY KEY (`idVenda`, `Cliente_idCliente`, `Pacote_idPacote`),
  INDEX `fk_Venda_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Venda_Pacote1_idx` (`Pacote_idPacote` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `golobe_viagens`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Pacote1`
    FOREIGN KEY (`Pacote_idPacote`)
    REFERENCES `golobe_viagens`.`Pacote` (`idPacote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
