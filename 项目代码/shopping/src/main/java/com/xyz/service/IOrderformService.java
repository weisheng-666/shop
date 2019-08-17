package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Orderform;

public interface IOrderformService {
	public void save(Orderform entity);
	public void saveAll(List<Orderform> entities);
	public Orderform findById(Long id);
	public boolean existsById(Long id);
	public List<Orderform> findAll();
	public List<Orderform> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Orderform entity);
	public void deleteAll(List<Orderform> entities);
	public void deleteAll();
	public List<Orderform> findAll(Sort sort);
	public Page<Orderform> findAll(Pageable pageable);
	public Page<Orderform> findAll(Specification<Orderform> spec, Pageable pageable);
	
	public Page<Orderform> findAll(Orderform orderform, Pageable pageable);
}
