package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.Product;

import java.util.List;

public interface ProductDao {

    Product getOne(Long productId);

    Product save(Product product);

    void remove(Long productId);

    List<Product> findAllProducts();

    List<Product> findAllProductsByOrder(Long orderId);

    List<Product> findAllProductsFromBasket(Long basketId);

}
