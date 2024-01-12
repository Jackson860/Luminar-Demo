package com.javaspringbook.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringbook.springboot.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
