package com.in.akshay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.akshay.Entity.Resource;


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
	
}
