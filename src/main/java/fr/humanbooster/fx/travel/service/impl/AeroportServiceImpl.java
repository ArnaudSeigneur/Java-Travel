package fr.humanbooster.fx.travel.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.travel.business.Aeroport;
import fr.humanbooster.fx.travel.dao.AeroportDao;
import fr.humanbooster.fx.travel.dao.impl.AeroportDaoImpl;
import fr.humanbooster.fx.travel.service.AeroportService;

public class AeroportServiceImpl implements AeroportService {

	private AeroportDao aeroportDao = new AeroportDaoImpl();

	@Override
	public Aeroport ajouterAeroport(String nom) {
		Aeroport aeroport = new Aeroport(nom);
		try {
			aeroportDao.create(aeroport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aeroport;
	}

	@Override
	public Aeroport recupererAeroport(Long id) {
		try {
			return aeroportDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Aeroport> recupererAeroports() {
		try {
			return aeroportDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
