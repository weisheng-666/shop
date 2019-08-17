package com.xyz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xyz.domain.User;

public interface IUserService {
	User findByUsername(String name);
	User save(User user);
	User findById(Long id);
	public Page<User> findAll(Pageable pageable);
	public Page<User> findAll(User user, Pageable pageable);
}
