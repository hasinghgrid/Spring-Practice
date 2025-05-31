package com.springpractice.spring_web_app.repositories;

import com.springpractice.spring_web_app.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
