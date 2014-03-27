package be.plantenshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.plantenshop.entities.Plant;

public interface PlantDAO extends JpaRepository<Plant, Long>{

}
