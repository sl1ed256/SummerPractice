package com.myproject.antaev.entity;

import com.myproject.antaev.rest.data_type.UserRights;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(nullable = false)
    private String nameUser;

    @ElementCollection()
    @CollectionTable(name = "userRights", joinColumns = @JoinColumn(name = "idUser"))
    @Column(name = "userRights")
    @Enumerated(EnumType.STRING)
    private Set<UserRights> userRights;
}
