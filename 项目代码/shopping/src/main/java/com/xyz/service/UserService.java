package com.xyz.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.xyz.dao.UserDao;
import com.xyz.domain.User;

@Service
//@Transactional(readOnly=true)
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUsername(String name) {
		return userDao.findByUsername(name);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}
	
	public Page<User> findAll(User user, Pageable pageable) {		
		return userDao.findAll(new Specification<User>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 模糊查询
				if (user.getUsername()!=null && !user.getUsername().trim().equals("")) {
					predicates.add(cb.like(root.get("username").as(String.class), "%"+user.getUsername()+"%"));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}

}
