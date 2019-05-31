package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.Basket;
import org.egar.makshun.jdbc.model.Product;

import java.util.List;

public interface BasketDao {

    Basket getOne(Long basketId);

    List<Basket> findAllBaskets();

    Boolean addProductToBasket(Long productId, Long basketId);

    void removeProductFromBasket(Long productId, Long basketId);

}
