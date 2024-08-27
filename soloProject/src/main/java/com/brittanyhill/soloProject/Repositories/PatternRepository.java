package com.brittanyhill.soloProject.Repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brittanyhill.soloProject.Models.Pattern;



@Repository
public interface PatternRepository extends CrudRepository<Pattern, Long> {
	List<Pattern> findAll();
}
