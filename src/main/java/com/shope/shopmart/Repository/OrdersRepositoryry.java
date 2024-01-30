package com.shope.shopmart.Repository;

import com.shope.shopmart.Entities.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepositoryry  extends JpaRepository<Orders, Integer> {
}
