/*4)----------------------------------------------*/

/*DELETE FROM pricelist 
  WHERE price BETWEEN '10' AND '30';*/

/*DELETE FROM pricelist 
  WHERE price > '90';*/

/*UPDATE sellers s SET s.name='ИП Соколов'
  WHERE s.name LIKE 'ИП Петров'*/

/*UPDATE sellers s SET s.name='ИП Иваньков'
  WHERE s.name LIKE 'ИП И%'*/

/*5)----------------------------------------------*/

/*SELECT m.name AS 'Производители', m1.name AS 'Модели'
  FROM makers m, models m1
  WHERE m.name = 'LG' AND m.id=m1.maker_id;*/

/*SELECT m.name AS 'Производители', m1.name AS 'Модели', p.price AS 'Цена'
  FROM makers m, models m1, pricelist p
  WHERE p.price BETWEEN '40' AND '70' AND m.id=m1.maker_id AND p.maker_id=m.id AND p.model_id=m1.id;*/

/*SELECT * 
  FROM (SELECT m.name AS 'Производители', m1.name AS 'Модели', p.price AS 'Цена'
        FROM makers m, models m1, pricelist p
        WHERE p.price BETWEEN '40' AND '70' AND m.id=m1.maker_id AND p.maker_id=m.id AND p.model_id=m1.id) n
  WHERE n.Цена > '50';*/

/*6)----------------------------------------------*/

/*ALTER TABLE pricelist DROP FOREIGN KEY FK_pricelist_goods_id;
ALTER TABLE pricelist DROP FOREIGN KEY FK_pricelist_makers_id;
ALTER TABLE pricelist DROP FOREIGN KEY FK_pricelist_models_id;
ALTER TABLE pricelist DROP FOREIGN KEY FK_pricelist_sellers_id;
ALTER TABLE models DROP FOREIGN KEY FK_models_makers_id;

DROP TABLE goods, makers, models, sellers, pricelist;*/

