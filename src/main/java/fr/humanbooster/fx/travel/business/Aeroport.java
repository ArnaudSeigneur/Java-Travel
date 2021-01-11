package fr.humanbooster.fx.travel.business;

public class Aeroport {

	private Long id;
	private String nom;

	public Aeroport() {
		// TODO Auto-generated constructor stub
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Aeroport [id=" + id + ", nom=" + nom + "]";
	}
	
}
