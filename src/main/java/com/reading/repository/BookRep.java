package com.reading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading.entity.Book;

public interface BookRep extends JpaRepository<Book,Long> {

}
