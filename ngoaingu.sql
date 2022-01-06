-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2022 at 08:23 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ngoaingu`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhsachphongthi`
--

CREATE TABLE `danhsachphongthi` (
  `thi_sinh_id` int(11) NOT NULL,
  `phong_thi_id` int(11) NOT NULL,
  `so_bao_danh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nghe` float NOT NULL,
  `noi` float NOT NULL,
  `doc` float NOT NULL,
  `viet` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danhsachphongthi`
--

INSERT INTO `danhsachphongthi` (`thi_sinh_id`, `phong_thi_id`, `so_bao_danh`, `nghe`, `noi`, `doc`, `viet`) VALUES
(3, 4, 'A2001', 8, 5, 4, 3),
(5, 4, 'A2002', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `khoathi`
--

CREATE TABLE `khoathi` (
  `khoa_thi_id` int(11) NOT NULL,
  `ngay_bat_dau` datetime(6) DEFAULT NULL,
  `ten_khoa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khoathi`
--

INSERT INTO `khoathi` (`khoa_thi_id`, `ngay_bat_dau`, `ten_khoa`) VALUES
(1, '2022-01-06 00:00:00.000000', 'K18'),
(2, '2022-01-13 00:00:00.000000', 'K18'),
(3, '2022-01-13 00:00:00.000000', 'K19');

-- --------------------------------------------------------

--
-- Table structure for table `phieudangky`
--

CREATE TABLE `phieudangky` (
  `thi_sinh_id` int(11) NOT NULL,
  `khoa_thi_id` int(11) NOT NULL,
  `trinh_do` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_dang_ky` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieudangky`
--

INSERT INTO `phieudangky` (`thi_sinh_id`, `khoa_thi_id`, `trinh_do`, `ngay_dang_ky`) VALUES
(3, 2, 'A2', '2022-01-05 00:00:00'),
(4, 1, 'A2', '2022-01-07 00:00:00'),
(5, 2, 'A2', '2022-01-04 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE `phongthi` (
  `phong_thi_id` int(11) NOT NULL,
  `ten_phong_thi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khoa_thi_id` int(11) NOT NULL,
  `trinh_do` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gio_thi` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phongthi`
--

INSERT INTO `phongthi` (`phong_thi_id`, `ten_phong_thi`, `khoa_thi_id`, `trinh_do`, `so_luong`, `gio_thi`) VALUES
(2, 'A2P002', 3, 'A2', 0, ''),
(3, 'B1P003', 1, 'B1', 0, ''),
(4, 'A2P004', 2, 'A2', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `thisinh`
--

CREATE TABLE `thisinh` (
  `thi_sinh_id` int(11) NOT NULL,
  `cmnd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ho_ten` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay_sinh` datetime(6) DEFAULT NULL,
  `noi_sinh` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thisinh`
--

INSERT INTO `thisinh` (`thi_sinh_id`, `cmnd`, `email`, `ho_ten`, `ngay_sinh`, `noi_sinh`, `sdt`) VALUES
(1, '256329856231', 'haihuong306@gmail.com', 'Hải Hương', '2021-07-13 00:00:00.000000', 'Hà Nội', '235698526'),
(2, '2365923156', 'nhi@gmail.com', 'Nhi', '2000-06-06 00:00:00.000000', 'Hà Nội', '325698231'),
(3, '2563256239', 'huyen@gmail.com', 'C.Huyền', '2000-09-12 00:00:00.000000', 'Đồng Nai', '0256398426'),
(4, '2568923026', 'my@gmail.com', 'Tiểu My', '2000-01-02 00:00:00.000000', 'TP.HCM', '0235689236'),
(5, '2568952369', 'huong@gmail.com', 'Hải Hương', '2000-11-24 00:00:00.000000', 'Lâm Đồng', '0235689536');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhsachphongthi`
--
ALTER TABLE `danhsachphongthi`
  ADD KEY `FKgus0f1wtcs3o71xnyhudp0ugy` (`phong_thi_id`),
  ADD KEY `FKf7shngckdd37vnnp2w5t8h3ts` (`thi_sinh_id`);

--
-- Indexes for table `khoathi`
--
ALTER TABLE `khoathi`
  ADD PRIMARY KEY (`khoa_thi_id`);

--
-- Indexes for table `phieudangky`
--
ALTER TABLE `phieudangky`
  ADD KEY `fk_group1` (`thi_sinh_id`),
  ADD KEY `fk_group2` (`khoa_thi_id`);

--
-- Indexes for table `phongthi`
--
ALTER TABLE `phongthi`
  ADD PRIMARY KEY (`phong_thi_id`),
  ADD KEY `fk_group` (`khoa_thi_id`);

--
-- Indexes for table `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`thi_sinh_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `danhsachphongthi`
--
ALTER TABLE `danhsachphongthi`
  ADD CONSTRAINT `FKf7shngckdd37vnnp2w5t8h3ts` FOREIGN KEY (`thi_sinh_id`) REFERENCES `thisinh` (`thi_sinh_id`),
  ADD CONSTRAINT `FKgus0f1wtcs3o71xnyhudp0ugy` FOREIGN KEY (`phong_thi_id`) REFERENCES `phongthi` (`phong_thi_id`);

--
-- Constraints for table `phieudangky`
--
ALTER TABLE `phieudangky`
  ADD CONSTRAINT `fk_group1` FOREIGN KEY (`thi_sinh_id`) REFERENCES `thisinh` (`thi_sinh_id`),
  ADD CONSTRAINT `fk_group2` FOREIGN KEY (`khoa_thi_id`) REFERENCES `khoathi` (`khoa_thi_id`);

--
-- Constraints for table `phongthi`
--
ALTER TABLE `phongthi`
  ADD CONSTRAINT `fk_group` FOREIGN KEY (`khoa_thi_id`) REFERENCES `khoathi` (`khoa_thi_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
