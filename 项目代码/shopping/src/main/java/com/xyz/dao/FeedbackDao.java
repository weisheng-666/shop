package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Feedback;

@Repository
public interface FeedbackDao extends PagingAndSortingRepository<Feedback,Long>,JpaSpecificationExecutor<Feedback> {
	
}
