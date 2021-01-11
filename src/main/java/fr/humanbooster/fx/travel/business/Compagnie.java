package fr.humanbooster.fx.travel.business;

import java.util.ArrayList;
import java.util.List;

public class Compagnie {

	private Long id;
	private String nom;
	private List<Vol> vols = new ArrayList<>();

	public Compagnie() {
		// TODO Auto-generated constructor stub
	}
	
	public Compagnie(String nom) {
		super();
		this.nom = nom;
	}

	public Compagnie(String nom, List<Vol> vols) {
		super();
		this.nom = nom;
		this.vols = vols;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	@Override
	public String toString() {
		return "Compagnie [id=" + id + ", nom=" + nom + ", vols=" + vols + "]";
	}

}
