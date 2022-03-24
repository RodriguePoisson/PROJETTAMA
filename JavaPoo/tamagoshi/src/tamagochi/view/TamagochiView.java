package tamagochi.view;

import java.awt.Graphics;

import tamagochi.tamagochis.Tamagoshi;

public class TamagochiView 
{
	private Tamagoshi tamagochi;
	public static int nbTama=0;
	public TamagochiView(Tamagoshi tama)
	{
		nbTama++;
		this.tamagochi = tama;
	}
	public int getNbTama() {return nbTama;}
	
	public void getView(Graphics g)
	{
		int x = nbTama*100;
		int y = 100;
		int width = 50;
		int height = 50;
		
		int x_oeil1= x+7;
		int x_oeil2 = x+width-(width/2)-7;
		int y_yeux = y+7;
		g.drawRect(x, y, width, height);
		
		if(tamagochi.checkAlive())
		{
			int width_yeux = 10;
			
			g.drawRect(x_oeil1,y_yeux,width_yeux,width_yeux);
			g.drawRect(x_oeil2,y_yeux,width_yeux,width_yeux);
			int x_bouche = x+width/2-10;
			int y_bouche = y+height -20;
			if(tamagochi.parle())
			{
				g.drawOval(x_bouche, y_bouche, 20, 10);
			}
			else
			{
				g.drawLine(x_bouche, y_bouche, x_bouche+15, y_bouche);
			}
		}
		else
		{
			g.drawString("MORT", x+5, y+30);
		}
		g.drawString(tamagochi.getName(), x, y+20+height);
		g.drawString("Vie : "+tamagochi.getEnergy(), x, y+60+height);
		g.drawString("Fun : "+tamagochi.getFun(), x, y+100+height);
		g.drawString("Age : "+tamagochi.getFun(), x, y+140+height);
		
		
	}
		
}
