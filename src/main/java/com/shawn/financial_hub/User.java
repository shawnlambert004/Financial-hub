package com.shawn.financial_hub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "application_users")
public class User {
    @Id
    @GeneratedValue
    @JsonProperty("user_id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User() {
    };

    public String getFirst_name() {
        return first_name;
    };

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    };

    public String getLast_name() {
        return last_name;
    };

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    };

    public String getUsername() {
        return username;
    };

    public void setUsername(String username) {
        this.username = username;
    };

    public String getPassword() {
        return password;
    };

    public void setPassword(String password) {
        this.password = password;
    };

    public Long getId() {
        return id;
    };

    public void setId(Long id) {
        this.id = id;
    }

}