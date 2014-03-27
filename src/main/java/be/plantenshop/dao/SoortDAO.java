package be.plantenshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.plantenshop.entities.Soort;

public interface SoortDAO extends JpaRepository<Soort, Long>{

}
