package com.example.repositoryexercise.Repository;

import com.example.repositoryexercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findAllByUsernameAndPassword(String username, String password);

    User findByEmail(String email);

    List<User> findAllByRole(String role);

    List<User> findByAgeGreaterThanEqual(Integer age);
}
