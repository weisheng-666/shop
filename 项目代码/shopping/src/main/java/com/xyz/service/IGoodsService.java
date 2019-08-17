package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Goods;

public interface IGoodsService {
	public void save(Goods entity);
	public void saveAll(List<Goods> entities);
	public Goods findById(Long id);
	public boolean existsById(Long id);
	public List<Goods> findAll();
	public List<Goods> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Goods entity);
	public void deleteAll(List<Goods> entities);
	public void deleteAll();
	public List<Goods> findAll(Sort sort);
	public Page<Goods> findAll(Pageable pageable);
	public Page<Goods> findAll(Specification<Goods> spec, Pageable pageable);
	
	public Page<Goods> findAll(Goods goods, Pageable pageable);
	
	public List<Goods> findByType(String type);
}
