package com.contact.smartcontactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contact.smartcontactmanager.dao.UserRepository;
import com.contact.smartcontactmanager.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private User userByUserName;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userByUserName = userRepository.getUserByUserName(username);
        if (userByUserName == null) {
            throw new UsernameNotFoundException("Could not found user");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(userByUserName);

        return customUserDetails;
    }

}
