package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.model.Department;
import com.repository.DepartmentRepository;

public class DepartmentService {
    private final DepartmentRepository repository;
    @Autowired
    public DepartmentService(DepartmentRepository repository){
        this.repository = repository;
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Department create(Department department) throws Exception{
        if(department == null || department.getName()==null || department.getName().isEmpty() ) 
            throw new Exception("department name is empty");
        return repository.save(department);
    }
}
