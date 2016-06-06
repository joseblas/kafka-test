package org.reactive.mvc.service;

import org.reactive.mvc.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev on 20/05/16.
 */
public interface OrderRepository extends CrudRepository<Order, String> {}
