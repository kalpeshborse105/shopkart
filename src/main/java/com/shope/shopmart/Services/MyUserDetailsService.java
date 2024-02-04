package com.shope.shopmart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shope.shopmart.Entities.RegisteredUser;
import com.shope.shopmart.Repository.RegisteredUserRepository;
import jakarta.transaction.Transactional;

import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

        @Autowired
        private RegisteredUserRepository repository;

        @Override
        @Transactional
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return this.repository
                .findByEmail(username)
                                .map(user -> {
                                        return new RegisteredUser(
                                                        user.getEmail(),
                                                        user.getPassword(),
                                                        user.getRoles().stream()
                                                                        .map(role -> new SimpleGrantedAuthority(role))
                                                                        .collect(Collectors.toList()));
                                })
                                .orElseThrow(() -> {
                                        throw new UsernameNotFoundException("User wit email does not exists");
                                }
                                );
        }
}
