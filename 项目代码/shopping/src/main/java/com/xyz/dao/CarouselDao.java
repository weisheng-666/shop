package com.xyz.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.domain.Carousel;

@Repository
public interface CarouselDao extends PagingAndSortingRepository<Carousel,Long>,JpaSpecificationExecutor<Carousel> {
	
}
