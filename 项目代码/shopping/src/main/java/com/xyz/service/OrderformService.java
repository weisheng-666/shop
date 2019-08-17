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

import com.xyz.dao.OrderformDao;
import com.xyz.domain.Orderform;

@Service
@Transactional(readOnly=true)
public class OrderformService implements IOrderformService {
	@Autowired
	private OrderformDao orderformDao;
	
	
	@Transactional
	public void save(Orderform entity) {
		orderformDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Orderform> entities) {
		orderformDao.saveAll(entities);

	}
	
	public Orderform findById(Long id) {
		return orderformDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return orderformDao.existsById(id);
	}

	public List<Orderform> findAll() {
		return (List<Orderform>) orderformDao.findAll();
	}

	public List<Orderform> findAllById(List<Long> ids) {
		return (List<Orderform>) orderformDao.findAllById(ids);
	}

	public long count() {
		return orderformDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		orderformDao.deleteById(id);

	}

	@Transactional
	public void delete(Orderform entity) {
		orderformDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Orderform> entities) {
		orderformDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		orderformDao.deleteAll();

	}

	public List<Orderform> findAll(Sort sort) {
		return (List<Orderform>) orderformDao.findAll(sort);
	}

	public Page<Orderform> findAll(Pageable pageable) {
		return orderformDao.findAll(pageable);
	}

	public Page<Orderform> findAll(Specification<Orderform> spec, Pageable pageable) {	
		return orderformDao.findAll(spec, pageable);
	}
	
	public Page<Orderform> findAll(Orderform orderform, Pageable pageable) {		
		return orderformDao.findAll(new Specification<Orderform>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Orderform> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 模糊查询
				if (orderform.getStatus()>0) {
					predicates.add(cb.equal(root.get("status").as(Integer.class), orderform.getStatus()));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
}
