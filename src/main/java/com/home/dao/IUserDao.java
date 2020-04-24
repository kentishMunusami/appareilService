package com.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.bean.User;

public interface IUserDao extends JpaRepository<User, Integer> {
	User findByMail(String email);
}
