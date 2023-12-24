package com.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.AppUser;
import com.service.UserService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;


    @Test
    void testCreateUser() throws Exception {
        AppUser user = new AppUser();
        user.setUsername("John");
        user.setEmail("john@email.com");

        when(userService.createUser(Mockito.any(AppUser.class))).thenReturn(user);

        this.mockMvc.perform(post("/api/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isOk())
        .andExpect(content().string(objectMapper.writeValueAsString(user)))
        .andDo(print());
    }
    
    @Test
    void testGetAllUsers() throws Exception{
        List<AppUser> testList = List.of(
                new AppUser("John", "John@email.com"),
                new AppUser("Joel","joel@email.com"));

        when(userService.getAllUsers()).thenReturn(testList);

        this.mockMvc.perform(get("/api/users"))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(testList)))
        .andDo(print());

    }
}
