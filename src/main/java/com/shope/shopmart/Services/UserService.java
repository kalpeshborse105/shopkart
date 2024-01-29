package com.shope.shopmart.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import com.shope.shopmart.Entities.User;
import com.shope.shopmart.dtos.RegisterUserDto;

@Service
public class UserService {
     private Map<Integer, User> users = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger();


    // @Autowired
    // private UserRepository repository;

    // public String register(@Valid RegisterUserDto data) {
    //     if (this.repository.findByEmail(data.getEmail()).isPresent()) {
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already registered");
    //     }

        // Convert RegisterUserDto to User entity
        public User register(RegisterUserDto data){
        User user = new User();
        user.setId(counter.incrementAndGet());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        user.setMobile(data.getMobile());
        users.put(user.getId(),user);
        return user;
        // user.setRoles(data.getRoles());

        // Save the User entity
        // this.repository.save(user);
        // return "User registered successfully";
    }
}
