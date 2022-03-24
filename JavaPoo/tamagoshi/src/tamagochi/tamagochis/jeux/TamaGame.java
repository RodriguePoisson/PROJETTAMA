package tamagochi.tamagochis.jeux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

import tamagochi.tamagochis.GrosJoueur;
import tamagochi.tamagochis.GrosMangeur;
import tamagochi.tamagochis.Tamagoshi;
import tamagochi.tamagochis.util.Utilisateur;
import tamagochi.view.FenetrePrincipale;

public class TamaGame 
{
	private static ArrayList<Tamagoshi> tamaEnCourse = new ArrayList<Tamagoshi>();
	private static ArrayList<Tamagoshi> tamaDepart = new ArrayList<Tamagoshi>();
	private int nombreTamagoshi;
	private int scoreFinal=0;
	private Random random = new Random();
	public static FenetrePrincipale fenetre;
	private boolean finJeux=false;
	public TamaGame()
	{
	}
	public static ArrayList<Tamagoshi>getTamaEnCourse() {return tamaEnCourse;}
	public static ArrayList<Tamagoshi>getTamaDepart() {return tamaDepart;}
	
	public void initialisation()
	{
		String saisie;
		System.out.println("nombre de tamagoshi  :");
		saisie =Utilisateur.saisieClavier();
		
		nombreTamagoshi= Integer.parseInt(saisie);

		for(int i=0;i<nombreTamagoshi;i++)
		{
			System.out.println("Nom Tama numéro "+i+" :");
			String nom_tama = Utilisateur.saisieClavier();
			System.out.println("Age limite de "+nom_tama+" :");
			String age_saisie = Utilisateur.saisieClavier();
			int age_limite = Integer.parseInt(age_saisie);
			int unsurdeux = random.nextInt(2);
			if(unsurdeux==0)
			{
				tamaDepart.add(new Tamagoshi(nom_tama,age_limite));
				tamaEnCourse.add(new Tamagoshi(nom_tama,age_limite));
			}
			else
			{
				unsurdeux = random.nextInt(2);
				if(unsurdeux==0)
				{
					tamaDepart.add((Tamagoshi)new GrosMangeur(nom_tama, age_limite));
					tamaEnCourse.add((Tamagoshi)new GrosMangeur(nom_tama, age_limite));
				}
				else
				{
					tamaDepart.add((Tamagoshi)new GrosJoueur(nom_tama, age_limite));
					tamaEnCourse.add((Tamagoshi)new GrosJoueur(nom_tama, age_limite));
				}
			}
			
		}
		fenetre = new FenetrePrincipale();
	}
	
	private int score()
	{
		int to_return=0;
		for(Tamagoshi t : tamaEnCourse)
		{
			to_return+=t.getAge();
		}
		return to_return;
	}
	
	
	private void TamasParle()
	{
		for(Tamagoshi tama : this.tamaEnCourse)
		{
			System.out.print(tama.getName()+" : ");
			tama.parle();
			System.out.println();
			System.out.println();
		}
	}
	private Tamagoshi choisirTama(String message_action)
	{
		ListIterator<Tamagoshi> iterator = tamaEnCourse.listIterator();
		
		while(iterator.hasNext())
		{
			int index = iterator.nextIndex();
			Tamagoshi tama = iterator.next();
			System.out.print("  ("+index+") "+ tama.getName()+"   ");
			tama.parle();
		}
		System.out.println("");
		System.out.println(message_action);
		String reponse_utilisateur = Utilisateur.saisieClavier();
		return tamaEnCourse.get(Integer.parseInt(reponse_utilisateur));
	}
	private void nourirTama(Tamagoshi tama)
	{
		tama.mange();
	}
	private void jouerTama(Tamagoshi tama)
	{
		tama.joue();
	}
	
	public static boolean checkFinJeux()
	{
		if(TamaGame.getTamaEnCourse().size()<=1)
		{
			return true;
		}
		return false;
	}
	
	public void play()
	{
	
		this.initialisation();
		TourDeJeu tour = new TourDeJeu();
		tour.start();
	}
}
