package fr.humanbooster.fx.travel.service;

import java.util.List;

import fr.humanbooster.fx.travel.business.Aeroport;

public interface AeroportService {

	Aeroport ajouterAeroport(String aeroport);
	
	Aeroport recupererAeroport(Long id);
	List<Aeroport> recupererAeroports();
	
}
