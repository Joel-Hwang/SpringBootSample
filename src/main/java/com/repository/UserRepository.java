package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    // 추가적인 쿼리 메서드 등을 정의할 수 있습니다.
}
