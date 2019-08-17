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

import com.xyz.dao.GoodstypeDao;
import com.xyz.domain.Goodstype;

@Service
@Transactional(readOnly=true)
public class GoodstypeService implements IGoodstypeService {
	@Autowired
	private GoodstypeDao goodstypeDao;
	
	
	@Transactional
	public void save(Goodstype entity) {
		goodstypeDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Goodstype> entities) {
		goodstypeDao.saveAll(entities);

	}
	
	public Goodstype findById(Long id) {
		return goodstypeDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return goodstypeDao.existsById(id);
	}

	public List<Goodstype> findAll() {
		return (List<Goodstype>) goodstypeDao.findAll();
	}

	public List<Goodstype> findAllById(List<Long> ids) {
		return (List<Goodstype>) goodstypeDao.findAllById(ids);
	}

	public long count() {
		return goodstypeDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		goodstypeDao.deleteById(id);

	}

	@Transactional
	public void delete(Goodstype entity) {
		goodstypeDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Goodstype> entities) {
		goodstypeDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		goodstypeDao.deleteAll();

	}

	public List<Goodstype> findAll(Sort sort) {
		return (List<Goodstype>) goodstypeDao.findAll(sort);
	}

	public Page<Goodstype> findAll(Pageable pageable) {
		return goodstypeDao.findAll(pageable);
	}

	public Page<Goodstype> findAll(Specification<Goodstype> spec, Pageable pageable) {	
		return goodstypeDao.findAll(spec, pageable);
	}
	
	public Page<Goodstype> findAll(Goodstype goodstype, Pageable pageable) {		
		return goodstypeDao.findAll(new Specification<Goodstype>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Goodstype> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 模糊查询
				if (goodstype.getName()!=null && !goodstype.getName().trim().equals("")) {
					predicates.add(cb.like(root.get("name").as(String.class), "%"+goodstype.getName()+"%"));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
}
