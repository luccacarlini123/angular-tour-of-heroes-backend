package com.mouzetech.service;

import org.springframework.stereotype.Service;

import com.mouzetech.model.Hero;
import com.mouzetech.repository.HeroRepository;
import com.mouzetech.service.exception.ObjectNotFoundException;

@Service
public class HeroService {

	private final HeroRepository heroRepository;
	
	public HeroService(HeroRepository heroRepository) {
		this.heroRepository = heroRepository;
	}
	
	public Hero findById(Integer id) {
		return heroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
	}
	
}
