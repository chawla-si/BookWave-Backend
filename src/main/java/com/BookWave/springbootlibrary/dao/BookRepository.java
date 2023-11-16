package com.BookWave.springbootlibrary.dao;

import com.BookWave.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
