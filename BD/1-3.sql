--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 7.1.31.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 19.04.2019 17:21:59
-- Версия сервера: 5.5.61
-- Версия клиента: 4.1
--


-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
USE price;

--
-- Описание для таблицы goods
--
DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 9
AVG_ROW_LENGTH = 2048
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Товары';

--
-- Описание для таблицы makers
--
DROP TABLE IF EXISTS makers;
CREATE TABLE makers (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  country VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 6
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Изготовители ';

--
-- Описание для таблицы sellers
--
DROP TABLE IF EXISTS sellers;
CREATE TABLE sellers (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  address VARCHAR(255) DEFAULT NULL,
  telephone VARCHAR(255) DEFAULT NULL,
  site VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 6
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Продавцы';

--
-- Описание для таблицы models
--
DROP TABLE IF EXISTS models;
CREATE TABLE models (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  maker_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_models_makers_id FOREIGN KEY (maker_id)
    REFERENCES makers(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 9
AVG_ROW_LENGTH = 2048
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Модели';

--
-- Описание для таблицы pricelist
--
DROP TABLE IF EXISTS pricelist;
CREATE TABLE pricelist (
  id INT(11) NOT NULL AUTO_INCREMENT,
  seller_id INT(11) DEFAULT NULL,
  maker_id INT(11) DEFAULT NULL,
  goods_id INT(11) DEFAULT NULL,
  model_id INT(11) DEFAULT NULL,
  price DECIMAL(10, 2) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_pricelist_goods_id FOREIGN KEY (goods_id)
    REFERENCES goods(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_pricelist_makers_id FOREIGN KEY (maker_id)
    REFERENCES makers(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_pricelist_models_id FOREIGN KEY (model_id)
    REFERENCES models(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_pricelist_sellers_id FOREIGN KEY (seller_id)
    REFERENCES sellers(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 11
AVG_ROW_LENGTH = 1638
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Прайс';

-- 
-- Вывод данных для таблицы goods
--
INSERT INTO goods VALUES
(1, 'Винчестер'),
(2, 'Материнская плата'),
(3, 'Оперативная память'),
(4, 'Видеокарта'),
(5, 'Процессор'),
(6, 'Блок питания'),
(7, 'Корпус'),
(8, 'Система охлаждения');

-- 
-- Вывод данных для таблицы makers
--
INSERT INTO makers VALUES
(1, 'LG', 'Китай'),
(2, 'Samsung', 'Китай'),
(3, 'Gigabyte', 'Китай'),
(4, 'Asus ', 'Китай'),
(5, 'MSI', 'Китай');

-- 
-- Вывод данных для таблицы sellers
--
INSERT INTO sellers VALUES
(1, 'ИП Иванов', 'ул. Советская 27', '+375291234568', 'www.ivanov.by'),
(2, 'ИП Сидоров', 'ул. Барыкина 13', '+372337896524', 'www.sidorov.by'),
(3, 'ИП Петров', 'ул. Первомайская 36', '+375294569824', 'www.petrov.by'),
(4, 'ИП Шувалов', 'ул. Крестьянская 46', '+375293698597', 'www.shuvalov.by'),
(5, 'ИП Козлов', 'ул. Кожара 39', '+375295369214', 'www.kozlov.net');

-- 
-- Вывод данных для таблицы models
--
INSERT INTO models VALUES
(1, 'GH-12132HU', 2),
(2, 'KUK98I9K-FI', 1),
(3, 'SSIIW-3', 5),
(4, '34JO89JK-34', 2),
(5, 'LYH790HI7', 4),
(6, 'HUG6868GJ', 3),
(7, 'KUG86KG665', 1),
(8, 'GDSFTS856H', 2);

-- 
-- Вывод данных для таблицы pricelist
--
INSERT INTO pricelist VALUES
(1, 1, 1, 1, 2, 20.00),
(2, 2, 2, 6, 1, 30.00),
(3, 3, 3, 2, 6, 40.00),
(4, 4, 4, 2, 5, 35.00),
(5, 5, 5, 4, 3, 90.00),
(6, 4, 4, 4, 5, 100.00),
(7, 3, 2, 1, 8, 45.00),
(8, 2, 5, 2, 3, 55.00),
(9, 1, 1, 3, 7, 70.00),
(10, 3, 2, 8, 8, 75.00);

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;