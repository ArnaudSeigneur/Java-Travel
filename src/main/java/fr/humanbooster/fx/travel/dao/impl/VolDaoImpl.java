package fr.humanbooster.fx.travel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.travel.business.Vol;
import fr.humanbooster.fx.travel.dao.AeroportDao;
import fr.humanbooster.fx.travel.dao.CompagnieDao;
import fr.humanbooster.fx.travel.dao.ConnexionBdd;
import fr.humanbooster.fx.travel.dao.Requetes;
import fr.humanbooster.fx.travel.dao.VolDao;

public class VolDaoImpl implements VolDao {

	private Connection connexion;
	private CompagnieDao compagnieDao;
	private AeroportDao aeroportDao;
	
	public VolDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			compagnieDao = new CompagnieDaoImpl();
			aeroportDao = new AeroportDaoImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Vol create(Vol vol) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_VOL, Statement.RETURN_GENERATED_KEYS);
		ps.setTimestamp(1, new java.sql.Timestamp(vol.getDateHeureDepart().getTime()));
		ps.setTimestamp(2, new java.sql.Timestamp(vol.getDateHeureArrivee().getTime()));
		ps.setFloat(3, vol.getPrixEnEuros());
		ps.setLong(4, vol.getCompagnie().getId());
		ps.setLong(5, vol.getAeroportDepart().getId());
		ps.setLong(6, vol.getAeroportArrivee().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		vol.setId(rs.getLong(1));
		return vol;
	}

	@Override
	public List<Vol> findAll() throws SQLException {
		List<Vol> vols = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_VOLS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vol vol = new Vol();
			vol.setId(rs.getLong("id"));
			// Utilisation du patron DAO: VolDao fait appel à CompagnieDao
			vol.setCompagnie(compagnieDao.findOne(rs.getLong("compagnie_id")));
			vol.setAeroportDepart(aeroportDao.findOne(rs.getLong("aeroport_depart_id")));
			vol.setAeroportArrivee(aeroportDao.findOne(rs.getLong("aeroport_arrivee_id")));
			
			vol.setPrixEnEuros(rs.getFloat("prixEnEuros"));
			vol.setDateHeureDepart(rs.getDate("dateHeureDepart"));
			vol.setDateHeureArrivee(rs.getDate("dateHeureArrivee"));

			vols.add(vol);
		}
		return vols;
	}

}
