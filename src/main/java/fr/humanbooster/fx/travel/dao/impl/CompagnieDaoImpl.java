package fr.humanbooster.fx.travel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.travel.business.Compagnie;
import fr.humanbooster.fx.travel.dao.CompagnieDao;
import fr.humanbooster.fx.travel.dao.ConnexionBdd;
import fr.humanbooster.fx.travel.dao.Requetes;

public class CompagnieDaoImpl implements CompagnieDao {

	private Connection connexion;
	
	public CompagnieDaoImpl() {
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
	public Compagnie create(Compagnie compagnie) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_COMPAGNIE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, compagnie.getNom());
		ps.executeUpdate();	
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		compagnie.setId(rs.getLong(1));
		return compagnie;
	}

	@Override
	public Compagnie findOne(Long id) throws SQLException {
		// On prépare une requête SQL qui va transiter sur la connexion liée à l'application
		PreparedStatement ps = connexion.prepareStatement(Requetes.COMPAGNIE_PAR_ID);
		// On transforme le premier ? par l'id donné en paramètre
		ps.setLong(1, id);
		// On demande à MySQL d'exécuter la requête
		// et JDBC va placer les résultats dans l'objet ResultSet
		ResultSet rs = ps.executeQuery();
		
		// Si l'objet ResultSet contient des données..
		if (rs.next()) {
			// On charge ces données dans un nouvel objet de type Compagnie
			Compagnie compagnie = new Compagnie();
			// la donnée lue dans la colonne nom est affecté au nom
			// de l'objet compagnie
			compagnie.setNom(rs.getString("nom"));
			// la donnée lue dans la colonne id est affecté au nom
			// de l'objet compagnie
			compagnie.setId(rs.getLong("id"));
			return compagnie;
		}		
		return null;
	}

	@Override
	public List<Compagnie> findAll() throws SQLException {
		List<Compagnie> compagnies = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_COMPAGNIES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Compagnie compagnie = new Compagnie(rs.getString("nom"));
			compagnie.setId(rs.getLong("id"));
			compagnies.add(compagnie);
		}		
		return compagnies;
	}

}
