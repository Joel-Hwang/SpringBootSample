package com.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.model.AppUser;
import com.model.Department;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testModelRepository() {
        AppUser myModel = new AppUser("test","test@email.com");
        myModel.setId(2L);
        Department dept = new Department();
        dept.setId(1L);
        dept.setName("Test Team");
        dept.setManager(2L);
        dept.setParent(null);
        dept.setUseYn('Y');

        myModel.setDepartment(dept);

        // 저장
        AppUser savedModel = repository.save(myModel);

        // 조회
        AppUser retrievedModel = repository.findById(savedModel.getId()).orElse(null);

        Department dep = retrievedModel.getDepartment();
        // 예상 결과와 실제 결과 비교
        assertEquals(myModel.getEmail(), retrievedModel.getEmail());
        assertEquals(myModel.getUsername(), retrievedModel.getUsername());
    }
}
