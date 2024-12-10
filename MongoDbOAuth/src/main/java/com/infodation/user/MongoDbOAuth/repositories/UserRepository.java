package com.infodation.user.MongoDbOAuth.repositories;

import com.infodation.user.MongoDbOAuth.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User getUserByUsername(String username);

    boolean existsByUsername(String username);
}
