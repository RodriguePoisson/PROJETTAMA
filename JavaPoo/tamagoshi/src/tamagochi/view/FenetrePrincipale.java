package tamagochi.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import tamagochi.tamagochis.jeux.TamaGame;

public class FenetrePrincipale extends JFrame
{
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	private Terrain terrain;
	
	public FenetrePrincipale()
	{
		super("Tamagochi");
		gbc = new GridBagConstraints();
		layout = new GridBagLayout();
		gbc.gridx=0;
		gbc.gridy=0;
		this.setLayout(layout);
		this.setSize(600,600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	    terrain = new Terrain(TamaGame.getTamaEnCourse());
		layout.setConstraints(terrain, gbc);
		this.add(terrain);
		gbc.gridy=1;
		Interaction interac = new Interaction();
		layout.setConstraints(interac, gbc);
		this.add(interac);
	}
	
	public void actualise()
	{
		this.remove(terrain);
		
		gbc.gridy = 0;
		terrain = new Terrain(TamaGame.getTamaEnCourse());
		layout.setConstraints(terrain, gbc);
		this.add(terrain);
		gbc.gridy=1;
		Interaction interac = new Interaction();
		layout.setConstraints(interac, gbc);
		this.add(interac);
	}
	
}
