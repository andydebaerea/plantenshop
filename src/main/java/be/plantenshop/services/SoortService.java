package be.plantenshop.services;

import be.plantenshop.entities.Soort;

public interface SoortService {
	Iterable<Soort> findAll();
	
	Soort read(long id);
}
