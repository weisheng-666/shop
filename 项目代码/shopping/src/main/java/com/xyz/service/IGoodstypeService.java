package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Goodstype;

public interface IGoodstypeService {
	public void save(Goodstype entity);
	public void saveAll(List<Goodstype> entities);
	public Goodstype findById(Long id);
	public boolean existsById(Long id);
	public List<Goodstype> findAll();
	public List<Goodstype> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Goodstype entity);
	public void deleteAll(List<Goodstype> entities);
	public void deleteAll();
	public List<Goodstype> findAll(Sort sort);
	public Page<Goodstype> findAll(Pageable pageable);
	public Page<Goodstype> findAll(Specification<Goodstype> spec, Pageable pageable);
	
	public Page<Goodstype> findAll(Goodstype goodstype, Pageable pageable);
}
