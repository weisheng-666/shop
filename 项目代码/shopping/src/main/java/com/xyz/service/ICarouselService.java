package com.xyz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.xyz.domain.Carousel;

public interface ICarouselService {
	public void save(Carousel entity);
	public void saveAll(List<Carousel> entities);
	public Carousel findById(Long id);
	public boolean existsById(Long id);
	public List<Carousel> findAll();
	public List<Carousel> findAllById(List<Long> ids);
	public long count();
	public void deleteById(Long id);
	public void delete(Carousel entity);
	public void deleteAll(List<Carousel> entities);
	public void deleteAll();
	public List<Carousel> findAll(Sort sort);
	public Page<Carousel> findAll(Pageable pageable);
	public Page<Carousel> findAll(Specification<Carousel> spec, Pageable pageable);
	
	public Page<Carousel> findAll(Carousel carousel, Pageable pageable);
}
