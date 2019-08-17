package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User,Long>,JpaSpecificationExecutor<User>{
	User findByUsername(String name);
}
