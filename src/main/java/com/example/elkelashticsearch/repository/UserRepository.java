package com.example.elkelashticsearch.repository;

import com.example.elkelashticsearch.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
