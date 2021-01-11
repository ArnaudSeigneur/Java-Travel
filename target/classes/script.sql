-- MySQL dump 10.13  Distrib 5.6.43, for Linux (x86_64)
--
-- Host: localhost    Database: hbtravel

CREATE TABLE `Compagnie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Aeroport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Vol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateHeureDepart` datetime DEFAULT NULL,
  `dateHeureArrivee` datetime DEFAULT NULL,
  `prixEnEuros` float NOT NULL,
  `compagnie_id` bigint(20) DEFAULT NULL,
  `aeroport_depart_id` bigint(20) DEFAULT NULL,
  `aeroport_arrivee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9jw2p2qtn8sh2afxpkr7clr7` (`compagnie_id`),
  KEY `FKgqs9ct92nfu3kt9ggf6gcifle` (`aeroport_depart_id`),
  KEY `FKgqs9ct92nfu3kt9ghf6gcifle` (`aeroport_arrivee_id`),
  CONSTRAINT `FK9jw2p2qtn8sh2afxpkr7clr7` FOREIGN KEY (`compagnie_id`) REFERENCES `Compagnie` (`id`),
  CONSTRAINT `FKgqs9ct92nfu3kt9ggf6gcifle` FOREIGN KEY (`aeroport_depart_id`) REFERENCES `Aeroport` (`id`),
  CONSTRAINT `FKgqs9ct92nfu3kt9ghf6gcifle` FOREIGN KEY (`aeroport_arrivee_id`) REFERENCES `Aeroport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;