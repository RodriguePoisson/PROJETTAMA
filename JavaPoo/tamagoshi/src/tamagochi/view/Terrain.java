package tamagochi.view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

import tamagochi.tamagochis.Tamagoshi;
public class Terrain extends Canvas
{
	private ArrayList<Tamagoshi> listeTama;
	public Terrain(ArrayList<Tamagoshi> listeTama)
	{
		super();
		this.listeTama=listeTama;
		this.setSize(500,500);
	}
	
	public void paint(Graphics g)
	{
		System.out.println("ok");
		for(Tamagoshi tama :listeTama)
		{
			TamagochiView tamaView = new TamagochiView(tama);
			tamaView.getView(g);
		}
		TamagochiView.nbTama=0;
	}
}
