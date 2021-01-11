package fr.humanbooster.fx.travel.business;

import java.util.Date;

public class Vol {

	private Long id;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private Date dateHeureDepart;
	private Date dateHeureArrivee;
	private float prixEnEuros;
	private Compagnie compagnie;

	public Vol() {
	}
	

	public Vol(Compagnie compagnie) {
		super();
		this.compagnie = compagnie;
	}

	public Vol(Aeroport aeroportDepart, Aeroport aeroportArrivee, Date dateHeureDepart, Date dateHeureArrivee,
			float prixEnEuros, Compagnie compagnie) {
		super();
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.dateHeureDepart = dateHeureDepart;
		this.dateHeureArrivee = dateHeureArrivee;
		this.prixEnEuros = prixEnEuros;
		this.compagnie = compagnie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Date getDateHeureDepart() {
		return dateHeureDepart;
	}

	public void setDateHeureDepart(Date dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}

	public Date getDateHeureArrivee() {
		return dateHeureArrivee;
	}

	public void setDateHeureArrivee(Date dateHeureArrivee) {
		this.dateHeureArrivee = dateHeureArrivee;
	}

	public float getPrixEnEuros() {
		return prixEnEuros;
	}

	public void setPrixEnEuros(float prixEnEuros) {
		this.prixEnEuros = prixEnEuros;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", aeroportDepart=" + aeroportDepart + ", aeroportArrivee=" + aeroportArrivee
				+ ", dateHeureDepart=" + dateHeureDepart + ", dateHeureArrivee=" + dateHeureArrivee + ", prixEnEuros="
				+ prixEnEuros + ", compagnie=" + compagnie + "]";
	}
}
