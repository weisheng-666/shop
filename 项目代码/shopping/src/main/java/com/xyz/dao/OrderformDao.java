package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Orderform;

@Repository
public interface OrderformDao extends PagingAndSortingRepository<Orderform,Long>,JpaSpecificationExecutor<Orderform> {
	
}
