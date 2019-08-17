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

import com.xyz.dao.FeedbackDao;
import com.xyz.domain.Feedback;

@Service
@Transactional(readOnly=true)
public class FeedbackService implements IFeedbackService {
	@Autowired
	private FeedbackDao feedbackDao;
	
	
	@Transactional
	public void save(Feedback entity) {
		feedbackDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Feedback> entities) {
		feedbackDao.saveAll(entities);

	}
	
	public Feedback findById(Long id) {
		return feedbackDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return feedbackDao.existsById(id);
	}

	public List<Feedback> findAll() {
		return (List<Feedback>) feedbackDao.findAll();
	}

	public List<Feedback> findAllById(List<Long> ids) {
		return (List<Feedback>) feedbackDao.findAllById(ids);
	}

	public long count() {
		return feedbackDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		feedbackDao.deleteById(id);

	}

	@Transactional
	public void delete(Feedback entity) {
		feedbackDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Feedback> entities) {
		feedbackDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		feedbackDao.deleteAll();

	}

	public List<Feedback> findAll(Sort sort) {
		return (List<Feedback>) feedbackDao.findAll(sort);
	}

	public Page<Feedback> findAll(Pageable pageable) {
		return feedbackDao.findAll(pageable);
	}

	public Page<Feedback> findAll(Specification<Feedback> spec, Pageable pageable) {	
		return feedbackDao.findAll(spec, pageable);
	}
	
	public Page<Feedback> findAll(Feedback feedback, Pageable pageable) {		
		return feedbackDao.findAll(new Specification<Feedback>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Feedback> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
}
