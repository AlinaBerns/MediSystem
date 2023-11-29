package com.example.brussel.be.model;

import jakarta.persistence.*;

//Этот класс нужно связать с ENUMS
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@Enumerated(EnumType.STRING)
    //@Column(length = 20)
    //private ERole name;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}