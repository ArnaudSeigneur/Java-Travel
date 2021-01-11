package fr.humanbooster.fx.travel.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.travel.business.Vol;

public interface VolDao {

	Vol create(Vol vol) throws SQLException;

	List<Vol> findAll() throws SQLException;

}
