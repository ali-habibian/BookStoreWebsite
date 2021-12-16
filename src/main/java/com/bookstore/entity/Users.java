package com.bookstore.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "select u from Users u order by u.userId desc"),
        @NamedQuery(name="Users.findByEmail", query = "select u from Users u where u.email = :email"),
        @NamedQuery(name = "Users.countAll", query = "select Count(*) from Users u")
})
public class Users {
    private Integer userId;
    private String email;
    private String fullName;
    private String password;

    public Users() {
    }

    public Users(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
