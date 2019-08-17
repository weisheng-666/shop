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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.dao.CarouselDao;
import com.xyz.domain.Carousel;

@Service
@Transactional(readOnly=true)
public class CarouselService implements ICarouselService {
	@Autowired
	private CarouselDao carouselDao;
	
	
	@Transactional
	public void save(Carousel entity) {
		carouselDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Carousel> entities) {
		carouselDao.saveAll(entities);

	}
	
	public Carousel findById(Long id) {
		return carouselDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return carouselDao.existsById(id);
	}

	public List<Carousel> findAll() {
		return (List<Carousel>) carouselDao.findAll();
	}

	public List<Carousel> findAllById(List<Long> ids) {
		return (List<Carousel>) carouselDao.findAllById(ids);
	}

	public long count() {
		return carouselDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		carouselDao.deleteById(id);

	}

	@Transactional
	public void delete(Carousel entity) {
		carouselDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Carousel> entities) {
		carouselDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		carouselDao.deleteAll();

	}

	public List<Carousel> findAll(Sort sort) {
		return (List<Carousel>) carouselDao.findAll(sort);
	}

	public Page<Carousel> findAll(Pageable pageable) {
		return carouselDao.findAll(pageable);
	}

	public Page<Carousel> findAll(Specification<Carousel> spec, Pageable pageable) {	
		return carouselDao.findAll(spec, pageable);
	}
	
	public Page<Carousel> findAll(Carousel carousel, Pageable pageable) {		
		return carouselDao.findAll(new Specification<Carousel>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Carousel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
}
