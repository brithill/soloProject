package com.brittanyhill.soloProject.Repositories;


import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.brittanyhill.soloProject.Models.Yarn;


public interface YarnRepository extends CrudRepository<Yarn, Long> {
	List<Yarn> findAll();
	

}
