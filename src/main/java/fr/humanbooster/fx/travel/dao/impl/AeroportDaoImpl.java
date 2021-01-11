package fr.humanbooster.fx.travel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.travel.business.Aeroport;
import fr.humanbooster.fx.travel.dao.AeroportDao;
import fr.humanbooster.fx.travel.dao.ConnexionBdd;
import fr.humanbooster.fx.travel.dao.Requetes;

public class AeroportDaoImpl implements AeroportDao {

	private Connection connexion;
	
	public AeroportDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Aeroport create(Aeroport aeroport) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_AEROPORT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, aeroport.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		aeroport.setId(rs.getLong(1));
		return aeroport;
	}

	@Override
	public Aeroport findOne(Long id) throws SQLException {
		Aeroport aeroport = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.AEROPORT_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			aeroport = new Aeroport(rs.getString("nom"));
			aeroport.setId(rs.getLong("id"));
		}
		return aeroport;
	}

	@Override
	public List<Aeroport> findAll() throws SQLException {
		List<Aeroport> aeroports = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_AEROPORTS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aeroport aeroport = new Aeroport(rs.getString("nom"));
			aeroport.setId(rs.getLong("id"));
			aeroports.add(aeroport);
		}
		return aeroports;
	}

}
