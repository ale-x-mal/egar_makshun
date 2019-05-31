-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
DROP DATABASE IF EXISTS shop;

CREATE DATABASE shop;

USE shop;

--
-- Описание для таблицы deliverytype
--
DROP TABLE IF EXISTS deliverytype;
CREATE TABLE deliverytype (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 3
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Тип доставки';

--
-- Описание для таблицы permission
--
DROP TABLE IF EXISTS permission;
CREATE TABLE permission (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 3
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Разрешения';

--
-- Описание для таблицы product
--
DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  price DECIMAL(19, 2) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 12
AVG_ROW_LENGTH = 1489
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Товар';

--
-- Описание для таблицы role
--
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Роль пользователя';

--
-- Описание для таблицы user
--
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  login VARCHAR(50) DEFAULT NULL,
  password VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 10
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Пользователи';

--
-- Описание для таблицы `order`
--
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  price DECIMAL(19, 2) DEFAULT NULL,
  quantity INT(6) DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  deliveryType_id INT(11) DEFAULT NULL,
  orderDate DATE DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_order_deliverytype_id FOREIGN KEY (deliveryType_id)
    REFERENCES deliverytype(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_order_user_id FOREIGN KEY (user_id)
    REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Заказ';

--
-- Описание для таблицы basket
--
DROP TABLE IF EXISTS basket;
CREATE TABLE basket (
  id INT(11) NOT NULL AUTO_INCREMENT,
  discount INT(3) DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_basket_user_id FOREIGN KEY (user_id)
    REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Корзина';

--
-- Описание для таблицы role_permission
--
DROP TABLE IF EXISTS role_permission;
CREATE TABLE role_permission (
  id INT(11) NOT NULL AUTO_INCREMENT,
  role_id INT(11) DEFAULT NULL,
  permission_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_role_permission_permission_id FOREIGN KEY (permission_id)
    REFERENCES permission(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_role_permission_role_id FOREIGN KEY (role_id)
    REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Таблица связи роли и разрешений';

--
-- Описание для таблицы user_role
--
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_id INT(11) DEFAULT NULL,
  role_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_user_role_role_id FOREIGN KEY (role_id)
    REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
    REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Таблица связи пользователя и роли';

--
-- Описание для таблицы basket_product
--
DROP TABLE IF EXISTS basket_product;
CREATE TABLE basket_product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  basket_id INT(11) DEFAULT NULL,
  product_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_basket_product_basket_id FOREIGN KEY (basket_id)
    REFERENCES basket(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_basket_product_product_id FOREIGN KEY (product_id)
    REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 8
AVG_ROW_LENGTH = 2340
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Таблица связи корзины и товара';

--
-- Описание для таблицы order_product
--
DROP TABLE IF EXISTS order_product;
CREATE TABLE order_product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  order_id INT(11) DEFAULT NULL,
  product_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_order_product_order_id FOREIGN KEY (order_id)
    REFERENCES `order`(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_order_product_product_id FOREIGN KEY (product_id)
    REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 9
AVG_ROW_LENGTH = 2048
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Таблица связи заказа и товара';

DELIMITER $$

--
-- Описание для функции testFunction
--
DROP FUNCTION IF EXISTS testFunction$$
CREATE DEFINER = 'root'@'localhost'
FUNCTION testFunction()
  RETURNS varchar(30) CHARSET utf8
  DETERMINISTIC
BEGIN
    DECLARE result varchar(30);
 
   
 SET result = 'Test function is OK!!!';
 
 RETURN (result); 
END
$$

DELIMITER ;

-- 
-- Вывод данных для таблицы deliverytype
--
INSERT INTO deliverytype VALUES
(1, 'delivery man'),
(2, 'in shop');

-- 
-- Вывод данных для таблицы permission
--
INSERT INTO permission VALUES
(1, 'readonly'),
(2, 'edit');

-- 
-- Вывод данных для таблицы product
--
INSERT INTO product VALUES
(1, 'HDD', 80.00),
(2, 'Оперативная память', 70.00),
(3, 'Мат. плата', 120.00),
(4, 'Видеокарта', 200.00),
(5, 'Процессор', 300.00),
(6, 'Блок питания', 80.00),
(7, 'Корпус', 30.00),
(8, 'SSD', 50.00),
(9, 'Монитор', 150.00),
(10, 'Клавиатура', 10.00),
(11, 'Мышь', 5.00);

-- 
-- Вывод данных для таблицы role
--
INSERT INTO role VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

-- 
-- Вывод данных для таблицы user
--
INSERT INTO user VALUES
(1, 'admin', 'admin'),
(2, 'petrov', '123'),
(3, 'sidorov', '1234'),
(4, 'ivanov', '12345');

-- 
-- Вывод данных для таблицы `order`
--
INSERT INTO `order` VALUES
(1, 234.00, 3, 1, 1, '2019-04-17'),
(2, 156.00, 5, 2, 2, '2019-05-03'),
(3, 23.00, 1, 3, 1, '2019-05-15');

-- 
-- Вывод данных для таблицы basket
--
INSERT INTO basket VALUES
(1, 5, 1),
(2, 3, 2),
(3, 10, 3);

-- 
-- Вывод данных для таблицы role_permission
--
INSERT INTO role_permission VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, NULL);

-- 
-- Вывод данных для таблицы user_role
--
INSERT INTO user_role VALUES
(1, 1, 2),
(2, 2, 2),
(3, 3, 2);

-- 
-- Вывод данных для таблицы basket_product
--
INSERT INTO basket_product VALUES
(1, 1, 3),
(2, 2, 5),
(3, 3, 8),
(4, 2, 4),
(5, 3, 11),
(6, 2, 9),
(7, 1, 7);

-- 
-- Вывод данных для таблицы order_product
--
INSERT INTO order_product VALUES
(1, 1, 7),
(2, 2, 2),
(3, 3, 9),
(4, 1, 4),
(5, 2, 6),
(6, 2, 8),
(7, 1, 11),
(8, 2, 3);
