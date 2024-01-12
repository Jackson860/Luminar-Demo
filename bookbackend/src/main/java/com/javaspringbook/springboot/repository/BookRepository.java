package com.javaspringbook.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringbook.springboot.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
