package fr.humanbooster.fx.travel.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.travel.business.Vol;

public interface VolService {

	Vol ajouterVol(long idCompagnie, long idAeroportDepart, long idAeroportArrivee, Date dateHeureDepart,
			Date dateHeureArrivee, float prixEnEuros);
		
	List<Vol> recupererVols();
	
}
