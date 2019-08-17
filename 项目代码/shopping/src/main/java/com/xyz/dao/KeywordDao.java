package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Keyword;

@Repository
public interface KeywordDao extends PagingAndSortingRepository<Keyword,Long>,JpaSpecificationExecutor<Keyword> {
	
}
