package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Feedback;

public interface IFeedbackService {
	public void save(Feedback entity);
	public void saveAll(List<Feedback> entities);
	public Feedback findById(Long id);
	public boolean existsById(Long id);
	public List<Feedback> findAll();
	public List<Feedback> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Feedback entity);
	public void deleteAll(List<Feedback> entities);
	public void deleteAll();
	public List<Feedback> findAll(Sort sort);
	public Page<Feedback> findAll(Pageable pageable);
	public Page<Feedback> findAll(Specification<Feedback> spec, Pageable pageable);
	
	public Page<Feedback> findAll(Feedback feedback, Pageable pageable);
}
