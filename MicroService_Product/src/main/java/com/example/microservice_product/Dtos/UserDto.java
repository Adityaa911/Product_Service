package com.example.microservice_product.Dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
   // public static UserDto fromUser;
    private String name;
    private String email;
   // private List<Roles> roles;

//    public static UserDto fromUser(User user) {
//
//        if(user==null){
//            return null;
//        }
//
//        UserDto userDto= new UserDto();
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setRoles(user.getRoles());
//
//        return userDto;
//    }

}
