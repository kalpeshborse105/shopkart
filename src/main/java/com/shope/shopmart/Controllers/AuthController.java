package com.shope.shopmart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shope.shopmart.Entities.RegisteredUser;
import com.shope.shopmart.Services.AuthService;
import com.shope.shopmart.dtos.LoginDto;
import jakarta.annotation.security.RolesAllowed;

@RestController
// @RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisteredUser registeredUser) {
        return new ResponseEntity<>(this.authService.register(registeredUser), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/check")
    public void checkPreAuthorize() {
        System.out.println("Method Executable by Users with Role ADMIN");
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/checkroles")
    public void checkRolesAllowed() {
        System.out.println("Method Executable by Users with Role ADMIN");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/checksecured")
    public void checkSecured() {
        System.out.println("Method Executable by Users with Role ADMIN");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("User Logged In Successfully!!!");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    
}