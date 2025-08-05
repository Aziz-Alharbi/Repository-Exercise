package com.example.repositoryexercise.Service;

import com.example.repositoryexercise.Api.ApiException;
import com.example.repositoryexercise.Model.User;
import com.example.repositoryexercise.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    //• Get all the Users
    //• Add new User
    //• Update User
    //• Delete User
    //• Check if username and password are correct
    //• Get user by email
    //• Get All users with specific role
    //• Get All users with specific age or above

    private final UserRepository userRepository;

    public List<User> getAll (){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.getById(id);

        if (oldUser == null){
            throw new ApiException("User not found !");
        }

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getName());
        oldUser.setRole(user.getRole());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());

        userRepository.save(oldUser);

    }

    public void deleteUser(Integer id){
        User user = userRepository.getById(id);

        if (user == null){
            throw new ApiException("User not found !");
        }

        userRepository.delete(user);
    }

    public void checkLogin(String username, String password){
        userRepository.findAllByUsernameAndPassword(username, password);
    }

    public User emailUser(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> roleUser(String role){
        return userRepository.findAllByRole(role);
    }

    public List<User> getUsersByAge(Integer age){
        return userRepository.findByAgeGreaterThanEqual(age);
    }













}
