package tamagochi.view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;

import tamagochi.tamagochis.Tamagoshi;
import tamagochi.tamagochis.jeux.TamaGame;

public class Interaction extends Container
{
	public Interaction()
	{
		JButton nourir = new JButton("Nourir");
		JButton jouer = new JButton("Jouer");
		
		nourir.addActionListener(e->
		{
			for(Tamagoshi tama:TamaGame.getTamaEnCourse())
			{
				tama.mange();
				TamaGame.fenetre.actualise();
			}
		});
		jouer.addActionListener(e->
		{
			for(Tamagoshi tama:TamaGame.getTamaEnCourse())
			{
				tama.joue();
				TamaGame.fenetre.actualise();
			}
		});
		
		
		this.setLayout(new FlowLayout());
		this.add(nourir);
		this.add(jouer);
	}
}
