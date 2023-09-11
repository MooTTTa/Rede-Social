package com.redesocial.RedeSocial.repository;

import com.redesocial.RedeSocial.domain.Coment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentReposiroty extends MongoRepository<Coment, Long> {
}
