package com.MySqlConnection.repositoory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MySqlConnection.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}