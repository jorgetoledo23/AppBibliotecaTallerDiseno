-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 19:07:31
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appbiblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcategorias`
--

CREATE TABLE `tblcategorias` (
  `CategoriaId` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `Imagen` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblcategorias`
--

INSERT INTO `tblcategorias` (`CategoriaId`, `Nombre`, `Descripcion`, `Imagen`) VALUES
(1, 'Terror', 'Los mejores libros de thriller los encuentras aca!', 'foto_12194217062021'),
(2, 'Ciencia Ficcion', 'Los mejores libros de Ciencia los encuentras aca!', 'no-disponible.png'),
(3, 'Desarrollo Web', 'Los mejores libros de Desarrollo Web los encuentras aca!', 'no-disponible.png'),
(4, 'Accion', 'Los mejores libros de Accion los encuentras aca!', 'no-disponible.png'),
(5, 'Suspenso', 'Los mejores libros de Suspenso los encuentras aca!', 'no-disponible.png'),
(6, 'Romance', 'Los mejores libros de Romance los encuentras aca!', 'no-disponible.png'),
(7, 'Drama', 'Los mejores libros de Drama los encuentras aca!!', 'no-disponible.png'),
(8, 'Test', 'Test', 'foto_12150917062021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbllibros`
--

CREATE TABLE `tbllibros` (
  `LibroId` int(11) NOT NULL,
  `Titulo` varchar(100) DEFAULT NULL,
  `ISBN` varchar(100) DEFAULT NULL,
  `Imagen` varchar(100) DEFAULT NULL,
  `Autor` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Precio` int(11) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `enOferta` int(11) DEFAULT NULL,
  `PrecioOferta` int(11) DEFAULT NULL,
  `CategoriaId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblcategorias`
--
ALTER TABLE `tblcategorias`
  ADD PRIMARY KEY (`CategoriaId`);

--
-- Indices de la tabla `tbllibros`
--
ALTER TABLE `tbllibros`
  ADD PRIMARY KEY (`LibroId`),
  ADD KEY `fk_categoria_libro` (`CategoriaId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblcategorias`
--
ALTER TABLE `tblcategorias`
  MODIFY `CategoriaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tbllibros`
--
ALTER TABLE `tbllibros`
  MODIFY `LibroId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbllibros`
--
ALTER TABLE `tbllibros`
  ADD CONSTRAINT `fk_categoria_libro` FOREIGN KEY (`CategoriaId`) REFERENCES `tblcategorias` (`CategoriaId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
