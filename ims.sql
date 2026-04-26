-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2026 at 06:16 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` bigint(20) NOT NULL,
  `serial_number` varchar(255) NOT NULL,
  `device_type` varchar(255) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `date_added` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id`, `serial_number`, `device_type`, `brand`, `model`, `status`, `date_added`) VALUES
(1, '1234566543', 'Laptop', 'Dell', '2344', 'BROKEN', '2026-04-25'),
(2, '676543234', 'Mobile Phone', 'iphone', '3456', 'ASSIGNED', '2026-04-25'),
(4, '12342', 'Tablet', 'we', '2364', 'AVAILABLE', '2026-04-25'),
(5, '12344', 'Laptop', 'efgf', '1234', 'ASSIGNED', '2026-04-25');

-- --------------------------------------------------------

--
-- Table structure for table `system_users`
--

CREATE TABLE `system_users` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `system_users`
--

INSERT INTO `system_users` (`id`, `username`, `password`, `full_name`, `role`) VALUES
(1, '24rp01734', '24rp04260', 'DUFITUMUCUNGUZI Dieudonne', 'SYSADMIN'),
(2, '24rp04260', 'dufi123', 'DUFITITMANA Israel', 'IT_MANAGER'),
(4, '24rp01735', 'dieu123', 'Dieu', 'SUPPORT_STAFF'),
(5, '12345', 'test123', 'test', 'IT_MANAGER'),
(6, '54321', 'isra123', 'isra', 'SUPPORT_STAFF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `serial_number` (`serial_number`);

--
-- Indexes for table `system_users`
--
ALTER TABLE `system_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `system_users`
--
ALTER TABLE `system_users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
