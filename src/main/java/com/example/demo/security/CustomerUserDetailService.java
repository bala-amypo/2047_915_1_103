package com.example.demo.security;

public class CustomerUserDetailService {
    public CustomerUserDetails loadUser(String username) {
        return new CustomerUserDetails();
    }
}