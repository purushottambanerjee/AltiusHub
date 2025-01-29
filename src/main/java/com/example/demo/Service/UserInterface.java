package com.example.demo.Service;

import com.example.demo.Model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public abstract class UserInterface implements JpaRepository<User, Integer> {
}
