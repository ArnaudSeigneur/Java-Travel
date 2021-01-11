package fr.humanbooster.fx.travel.service;

import java.util.List;

import fr.humanbooster.fx.travel.business.Compagnie;

public interface CompagnieService {

	Compagnie ajouterCompagnie(String nom);
	
	Compagnie recupererCompagnie(Long id);
	List<Compagnie> recupererCompagnies();
	
}
