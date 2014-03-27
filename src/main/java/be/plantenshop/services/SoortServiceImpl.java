package be.plantenshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.plantenshop.dao.SoortDAO;
import be.plantenshop.entities.Soort;

@Service
@Transactional(readOnly = true)
public class SoortServiceImpl implements SoortService {
	private final SoortDAO soortDAO;
	
	@Autowired
	SoortServiceImpl(SoortDAO soortDAO) {
		this.soortDAO = soortDAO;
	}

	@Override
	public Iterable<Soort> findAll() {
		return soortDAO.findAll(new Sort("naam"));
	}

	@Override
	public Soort read(long id) {
		return soortDAO.findOne(id);
	}

}
