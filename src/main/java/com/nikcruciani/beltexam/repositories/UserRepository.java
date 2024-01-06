package com.nikcruciani.beltexam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nikcruciani.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
    Optional<User> findByEmail(String email);
   
}