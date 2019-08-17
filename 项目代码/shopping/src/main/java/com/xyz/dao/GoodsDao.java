package com.xyz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Goods;

@Repository
public interface GoodsDao extends PagingAndSortingRepository<Goods,Long>,JpaSpecificationExecutor<Goods> {
	
	public List<Goods> findByType(String type);
}
