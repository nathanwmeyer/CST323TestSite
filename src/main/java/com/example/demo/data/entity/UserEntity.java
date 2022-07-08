package com.example.demo.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class UserEntity {

    @Id
    @Column("ID")
    private Long id;

    @Column("EMAIL")
    private String email;

    @Column("USERNAME")
    private String userName;

    public UserEntity() {}

    public UserEntity(Long id, String email, String userName)
    {
        this.id = id;
        this.email = email;
        this.userName = userName;
    }

    public UserEntity( String email, String userName)
    {
        this.email = email;
        this.userName = userName;
    }

    public Long getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}
