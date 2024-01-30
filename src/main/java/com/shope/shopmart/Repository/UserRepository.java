package com.shope.shopmart.Repository;

import com.shope.shopmart.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
