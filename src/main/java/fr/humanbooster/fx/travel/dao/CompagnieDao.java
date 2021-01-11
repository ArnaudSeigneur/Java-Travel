package fr.humanbooster.fx.travel.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.travel.business.Compagnie;

public interface CompagnieDao {

public Compagnie create(Compagnie compagnie) throws SQLException;
	
	Compagnie findOne(Long id) throws SQLException;
	List<Compagnie> findAll() throws SQLException;
	
}
