-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 03 Haz 2022, 15:23:37
-- Sunucu sürümü: 8.0.29
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `personel_kayit_otomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `finans`
--

CREATE TABLE `finans` (
  `fid` int NOT NULL,
  `madi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msoyadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` date NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(6) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` int NOT NULL,
  `yadres` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mLisans` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mOrtalama` double NOT NULL,
  `mail` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `cinsiyet` char(7) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Erp` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `excel` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `calismasaati` char(6) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `modul` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `girisimfikirleri`
--

CREATE TABLE `girisimfikirleri` (
  `id` int NOT NULL,
  `adi` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soyadi` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Fikri` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `İletisim` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `girisimfikirleri`
--

INSERT INTO `girisimfikirleri` (`id`, `adi`, `soyadi`, `Fikri`, `İletisim`) VALUES
(1, 'Burak', 'Cila', 'Kuantum Bilgisayarlar ile veri madenciliği yaparak çok buyuk bir yatırım yapabilirsiniz', ''),
(2, 'ismail', 'ozdogan', '05374584420', 'dsafdfds'),
(3, 'bahadır', 'tez', 'mfodsgfd', '0537458440'),
(4, 'ismail', 'ozdoagan', 'fdsgfdoıgıfodgfd', ''),
(5, 'halilibrahim', 'hocamız', 'gfdgfdgfd', '432432'),
(6, 'bahadır', 'tezcan', 'sadsadsa', '053755d'),
(7, 'ismail', 'ozdogan', 'gfdgfdgfd', '0534'),
(8, 'AYLİN', 'SEL', 'dvgfdgfdgfd', '41421'),
(9, 'Sena', 'OZ', 'gfdgfdgfd', '0537526'),
(10, 'akif', 'ersoy', 'mlkmllglfhgf', '196553'),
(11, 'pelin', 'oz', 'dsafdsgfdgfd', '5656'),
(12, 'şidfsfds', 'dfsfds', 'gfdhgfghf', '321'),
(13, 'iso', 'öz', 'ghfhgfhgf', '6464'),
(14, 'isa', 'fsdf', 'gfhgfhgf', '241421');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `guvenlik`
--

CREATE TABLE `guvenlik` (
  `yid` int NOT NULL,
  `yadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ysoyadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(17) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` int NOT NULL,
  `yadres` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Egitim` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Cinsiyet` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Ehliyet` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soru1` char(6) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soru2` char(6) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soru3` char(6) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mail` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `guvenlik`
--

INSERT INTO `guvenlik` (`yid`, `yadi`, `ysoyadi`, `ydogumtarihi`, `ykimlik`, `ytelefon`, `ymedenihal`, `ymaas`, `yadres`, `Egitim`, `Cinsiyet`, `Ehliyet`, `soru1`, `soru2`, `soru3`, `mail`) VALUES
(18, 'dsadsa', 'ozodagan', '15.06.2022', '12345678900', '12345678900', 'Bekar', 2222, 'dsa', 'lise', 'Erkek', 'a1', 'Evet', 'Hayır', 'Evet', 'dsa');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `isealinanlar`
--

CREATE TABLE `isealinanlar` (
  `id` int NOT NULL,
  `adi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `soyadi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mail` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `SirketAdi` varchar(19) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `meslek` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `isealinanlar`
--

INSERT INTO `isealinanlar` (`id`, `adi`, `soyadi`, `mail`, `SirketAdi`, `meslek`) VALUES
(27, 'BAHADIR', 'TEZ', 'mail', 'Tc kimlik', 'MIMARLIK'),
(28, 'Ali', 'yıldırım', 'mail', 'isteedutr', 'FINANS'),
(29, 'Yakup', 'Kutlu', 'mail', 'isteedu', 'FINANS'),
(30, 'halil', 'ekin', 'mail', 'Tc kimlik', 'MIMARLIK'),
(31, 'AYŞE', 'FATMA', 'mail', 'Tc kimlik', 'MIMARLIK'),
(32, 'ISMAIL', 'OZDOGAN', 'mail', 'Tc kimlik', 'MIMARLIK'),
(33, 'BAHADIR', 'BABACAN', 'mail', 'isteedutr', 'FINANS');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kayit`
--

CREATE TABLE `kayit` (
  `id` int NOT NULL,
  `kuladi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `tc` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `kayit`
--

INSERT INTO `kayit` (`id`, `kuladi`, `sifre`, `tc`) VALUES
(6, 'is@iste.com', '2d20da708fffc650ea7888fc51a569cbdb952f6f', '1234656'),
(7, 'ismail@iste.com', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '48640641306');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `Kullaniciadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `mimarlik`
--

CREATE TABLE `mimarlik` (
  `mid` int NOT NULL,
  `Fakulte` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `madi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msoyadi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` int NOT NULL,
  `yadres` varchar(70) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mLisans` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mOrtalama` double NOT NULL,
  `mtecrube` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `yalan` varchar(70) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msorgu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `brans` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `mimarlik`
--

INSERT INTO `mimarlik` (`mid`, `Fakulte`, `madi`, `msoyadi`, `ydogumtarihi`, `ykimlik`, `ytelefon`, `ymedenihal`, `ymaas`, `yadres`, `mLisans`, `mOrtalama`, `mtecrube`, `yalan`, `msorgu`, `brans`, `email`) VALUES
(16, 'Mimarlık', 'Gokhan can', 'Altan', '2.06.2022', '41123456789', '41123456789', 'evli', 32432, 'antakya', 'iste', 3.9, 'var', 'yapay zeka', 'uzman biligisayr öğretmeniyim', 'MIMAR', 'fds');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muhendislik`
--

CREATE TABLE `muhendislik` (
  `mid` int NOT NULL,
  `Fakulte` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `madi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msoyadi` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `yadres` varchar(70) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mLisans` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Stajyeri` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mOrtalama` double NOT NULL,
  `mtecrube` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `yalan` varchar(70) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msorgu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `brans` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogretmen`
--

CREATE TABLE `ogretmen` (
  `mid` int NOT NULL,
  `madi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msoyadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(17) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` int NOT NULL,
  `yadres` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mLisans` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mOrtalama` double NOT NULL,
  `Hangikesim` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `brans` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mail` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `ogretmen`
--

INSERT INTO `ogretmen` (`mid`, `madi`, `msoyadi`, `ydogumtarihi`, `ykimlik`, `ytelefon`, `ymedenihal`, `ymaas`, `yadres`, `mLisans`, `mOrtalama`, `Hangikesim`, `brans`, `mail`) VALUES
(6, 'Batuhan', 'kara', '22.06.2022', '48640641306', '05374584420', 'bekar', 12000, 'antaka yenice mahallesi', 'iskenderun teknik universitesi', 3, 'ILKOKUL', 'hayat', 'selim51@gmail.com'),
(7, 'Arif', 'öz', '21.06.2022', '4864561230', '5374584420', 'evli', 5000, 'niğde', 'Çukurova uni', 3.2, 'ILKOKUL', 'hayat', 'arif51@gmail.com'),
(9, 'Batuhan', 'kara', '21.06.2022', '48640641306', '5374584420', 'evli', 5000, 'niğde', 'Çukurova uni', 3.2, 'ILKOKUL', 'hayat', 'arif51@gmail.com'),
(13, 'gfd', 'gfd', '9.06.2022', '12345678900', '12345678900', 'evli', 222, 'dsa', 'dsa', 3, 'ILKOKUL', 'hayat', 'dsa');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `saglik`
--

CREATE TABLE `saglik` (
  `mid` int NOT NULL,
  `madi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `msoyadi` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` int NOT NULL,
  `yadres` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mLisans` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `mOrtalama` double NOT NULL,
  `mtecrube` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `brans` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `saglik`
--

INSERT INTO `saglik` (`mid`, `madi`, `msoyadi`, `ydogumtarihi`, `ykimlik`, `ytelefon`, `ymedenihal`, `ymaas`, `yadres`, `mLisans`, `mOrtalama`, `mtecrube`, `brans`) VALUES
(5, 'Selım', 'Ilgaz', '21.06.2022', '48640641380', '05374584420', 'bekar', 3000, 'Hatay/Antakya', 'İskenderun Teknik', 3.55, 'Yok', 'hemşire');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sirketlogin`
--

CREATE TABLE `sirketlogin` (
  `id` int NOT NULL,
  `Sirketadi` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `sirketlogin`
--

INSERT INTO `sirketlogin` (`id`, `Sirketadi`, `sifre`) VALUES
(2, 'isteedutr', 123);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yonetici`
--

CREATE TABLE `yonetici` (
  `yid` int NOT NULL,
  `yadi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ysoyadi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ydogumtarihi` text CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ykimlik` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytelefon` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymedenihal` char(5) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ymaas` double NOT NULL,
  `yadres` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `Egitim` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `ytecrube` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `yalan` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `yonetici`
--

INSERT INTO `yonetici` (`yid`, `yadi`, `ysoyadi`, `ydogumtarihi`, `ykimlik`, `ytelefon`, `ymedenihal`, `ymaas`, `yadres`, `Egitim`, `ytecrube`, `yalan`) VALUES
(23, 'AHMET', 'CAGLAN', '14.06.2004', '10079928556', '05379876353', 'bekar', 1000, 'CORUM GULLUCE MAHALLESI', 'ORTAOKUL', 'GARSONLUK\nINSAAT', 'INSAAT USTASI');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `finans`
--
ALTER TABLE `finans`
  ADD PRIMARY KEY (`fid`);

--
-- Tablo için indeksler `girisimfikirleri`
--
ALTER TABLE `girisimfikirleri`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `guvenlik`
--
ALTER TABLE `guvenlik`
  ADD PRIMARY KEY (`yid`);

--
-- Tablo için indeksler `isealinanlar`
--
ALTER TABLE `isealinanlar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `kayit`
--
ALTER TABLE `kayit`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `mimarlik`
--
ALTER TABLE `mimarlik`
  ADD PRIMARY KEY (`mid`);

--
-- Tablo için indeksler `muhendislik`
--
ALTER TABLE `muhendislik`
  ADD PRIMARY KEY (`mid`);

--
-- Tablo için indeksler `ogretmen`
--
ALTER TABLE `ogretmen`
  ADD PRIMARY KEY (`mid`);

--
-- Tablo için indeksler `saglik`
--
ALTER TABLE `saglik`
  ADD PRIMARY KEY (`mid`);

--
-- Tablo için indeksler `sirketlogin`
--
ALTER TABLE `sirketlogin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `yonetici`
--
ALTER TABLE `yonetici`
  ADD PRIMARY KEY (`yid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `finans`
--
ALTER TABLE `finans`
  MODIFY `fid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `girisimfikirleri`
--
ALTER TABLE `girisimfikirleri`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `guvenlik`
--
ALTER TABLE `guvenlik`
  MODIFY `yid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Tablo için AUTO_INCREMENT değeri `isealinanlar`
--
ALTER TABLE `isealinanlar`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Tablo için AUTO_INCREMENT değeri `kayit`
--
ALTER TABLE `kayit`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `mimarlik`
--
ALTER TABLE `mimarlik`
  MODIFY `mid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `muhendislik`
--
ALTER TABLE `muhendislik`
  MODIFY `mid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Tablo için AUTO_INCREMENT değeri `ogretmen`
--
ALTER TABLE `ogretmen`
  MODIFY `mid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `saglik`
--
ALTER TABLE `saglik`
  MODIFY `mid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `sirketlogin`
--
ALTER TABLE `sirketlogin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `yonetici`
--
ALTER TABLE `yonetici`
  MODIFY `yid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
