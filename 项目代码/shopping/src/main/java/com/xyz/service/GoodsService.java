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

import com.xyz.dao.GoodsDao;
import com.xyz.domain.Goods;

@Service
@Transactional(readOnly=true)
public class GoodsService implements IGoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	
	@Transactional
	public void save(Goods entity) {
		goodsDao.save(entity);
	}
	
	@Transactional
	public void saveAll(List<Goods> entities) {
		goodsDao.saveAll(entities);

	}
	
	public Goods findById(Long id) {
		return goodsDao.findById(id).get();
	}

	public boolean existsById(Long id) {
		return goodsDao.existsById(id);
	}

	public List<Goods> findAll() {
		return (List<Goods>) goodsDao.findAll();
	}

	public List<Goods> findAllById(List<Long> ids) {
		return (List<Goods>) goodsDao.findAllById(ids);
	}

	public long count() {
		return goodsDao.count();
	}

	@Transactional
	public void deleteById(Long id) {
		goodsDao.deleteById(id);

	}

	@Transactional
	public void delete(Goods entity) {
		goodsDao.delete(entity);
	}

	@Transactional
	public void deleteAll(List<Goods> entities) {
		goodsDao.deleteAll(entities);

	}

	@Transactional
	public void deleteAll() {
		goodsDao.deleteAll();

	}

	public List<Goods> findAll(Sort sort) {
		return (List<Goods>) goodsDao.findAll(sort);
	}

	public Page<Goods> findAll(Pageable pageable) {
		return goodsDao.findAll(pageable);
	}

	public Page<Goods> findAll(Specification<Goods> spec, Pageable pageable) {	
		return goodsDao.findAll(spec, pageable);
	}
	
	public Page<Goods> findAll(Goods goods, Pageable pageable) {		
		return goodsDao.findAll(new Specification<Goods>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 模糊查询
				if (goods.getName()!=null && !goods.getName().trim().equals("")) {
					predicates.add(cb.like(root.get("name").as(String.class), "%"+goods.getName()+"%"));
				}
				if (goods.getType()!=null && !goods.getType().trim().equals("")) {
					predicates.add(cb.equal(root.get("type").as(String.class), goods.getType()));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			} 
		}, pageable);
	}
	
	public List<Goods> findByType(String type) {
		return goodsDao.findByType(type);
	}
}
