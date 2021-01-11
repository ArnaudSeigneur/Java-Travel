package fr.humanbooster.fx.travel.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.travel.business.Aeroport;

public interface AeroportDao {

	Aeroport create(Aeroport aeroport) throws SQLException;
	
	Aeroport findOne(Long id) throws SQLException;
	List<Aeroport> findAll() throws SQLException;
	
}
