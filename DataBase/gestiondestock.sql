-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2019 at 01:50 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestiondestock`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(3) NOT NULL,
  `matricule` varchar(30) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `quantité` varchar(4) DEFAULT NULL,
  `prix` varchar(5) DEFAULT NULL,
  `fournisseur` varchar(30) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `matricule`, `libelle`, `quantité`, `prix`, `fournisseur`, `date`) VALUES
(7, '9911773344', 'ARticle6', '66', '43', 'fournisseur2', '2018-12-18'),
(9, '1100229933', 'article5', '100', '50', 'fournisseur2', '2018-11-11'),
(19, '1256894312', 'article21', '96', '600', 'fournisseur9', '2018-10-08'),
(21, '3006187654', 'article7', '20', '33', 'Fournisseur1', '2018-10-25'),
(22, '229870511', 'article1', '10', '71', 'fournisseur2', '2018-10-27'),
(23, '1111995577', 'article4', '5', '28', 'fournisseur9', '2018-11-05'),
(24, '3336668881', 'Article3', '30', '43', 'frournisseur1', '2018-12-13'),
(25, '3665522991', 'Article8', '12', '39', 'fourisseur3', '2018-12-29'),
(26, '1427549033', 'article10', '34', '66', 'fournisseur 2', '2019-01-01'),
(27, '763409124', 'article12', '20', '53', 'fournisseur8', '2018-12-19');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(6) NOT NULL,
  `password` varchar(19) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'mehd'),
('admin', 'mehdi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `matricule` (`matricule`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
