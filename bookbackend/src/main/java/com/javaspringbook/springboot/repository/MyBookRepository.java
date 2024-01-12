package com.javaspringbook.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringbook.springboot.entity.MyBookList;

public interface MyBookRepository  extends JpaRepository<MyBookList,Integer> {

}
