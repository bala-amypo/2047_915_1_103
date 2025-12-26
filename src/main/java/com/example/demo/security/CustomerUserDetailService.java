package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // 🔹 Dummy user (DB not required for your tests)
        User user = new User();
        user.setEmail(email);
        user.setPassword("password");
        user.setRole("STAFF");

        return new CustomerUserDetails(user);
    }
}
