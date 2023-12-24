package com.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.AppUser;
import com.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private AppUser testUser;

    @BeforeEach
    public void setup(){
        testUser = new AppUser("testuser","testemail");
    }

    @Test
    void testCreateUser() throws Exception{
        when(userRepository.save(any(AppUser.class))).thenReturn(testUser);

        AppUser user = userService.createUser(new AppUser("testuser","testemail"));
        assertNotNull(user);
        assertEquals("testuser", user.getUsername());

        // userRepository.save() 메서드가 1번 호출되었는지 검증
        verify(userRepository, times(1)).save(any(AppUser.class));
    }

    @Test
    void testCreateUserWhenNameIsEmpty(){
        assertThrows(Exception.class, () -> userService.createUser(new AppUser(null,null)));
    }

    @Test
    void testGetAllUsers() {
        List<AppUser> testList = List.of(
                new AppUser("John", "John@email.com"),
                new AppUser("Joel","joel@email.com"));
        when(userRepository.findAll()).thenReturn(testList);
        List<AppUser> actualList = userService.getAllUsers();
        assertNotNull(actualList);
        assertArrayEquals(testList.toArray(), actualList.toArray());
    }
}
