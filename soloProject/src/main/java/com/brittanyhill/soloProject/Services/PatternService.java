package com.brittanyhill.soloProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.brittanyhill.soloProject.Models.Pattern;
import com.brittanyhill.soloProject.Repositories.PatternRepository;

@Service
public class PatternService {

	@Autowired
	PatternRepository patternRepository;
	
	public List<Pattern> allPatterns(){
		return patternRepository.findAll();
	}
	
	public Pattern createPattern(Pattern pattern) {
		return patternRepository.save(pattern);
	}
	
	public Pattern findPattern(Long id) {
		Optional<Pattern> optionalPattern = patternRepository.findById(id);
		if (optionalPattern.isPresent()) {
			return optionalPattern.get();
		} else {
			return null;
		}
	}
	
	public void deletePattern(Long id) {
		patternRepository.deleteById(id);
	}
	
	public Pattern updatePattern(Pattern pattern) {
		return patternRepository.save(pattern);
	}
	
	public Pattern onePattern(Long id) {
		Optional<Pattern> pattern = patternRepository.findById(id);
		if (pattern.isPresent()) {
			return pattern.get();
		} else {
			return null;
		}
	}
	
}
