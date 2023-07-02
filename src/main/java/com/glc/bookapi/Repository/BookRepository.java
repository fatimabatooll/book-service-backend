package com.glc.bookapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.bookapi.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
