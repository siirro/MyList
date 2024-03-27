package com.home.mylist.domain;

import jakarta.persistence.Entity;

@Entity
public class Member {

    private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
