package com.redesocial.RedeSocial.repository;

import com.redesocial.RedeSocial.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
