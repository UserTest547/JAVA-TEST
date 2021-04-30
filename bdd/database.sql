-- phpMyAdmin SQL Dump
-- version 4.0.2
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 29 Avril 2021 à 15:46
-- Version du serveur: 5.6.11-log
-- Version de PHP: 5.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `voiture_test`
--
create database voiture_test;


-- --------------------------------------------------------



--
-- Structure de la table `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUTILISATEUR` int(11) DEFAULT NULL,
  `IDVOITURE` int(11) DEFAULT NULL,
  `COMMENTAIRE` text NOT NULL,
  `DATECOMMENTAIRE` timestamp NOT NULL,
  `ETAT` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDUTILISATEUR` (`IDUTILISATEUR`),
  KEY `IDVOITURE` (`IDVOITURE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

--
-- Contenu de la table `commentaire`
--

INSERT INTO `commentaire` (`ID`, `IDUTILISATEUR`, `IDVOITURE`, `COMMENTAIRE`, `DATECOMMENTAIRE`, `ETAT`) VALUES
(1, 1, 1, 'Bonjour', '2021-04-24 10:21:57', 0),
(2, 1, 1, 'Et bienvenue', '2021-04-24 10:29:18', 0),
(3, 1, 2, 'Ok', '2021-04-24 10:29:42', 0),
(4, 3, 1, 'Merci', '2021-04-24 10:31:05', 0),
(5, 3, 2, 'ok', '2021-04-24 10:31:11', 0),
(6, 3, 4, '1st comms', '2021-04-24 10:31:33', 0),
(7, 1, 1, 'Bien', '2021-04-24 11:58:56', 0),
(8, 3, 2, 'Salut a vous!', '2021-04-24 12:35:05', 0),
(9, 3, 2, 'je suis intéressée', '2021-04-24 12:35:53', 0),
(10, 3, 3, 'Waouh?', '2021-04-24 12:36:36', 0),
(11, 3, 3, 'Quel belle voiture', '2021-04-24 12:36:58', 0),
(12, 3, 1, 'Intéressée', '2021-04-24 13:21:14', 0),
(13, 3, 5, 'Waouh', '2021-04-24 13:38:41', 0),
(14, 3, 5, 'Tres belle voiture!', '2021-04-24 13:39:16', 0),
(15, 2, 3, 'oui', '2021-04-24 13:42:05', 0),
(16, 2, 4, 'haha', '2021-04-24 13:42:24', 0),
(17, 2, 6, 'Wouah!', '2021-04-24 13:43:45', 0),
(18, 2, 8, 'Tres belle', '2021-04-24 13:47:15', 0),
(19, 2, 5, 'Oui vraiment', '2021-04-24 13:47:54', 0),
(20, 2, 5, 'Ca me plait', '2021-04-24 13:48:01', 0),
(21, 2, 10, 'Rien a dire pour celle la', '2021-04-24 13:48:40', 0),
(22, 1, 8, 'rien a dire\n', '2021-04-24 13:51:43', 0),
(23, 1, 9, 'nouvelle modele', '2021-04-24 13:51:59', 0),
(24, 1, 7, 'Wouaouuuu', '2021-04-24 13:52:14', 0),
(25, 1, 10, 'oui,haha', '2021-04-24 13:52:33', 0),
(26, 1, 2, 'moi aussi\n', '2021-04-24 13:54:29', 0),
(27, 1, 1, 'oui', '2021-04-24 17:42:12', 0),
(28, 1, 2, 'moi aussi', '2021-04-24 17:52:39', 0),
(29, 1, 2, 'mhhmm', '2021-04-24 17:54:46', 0),
(30, 1, 2, 'ok', '2021-04-24 19:48:17', 0),
(31, 1, 1, 'mhmm', '2021-04-24 19:48:25', 0),
(32, 1, 1, 'ok', '2021-04-24 19:48:33', 0),
(33, 1, 3, 'ok', '2021-04-29 08:31:08', 0),
(34, 1, 3, 'ok', '2021-04-29 08:32:04', 0),
(35, 1, 3, 'ok', '2021-04-29 08:32:34', 0),
(36, 1, 4, 'oui?', '2021-04-29 08:33:46', 0),
(37, 1, 4, 'yeah', '2021-04-29 08:35:36', 0),
(38, 1, 6, 'mhm', '2021-04-29 08:35:53', 0),
(39, 3, 1, 'dac', '2021-04-29 08:38:04', 0),
(40, 3, 3, 'yeah', '2021-04-29 08:38:15', 0),
(41, 3, 2, 'yes', '2021-04-29 08:38:22', 0),
(42, 2, 2, 'okey', '2021-04-29 08:44:30', 0),
(43, 2, 6, 'tres belle voiture', '2021-04-29 08:46:09', 0),
(44, 2, 4, 'Waouh', '2021-04-29 08:49:17', 0),
(45, 2, 5, 'oui ', '2021-04-29 08:49:59', 0),
(46, 2, 3, 'bien', '2021-04-29 08:51:57', 0),
(47, 1, 2, 'waouh', '2021-04-29 08:59:37', 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IDUTILISATEUR` int(11) NOT NULL,
  `NOM` varchar(100) NOT NULL,
  `PRENOM` varchar(100) NOT NULL,
  `LOGIN` varchar(100) NOT NULL,
  `MOTDEPASSE` varchar(100) NOT NULL,
  `ETAT` int(11) NOT NULL,
  PRIMARY KEY (`IDUTILISATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IDUTILISATEUR`, `NOM`, `PRENOM`, `LOGIN`, `MOTDEPASSE`, `ETAT`) VALUES
(1, 'Rakoto', 'Nirina', 'Rakoto', 'Rakoto', 0),
(2, 'Rasoa', 'Malala', 'Rasoa', 'Rasoa', 0),
(3, 'Rabe', 'Hery', 'Rabe', 'Rabe', 0);

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE IF NOT EXISTS `voiture` (
  `IDVOITURE` int(11) NOT NULL,
  `TYPEVOITURE` varchar(40) NOT NULL,
  `CATEGORIE` varchar(40) NOT NULL,
  `NUMERO` varchar(10) NOT NULL,
  `IMAGE` varchar(200) NOT NULL,
  `ETAT` int(11) NOT NULL,
  PRIMARY KEY (`IDVOITURE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `voiture`
--

INSERT INTO `voiture` (`IDVOITURE`, `TYPEVOITURE`, `CATEGORIE`, `NUMERO`, `IMAGE`, `ETAT`) VALUES
(1, 'PEUGEOT', 'Berlines', '0090 TC', 'voiture1.jpg', 0),
(2, 'GOLF GTI', 'Citadine', '0990 CC', 'voiture2.jpg', 0),
(3, 'Renault', 'Berline', '8894 TAC', 'voiture3.jpg', 0),
(4, 'TOYOTA', '4*4', '56739OP', 'voiture4.jpg', 0),
(5, 'BMW', 'Routiere', '67432 TBE', 'voiture5.jpg', 0),
(6, 'FORD', 'Citadine', '7564 TC', 'voiture6.jpg', 0),
(7, 'Audi', 'Berline', '67543AS', 'voiture7.jpg', 0),
(8, 'Mercedes', 'Routiere', '87548TR', 'voiture8.jpg', 0),
(9, 'NISSAN', 'Routiere', '943249F', 'voiture9.jpg', 0),
(10, 'Fiat', 'Routiere', 'Monospace', 'voiture10.jpg', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
