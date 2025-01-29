package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "_User")
public class User {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    int Id;
    String name;

    String password;

    public User(){

    }
    public User(int id, String name, String password) {
        Id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
