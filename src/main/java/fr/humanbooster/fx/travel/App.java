package fr.humanbooster.fx.travel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import fr.humanbooster.fx.travel.business.Aeroport;
import fr.humanbooster.fx.travel.business.Compagnie;
import fr.humanbooster.fx.travel.business.Vol;
import fr.humanbooster.fx.travel.service.AeroportService;
import fr.humanbooster.fx.travel.service.CompagnieService;
import fr.humanbooster.fx.travel.service.VolService;
import fr.humanbooster.fx.travel.service.impl.AeroportServiceImpl;
import fr.humanbooster.fx.travel.service.impl.CompagnieServiceImpl;
import fr.humanbooster.fx.travel.service.impl.VolServiceImpl;

public class App {
	
	private static final int AJOUTER_COMPAGNIE = 1;
	private static final int AFFICHER_COMPAGNIES = 2;
	private static final int AJOUTER_VOL = 3;
	private static final int AFFICHER_VOLS = 4;
	private static final int QUITTER = 5;
	
	private static AeroportService aeroportService = new AeroportServiceImpl();
	private static CompagnieService compagnieService = new CompagnieServiceImpl();
	private static VolService volService = new VolServiceImpl();
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ajouterAeroports();
		ajouterCompagniesInitiales();

		while (true) {
			afficherMenuPrincipal();
			int choix = demanderChoix("Entrez votre choix : ", 1, 5);
			switch (choix) {
			case AJOUTER_COMPAGNIE:
				ajouterCompagnie();
				break;
			case AFFICHER_COMPAGNIES:
				afficherCompagnies();
				break;
			case AJOUTER_VOL:
				ajouterVol();
				break;
			case AFFICHER_VOLS:
				afficherVols();
				break;
			case QUITTER:
				System.out.println("Au revoir");
				System.exit(0);
				break;
			default:
				break;
			}	
		}		
	}
	
	private static void afficherVols() {
		for (Vol vol : volService.recupererVols()) {
			System.out.println(vol.getId() + " : " + vol.getCompagnie().getNom());
		}				
	}

	private static void afficherCompagnies() {
		System.out.println("Voici la liste exhaustive des compagnies : ");
		for (Compagnie compagnie : compagnieService.recupererCompagnies()) {
			System.out.println(compagnie.getId() + " : " + compagnie.getNom());
		}		
	}

	private static void afficherAeroports() {
		System.out.println("Voici la liste exhaustive des aéroports : ");
		for (Aeroport aeroport : aeroportService.recupererAeroports()) {
			System.out.println(aeroport.getId() + " : " + aeroport.getNom());
		}		
	}

	private static void ajouterCompagnie() {
		System.out.println("Entre le nom de la nouvelle compagnie");
		compagnieService.ajouterCompagnie(scanner.nextLine());
	}

	private static void ajouterVol() {
		
		afficherAeroports();
		Long idAeroportDepartChoisi = (long) demanderChoix("Entrez l'id de l'aeroport de départ : ", 1, aeroportService.recupererAeroports().size());
		Long idAeroportArriveeChoisi = (long) demanderChoix("Entrez l'id de l'aeroport d'arrivée : ", 1, aeroportService.recupererAeroports().size());
				
		afficherCompagnies();
		Long idCompagnieChoisi = (long) demanderChoix("Entrez l'id de la compagnie : ", 1, compagnieService.recupererCompagnies().size());
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		Date dateHeureDepart = demanderDate("Entrez l'heure de départ : ", simpleDateFormat);
		Date dateHeureArrivee = demanderDate("Entrez l'heure d'arrivée : ", simpleDateFormat);

		System.out.println("Entrez le pris en euros : ");
		float prixEnEuros = Float.parseFloat(scanner.nextLine());
		
		Vol vol = volService.ajouterVol(idCompagnieChoisi, idAeroportDepartChoisi, idAeroportArriveeChoisi, dateHeureDepart, dateHeureArrivee, prixEnEuros);
		
		System.out.println("Le vol a bien été ajouté, il porte l'id " + vol.getId() + ". Aeroport de départ :" 
		+ aeroportService.recupererAeroport(idAeroportDepartChoisi)
		+ ", Aeroport d'arrivée : " + aeroportService.recupererAeroport(idAeroportArriveeChoisi) 
		+ ". compagnie : " + compagnieService.recupererCompagnie(idCompagnieChoisi) + ". Prix du vol : " + prixEnEuros);
	}

	private static void afficherMenuPrincipal() {
		System.out.println("Bienvenue sur HB Travel !");
		System.out.println(AJOUTER_COMPAGNIE + " : ajouter une compagnie");
		System.out.println(AFFICHER_COMPAGNIES + " : voir toutes les compagnies");
		System.out.println(AJOUTER_VOL + " : ajouter un vol");
		System.out.println(AFFICHER_VOLS + " : voir les vols triés sur le prix (du moins cher au plus cher)");
		System.out.println(QUITTER + " : quitter");	
	}

	private static void ajouterCompagniesInitiales() {
		//On ajoute des compagnies si la table est vide
		if (compagnieService.recupererCompagnies().isEmpty()) {
			compagnieService.ajouterCompagnie("Bel Air");
			compagnieService.ajouterCompagnie("Air HB");
		}		
	}

	private static void ajouterAeroports() {
		// On ajoute des aeroports si la table est vide
		if (aeroportService.recupererAeroports().isEmpty()) {
			aeroportService.ajouterAeroport("Majorque");
			aeroportService.ajouterAeroport("Lyon");
			aeroportService.ajouterAeroport("Bucarest");
		}
		
	}
	
    private static int demanderChoix(String message, int borneMin, int borneMax) {
        int valeur = borneMin-1;
        // Utilisation d'une boucle do while
        // Le code dans le do sera exécuté au moins une fois
        do {
                System.out.println(message);
                try {
                        String saisie = scanner.nextLine();
                        valeur = Integer.parseInt(saisie);
                        if (valeur<borneMin || valeur>borneMax)
                        {
                                System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax );
                        }
                }
                catch (Exception e)
                {
                        System.out.println("Merci de saisir un nombre");
                }

        }
        while (!(valeur>=borneMin && valeur<=borneMax));
        return valeur;
    }

    private static Date demanderDate(String message, SimpleDateFormat simpleDateFormat) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();

		do {
			System.out.println(message);
			try {
				date = simpleDateFormat.parse(scanner.nextLine());
			} catch (ParseException e) {
				System.out.println("Format incorrect");
			}				
			if (date!=null) calendar.setTime(date);
		} while (date == null);
		
		return calendar.getTime();
	}
    
}