package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
