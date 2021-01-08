package com.mouzetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouzetech.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
}