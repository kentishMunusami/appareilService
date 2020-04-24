package com.home.service.impl;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.home.bean.User;
import com.home.dao.IUserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private IUserDao userRepository;

    public UserDetailsServiceImpl(IUserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
    	User user = userRepository.findByMail(mail);
        if (userRepository == null) {
            throw new UsernameNotFoundException(mail);
        }
        return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), emptyList());
    }
}
