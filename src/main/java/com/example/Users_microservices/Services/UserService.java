package com.example.Users_microservices.Services;

import com.example.Users_microservices.entity.UserEntity;
import com.example.Users_microservices.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public UserEntity updateUser(Long id, UserEntity newUser) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(newUser.getUserName());  // Update fields as neededgit
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
