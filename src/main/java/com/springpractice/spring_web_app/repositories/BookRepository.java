package com.springpractice.spring_web_app.repositories;

import com.springpractice.spring_web_app.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
