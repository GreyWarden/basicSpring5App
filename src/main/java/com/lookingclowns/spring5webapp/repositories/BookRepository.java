package com.lookingclowns.spring5webapp.repositories;

import com.lookingclowns.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
