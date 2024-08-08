package com.example.microservice_product.Commons;

import com.example.microservice_product.Dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AutheticationCommon {

    private RestTemplate restTemplate;
    AutheticationCommon(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public UserDto validateToken(String token){
     //make a call to validatetoken api to usersERVICE to validate the token

        UserDto responseEntity =
                  restTemplate.getForObject(
             "http://localhost:1129/user/validate/" +
                     token,
             UserDto.class);

        return responseEntity;
    }
}
