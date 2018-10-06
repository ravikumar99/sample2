package com.journaldev.bootifulmongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongo.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByName(String name);
}
