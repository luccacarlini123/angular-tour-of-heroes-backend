package com.mouzetech.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mouzetech.model.Hero;
import com.mouzetech.model.dto.HeroDTO;
import com.mouzetech.repository.HeroRepository;
import com.mouzetech.service.HeroService;

@RestController
@RequestMapping("/api/heroes")
@CrossOrigin("*")
public class HeroResource {

	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Hero> findById(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(heroService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Hero>> findAll(){
		return ResponseEntity.ok().body(heroRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Hero> save(@RequestBody HeroDTO dto){
		Hero obj = new Hero(dto);
		heroRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody HeroDTO dto, @PathVariable("id") Integer id){
		Hero hero = heroService.findById(id);
		hero.setName(dto.getName());
		heroRepository.save(hero);
		return ResponseEntity.noContent().build();
	}
	
	
}
