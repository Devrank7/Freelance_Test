package com.example.client_1.service;

import com.example.client_1.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDatailServer implements UserDetailsService {
    @Autowired
    public IUser user;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return user.findBUserByName(username);
    }
}
