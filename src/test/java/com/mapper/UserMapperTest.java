package com.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.AppUser;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testFindById() {
        AppUser user = new AppUser("testUser", "test@example.com");
        userMapper.insert(user);

        // 매퍼 메서드 호출
        AppUser retrievedUser = userMapper.findById(user.getId());

        // 결과 확인
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getUsername());
        assertEquals("test@example.com", retrievedUser.getEmail());
    }

    @Test
    void testInsert() {
        AppUser user = new AppUser("testUser", "test@example.com");
        userMapper.insert(user);

        // 매퍼 메서드 호출
        AppUser retrievedUser = userMapper.findById(user.getId());

        // 결과 확인
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getUsername());
        assertEquals("test@example.com", retrievedUser.getEmail());
    }
}
