package com.driver.services;

import com.driver.Converters.UserConverter;
import com.driver.Dtos.UserRequestDto;
import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(UserRequestDto userRequestDto){

        User user= UserConverter.convertDtoToEntity(userRequestDto);

        userRepository3.save(user);

    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public void updateUser(UserRequestDto userRequestDto){

        String userName= userRequestDto.getUsername();
        User updateUser= userRepository3.findByUsername(userName);

        updateUser.setFirstName(userRequestDto.getFirstName());
        updateUser.setLastName(userRequestDto.getLastName());
        updateUser.setUsername(userRequestDto.getUsername());
        updateUser.setPassword(userRequestDto.getPassword());

        userRepository3.save(updateUser);

    }

    public User findUserByUsername(String username){
        return userRepository3.findByUsername(username);
    }
}
