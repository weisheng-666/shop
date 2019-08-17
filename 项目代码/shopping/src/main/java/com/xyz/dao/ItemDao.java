package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Item;

@Repository
public interface ItemDao extends PagingAndSortingRepository<Item,Long>,JpaSpecificationExecutor<Item> {
	
}
