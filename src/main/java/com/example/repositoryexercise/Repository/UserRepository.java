package com.example.repositoryexercise.Repository;

import com.example.repositoryexercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=?1 AND u.password=?2")
    User findAllByUsernameAndPassword(String username, String password);
    @Query("select u from User u where u.email=?1")
    User findByEmail(String email);
    @Query("select u from User u where u.role=?1")
    List<User> findAllByRole(String role);
    @Query("select u from User u where u.age=?1")
    List<User> findByAgeGreaterThanEqual(Integer age);
}
