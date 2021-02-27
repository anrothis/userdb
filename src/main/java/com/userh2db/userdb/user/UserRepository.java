package com.userh2db.userdb.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);
    
    @Query("SELECT u.forename,u.surename FROM User u")
    List<String> listUsers();

	List<User> findByForenameOrderBySurenameAsc(String forename);
    
    List<User> findBySurenameOrderByForenameAsc(String surename);
}
