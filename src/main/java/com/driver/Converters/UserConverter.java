package com.driver.Converters;

import com.driver.Dtos.UserRequestDto;
import com.driver.models.User;

public class UserConverter {

    public static User convertDtoToEntity(UserRequestDto userRequestDto){

        String userName= userRequestDto.getUsername();
        String password= userRequestDto.getPassword();
        String firstName= userRequestDto.getFirstName();
        String lastName= userRequestDto.getLastName();

        User newUser= new User(userName, password, firstName, lastName);
        return newUser;
    }
}
