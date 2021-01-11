package fr.humanbooster.fx.travel.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.humanbooster.fx.travel.business.Vol;
import fr.humanbooster.fx.travel.dao.VolDao;
import fr.humanbooster.fx.travel.dao.impl.VolDaoImpl;
import fr.humanbooster.fx.travel.service.AeroportService;
import fr.humanbooster.fx.travel.service.CompagnieService;
import fr.humanbooster.fx.travel.service.VolService;

public class VolServiceImpl implements VolService {

	private VolDao volDao = new VolDaoImpl();
	private AeroportService aeroportService = new AeroportServiceImpl();
	private CompagnieService compagnieService = new CompagnieServiceImpl();
	
	@Override
	public Vol ajouterVol(long idCompagnie, long idAeroportDepart, long idAeroportArrivee, Date dateHeureDepart, Date dateHeureArrivee, float prixEnEuros) {
		Vol vol = new Vol();
		vol.setDateHeureDepart(dateHeureDepart);
		vol.setDateHeureArrivee(dateHeureArrivee);
		vol.setAeroportDepart(aeroportService.recupererAeroport(idAeroportDepart));
		vol.setAeroportArrivee(aeroportService.recupererAeroport(idAeroportArrivee));
		vol.setCompagnie(compagnieService.recupererCompagnie(idCompagnie));
		vol.setPrixEnEuros(prixEnEuros);

		try {
			vol = volDao.create(vol);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vol;
	}

	@Override
	public List<Vol> recupererVols() {
		try {
			return volDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
