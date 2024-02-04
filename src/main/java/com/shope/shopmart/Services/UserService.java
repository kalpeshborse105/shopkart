package com.shope.shopmart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shope.shopmart.Repository.UserRepository;
import com.shope.shopmart.dtos.RegisterUserDto;
import com.shope.shopmart.Entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterUserDto data) {
        User user = new User();
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        user.setMobile(data.getMobile());
        user.setRoles(data.getRoles());

        userRepository.save(user);

        return "User registered successfully";
    }
}
