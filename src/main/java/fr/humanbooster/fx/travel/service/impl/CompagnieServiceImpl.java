package fr.humanbooster.fx.travel.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.travel.business.Compagnie;
import fr.humanbooster.fx.travel.dao.CompagnieDao;
import fr.humanbooster.fx.travel.dao.impl.CompagnieDaoImpl;
import fr.humanbooster.fx.travel.service.CompagnieService;

public class CompagnieServiceImpl implements CompagnieService {

	private CompagnieDao compagnieDao = new CompagnieDaoImpl();
	
	@Override
	public Compagnie ajouterCompagnie(String nom) {
		Compagnie compagnie = new Compagnie(nom);
		try {
			compagnieDao.create(compagnie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compagnie;
	}

	@Override
	public Compagnie recupererCompagnie(Long id) {
		try {
			return compagnieDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Compagnie> recupererCompagnies() {
		try {
			return compagnieDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
