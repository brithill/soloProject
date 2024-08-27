package com.brittanyhill.soloProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brittanyhill.soloProject.Models.Yarn;
import com.brittanyhill.soloProject.Repositories.YarnRepository;


@Service
public class YarnService {


	@Autowired
	YarnRepository yarnRepository;
	
	public List<Yarn> allYarn(){
		return yarnRepository.findAll();
	}
	
	public Yarn createYarn(Yarn yarn) {
		return yarnRepository.save(yarn);
	}
	
	public Yarn findYarn(Long id) {
		Optional<Yarn> optionalYarn = yarnRepository.findById(id);
		if (optionalYarn.isPresent()) {
			return optionalYarn.get();
		} else {
			return null;
		}
	}
	
	public void deleteYarn(Long id) {
		yarnRepository.deleteById(id);
	}
	
	public Yarn updateYarn(Yarn yarn) {
		return yarnRepository.save(yarn);
	}
	
	public Yarn oneYarn(Long id) {
		Optional<Yarn> yarn = yarnRepository.findById(id);
		if (yarn.isPresent()) {
			return yarn.get();
		} else {
			return null;
		}
	}
	
}
