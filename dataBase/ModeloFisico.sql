-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BdM3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BdM3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BdM3` ;
USE `BdM3` ;

-- -----------------------------------------------------
-- Table `BdM3`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BdM3`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(45) NULL,
  `DataNascimento` DATE NULL,
  `Cep` VARCHAR(45) NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BdM3`.`PacoteDeViagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BdM3`.`PacoteDeViagem` (
  `idPacote` INT NOT NULL AUTO_INCREMENT,
  `Destino` VARCHAR(45) NOT NULL,
  `Descricao` VARCHAR(200) NULL,
  `DuracaoEmDias` INT NOT NULL,
  `Preco` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idPacote`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BdM3`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BdM3`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NULL,
  `DataReserva` DATE NOT NULL,
  `DataViagem` DATE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `PacoteDeViagem_idPacote` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Reserva_PacoteDeViagem1_idx` (`PacoteDeViagem_idPacote` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `BdM3`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_PacoteDeViagem1`
    FOREIGN KEY (`PacoteDeViagem_idPacote`)
    REFERENCES `BdM3`.`PacoteDeViagem` (`idPacote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BdM3`.`Contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BdM3`.`Contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT,
  `Assunto` VARCHAR(45) NULL,
  `Mensagem` VARCHAR(300) NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idContato`),
  INDEX `fk_InteracoesClienteEmpresa_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_InteracoesClienteEmpresa_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `BdM3`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
