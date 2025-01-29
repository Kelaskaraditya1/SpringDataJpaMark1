package com.Starkindustries.SpringDataJpaMark1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull(message = "Name should not be null!")
    @NotEmpty(message = "Should not be empty!!")
    @NotBlank(message = "Should not be Blank!!")
    @Column(name = "Name")
    private String name;

    @NotNull(message = "Email should not be null!")
    @NotBlank(message = "Should not be empty!!")
    @NotEmpty(message = "Should not be Blank!!")
    @Column(name = "Email")
    @Email(message = "Enter Proper email-address")
    private String email;

    @NotNull(message = "Username should not be null!")
    @NotBlank(message = "Should not be empty!!")
    @NotEmpty(message = "Should not be Blank!!")
    @Column(name = "Username")
    private String username;

    @NotNull(message = "Password should not be null!")
    @NotBlank(message = "Should not be empty!!")
    @NotEmpty(message = "Should not be Blank!!")
    @Column(name = "Password")
    private String password;

    public User(int userId, String name, String email, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String name){
        this.name=name;
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
