package com.rick.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rick.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
