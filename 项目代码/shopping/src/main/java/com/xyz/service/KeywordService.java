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

import com.xyz.dao.KeywordDao;
import com.xyz.domain.Keyword;

@Service
@Transactional(readOnly=true)
public class KeywordService implements IKeywordService {
	@Autowired
	private KeywordDao keywordDao;
	
	
	@Transactional
	public void save(Keyword entity) {
		keywordDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Keyword> entities) {
		keywordDao.saveAll(entities);

	}
	
	public Keyword findById(Long id) {
		return keywordDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return keywordDao.existsById(id);
	}

	public List<Keyword> findAll() {
		return (List<Keyword>) keywordDao.findAll();
	}

	public List<Keyword> findAllById(List<Long> ids) {
		return (List<Keyword>) keywordDao.findAllById(ids);
	}

	public long count() {
		return keywordDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		keywordDao.deleteById(id);

	}

	@Transactional
	public void delete(Keyword entity) {
		keywordDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Keyword> entities) {
		keywordDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		keywordDao.deleteAll();

	}

	public List<Keyword> findAll(Sort sort) {
		return (List<Keyword>) keywordDao.findAll(sort);
	}

	public Page<Keyword> findAll(Pageable pageable) {
		return keywordDao.findAll(pageable);
	}

	public Page<Keyword> findAll(Specification<Keyword> spec, Pageable pageable) {	
		return keywordDao.findAll(spec, pageable);
	}
	
	public Page<Keyword> findAll(Keyword keyword, Pageable pageable) {		
		return keywordDao.findAll(new Specification<Keyword>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Keyword> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
}
