package tamagochi.tamagochis.jeux;

import java.util.ListIterator;

import tamagochi.tamagochis.Tamagoshi;

public class TourDeJeu extends Thread
{
	public TourDeJeu()
	{
	
	}
	
	@Override
	public void run()
	{
		try 
		{
			while(true)
			{
				this.sleep(3000);
				finDeCycle();
				TamaGame.fenetre.actualise();
				System.out.println("pas fini");
				if(!TamaGame.checkFinJeux())
				{
					System.out.println("fini");
					break;
				}
			}
			TamaGame.fenetre.actualise();
			
			

		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void finDeCycle()
	{
		ListIterator<Tamagoshi> iterator = TamaGame.getTamaEnCourse().listIterator();
		while(iterator.hasNext())
		{
			Tamagoshi tama = iterator.next();
			tama.consommeEnergie();
			tama.ennuie();
		}
	}
	
}
