package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.DeliveryType;

import java.util.List;

public interface DeliveryTypeDao {

    DeliveryType getOne(Long deliveryTypeId);

    List<DeliveryType> findAllDeliveryTypes();
}
