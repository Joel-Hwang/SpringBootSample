package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long manager;
    @ManyToOne
    @JoinColumn(name = "parentid")
    private Department parent;
    
    private char useyn;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getManager() {
        return manager;
    }
    public void setManager(Long manager) {
        this.manager = manager;
    }
    
    public char getUseYn() {
        return useyn;
    }
    public void setUseYn(char useYn) {
        this.useyn = useYn;
    }
    public Department getParent() {
        return parent;
    }
    public void setParent(Department parent) {
        this.parent = parent;
    }

    
}

