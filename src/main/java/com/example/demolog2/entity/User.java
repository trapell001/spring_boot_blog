package com.example.demolog2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @Column(unique = true , columnDefinition = "varchar(100)")
    private String userName;
   @Column
    private String password;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private LocalDate createdDate;
    @Column
    private LocalDate modifiedDate;
    @Column
    private String createdBy;
    @Column
    private String modifiedBy;
    @ManyToMany
    @JoinTable(name="permission",
            joinColumns = @JoinColumn(name = "user_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id",nullable = false))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy="user")
    private List<Blog> blogs = new ArrayList<>();
}
