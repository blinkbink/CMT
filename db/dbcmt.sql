-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: dbcmt
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `IDBarang` varchar(10) NOT NULL,
  `NamaBarang` varchar(300) NOT NULL,
  `Spesifikasi` text NOT NULL,
  `Stok` int(11) NOT NULL,
  `Satuan` varchar(50) NOT NULL,
  `Posisi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `IDCustomer` varchar(10) NOT NULL,
  `NamaCustomer` varchar(100) NOT NULL,
  `PenanggungJawab` varchar(50) NOT NULL,
  `Alamat` varchar(500) NOT NULL,
  `Telepon` varchar(100) NOT NULL,
  `Fax` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailinvoice`
--

DROP TABLE IF EXISTS `detailinvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailinvoice` (
  `IDDetailInvoice` int(11) NOT NULL AUTO_INCREMENT,
  `IDInvoice` varchar(30) NOT NULL,
  `Price` double NOT NULL,
  `Qty` int(11) NOT NULL,
  PRIMARY KEY (`IDDetailInvoice`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailinvoice`
--

LOCK TABLES `detailinvoice` WRITE;
/*!40000 ALTER TABLE `detailinvoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailinvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailquotation`
--

DROP TABLE IF EXISTS `detailquotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailquotation` (
  `IDDetailQuotation` int(11) NOT NULL AUTO_INCREMENT,
  `IDBarang` varchar(10) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Satuan` varchar(50) NOT NULL,
  `Harga` double NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`IDDetailQuotation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailquotation`
--

LOCK TABLES `detailquotation` WRITE;
/*!40000 ALTER TABLE `detailquotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailquotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailsuratjalan`
--

DROP TABLE IF EXISTS `detailsuratjalan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailsuratjalan` (
  `IDDetailSJ` int(11) NOT NULL AUTO_INCREMENT,
  `IDSuratJalan` varchar(30) NOT NULL,
  `IDBarang` varchar(10) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Satuan` varchar(30) NOT NULL,
  PRIMARY KEY (`IDDetailSJ`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailsuratjalan`
--

LOCK TABLES `detailsuratjalan` WRITE;
/*!40000 ALTER TABLE `detailsuratjalan` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailsuratjalan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `IDInvoice` varchar(30) NOT NULL,
  `Tanggal` date NOT NULL,
  `IDSuratJalan` varchar(30) NOT NULL,
  `Subtotal` double NOT NULL,
  `Discount` double NOT NULL,
  `Total` double NOT NULL,
  `VAT` double NOT NULL,
  `GrandTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pembelian`
--

DROP TABLE IF EXISTS `pembelian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pembelian` (
  `IDBeli` varchar(10) NOT NULL,
  `TanggalBeli` date NOT NULL,
  `IDSupplier` varchar(10) NOT NULL,
  `IDBarang` varchar(10) NOT NULL,
  `Qty` int(11) NOT NULL,
  `HargaBeli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pembelian`
--

LOCK TABLES `pembelian` WRITE;
/*!40000 ALTER TABLE `pembelian` DISABLE KEYS */;
/*!40000 ALTER TABLE `pembelian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotation` (
  `IDQuotation` varchar(30) NOT NULL,
  `Tanggal` date NOT NULL,
  `Proyek` varchar(300) NOT NULL,
  `IDCustomer` varchar(10) NOT NULL,
  `Subtotal` double NOT NULL,
  `KondisiHarga` text NOT NULL,
  `MasaPenawaran` text NOT NULL,
  `Pelaksanaan` text NOT NULL,
  `Pembayaran` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `IDSupplier` int(11) NOT NULL AUTO_INCREMENT,
  `NamaSupplier` varchar(45) DEFAULT NULL,
  `Alamat` varchar(45) DEFAULT NULL,
  `PenanggungJawab` varchar(45) DEFAULT NULL,
  `Kontak` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'iqbal','asdas','blink','08562144666');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suratjalan`
--

DROP TABLE IF EXISTS `suratjalan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suratjalan` (
  `IDSuratJalan` varchar(30) NOT NULL,
  `Tanggal` date NOT NULL,
  `IDCustomer` varchar(10) NOT NULL,
  `Proyek` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suratjalan`
--

LOCK TABLES `suratjalan` WRITE;
/*!40000 ALTER TABLE `suratjalan` DISABLE KEYS */;
/*!40000 ALTER TABLE `suratjalan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'blink','1234','admin'),(2,'sabila','sabila','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-06 21:55:16
