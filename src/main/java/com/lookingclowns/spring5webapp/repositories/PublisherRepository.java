package com.lookingclowns.spring5webapp.repositories;

import com.lookingclowns.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
