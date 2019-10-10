
CREATE DATABASE gastoshormiga 

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscaPxCodGasto`(
pcodgasto CHAR(10))
BEGIN
select * from gasto where CodGasto like  concat(pcodgasto,'%');
END$$

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteGasto`(
pcodgasto CHAR(10))
BEGIN
delete from  gasto where CodGasto = pcodgasto;
END$$


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editGasto`(
pcodgasto CHAR(6),
pmontogasto varchar(45),
pfecha date,
phora time,
pcategoria VARCHAR(15),
pfrecdiaria VARCHAR(45)
)
BEGIN
update gasto set CodGasto= pcodgasto, MontoGasto=pmontogasto, Fecha=pfecha, Hora=phora, Categoria=pcategoria, FrecDiaria=pfrecdiaria
where CodGasto = pcodgasto;
END$$


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertGasto`(
pcodgasto CHAR(6),
pmontogasto varchar(45),
pfecha date,
phora time,
pcategoria VARCHAR(15),
pfrecdiaria VARCHAR(45))

BEGIN
insert into gasto(CodGasto,MontoGasto,Fecha,Hora,Categoria,FrecDiaria)
values (pcodgasto,pmontogasto,pfecha,phora,pcategoria,pfrecdiaria);

END$$




CREATE TABLE `Gasto` (
  `CodGasto` char(6) NOT NULL,
  `MontoGasto` varchar(45) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Categoria` varchar(15) NOT NULL,
  `FrecDiaria` varchar(45) NOT NULL,
  PRIMARY KEY (`CodGasto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Ingreso` (
  `CodIngreso` char(6) NOT NULL,
  `MontoIngreso` varchar(45) NOT NULL,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`CodIngreso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Saldo` (
  `CodSaldo` char(6) NOT NULL,
  `Monto` varchar(45) NOT NULL,
  `Fecha` date NOT NULL,
  `MontoGasto` varchar(45) NOT NULL,
  `MontoIngreso` varchar(45) NOT NULL,
  PRIMARY KEY (`CodSaldo`),
  FOREIGN KEY (MontoGasto) REFERENCES Gasto(MontoGasto),
  FOREIGN KEY (MontoIngreso) REFERENCES Ingreso(MontoIngreso)
) ;