package be.plantenshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.plantenshop.dao.PlantDAO;
import be.plantenshop.entities.Plant;
@Service
@Transactional(readOnly = true)
public class PlantServiceImpl implements PlantService{
	private final PlantDAO plantDAO;
	
	@Autowired
	PlantServiceImpl(PlantDAO plantDAO) {
		this.plantDAO= plantDAO;
	}

	@Override
	public Plant read(long id) {
		return null;
		// TODO
	}

}
