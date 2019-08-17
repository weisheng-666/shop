package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Keyword;

public interface IKeywordService {
	public void save(Keyword entity);
	public void saveAll(List<Keyword> entities);
	public Keyword findById(Long id);
	public boolean existsById(Long id);
	public List<Keyword> findAll();
	public List<Keyword> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Keyword entity);
	public void deleteAll(List<Keyword> entities);
	public void deleteAll();
	public List<Keyword> findAll(Sort sort);
	public Page<Keyword> findAll(Pageable pageable);
	public Page<Keyword> findAll(Specification<Keyword> spec, Pageable pageable);
	
	public Page<Keyword> findAll(Keyword keyword, Pageable pageable);
}
