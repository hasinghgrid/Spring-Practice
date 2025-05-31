package com.springpractice.spring_web_app.repositories;

import com.springpractice.spring_web_app.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author , Long> {


}