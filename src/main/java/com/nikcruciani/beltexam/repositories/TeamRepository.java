package com.nikcruciani.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nikcruciani.beltexam.models.Team;


@Repository
public interface TeamRepository extends CrudRepository<Team , Long>{
	
	List<Team> findAll();
		
	List<Team> findByUserId(Long userId);

}