package io.glacier.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.glacier.model.*;
@Repository
public interface PlatformRepository extends MongoRepository<Platform,Integer> {

// Fetch all records from database where name same as name requested in url.
	
	@Query("{name : ?0}")
    List<Platform> findByName(String name);
}
