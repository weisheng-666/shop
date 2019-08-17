package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Goodstype;

@Repository
public interface GoodstypeDao extends PagingAndSortingRepository<Goodstype,Long>,JpaSpecificationExecutor<Goodstype> {
	
}
