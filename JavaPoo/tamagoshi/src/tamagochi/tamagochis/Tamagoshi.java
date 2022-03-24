package tamagochi.tamagochis;

import java.util.Random;

public class Tamagoshi 
{
	private int age;
	private int maxEnergy;
	private int energy;
	private int fun;
	private int maxFun;
	private String name;
	private static int lifeTime = 10;
	private final int MAX_INITIALISATION_MAX_ENERGY = 9;
	private final int MIN_INITIALISATION_MAX_ENERGY = 5;
	private final int MAX_INITIALISATION_MAX_FUN = 9;
	private final int MIN_INITIALISATION_MAX_FUN = 5;
	private final int MAX_INITIALISATION_ENERGY = 7;
	private final int MIN_INITIALISATION_ENERGY = 3;
	private final int MAX_INITIALISATION_FUN = 7;
	private final int MIN_INITIALISATION_FUN = 3;
	private final int MIN_PDV_RECUP = 1;
	private final int MAX_PDV_RECUP = 3;
	private int age_limite;
	private boolean isAlive = true;
	private Random random = new Random();
	
	public Tamagoshi(String name,int age_limite)
	{
		this.age_limite=age_limite;
		this.name = name;
		this.age=0;
		this.maxEnergy=random.nextInt(MAX_INITIALISATION_MAX_ENERGY-MIN_INITIALISATION_MAX_ENERGY+1)+MIN_INITIALISATION_MAX_ENERGY;
		this.setEnergy(random.nextInt(MAX_INITIALISATION_ENERGY-MIN_INITIALISATION_ENERGY+1)+MIN_INITIALISATION_ENERGY);
		this.maxFun=random.nextInt(MAX_INITIALISATION_MAX_FUN-MIN_INITIALISATION_MAX_FUN+1)+MIN_INITIALISATION_MAX_FUN;
		this.setFun(random.nextInt(MAX_INITIALISATION_FUN-MIN_INITIALISATION_FUN+1)+MIN_INITIALISATION_FUN);
		
	}
	public void setEnergy(int energy)
	{
		if(energy>this.maxEnergy)
		{
			this.energy=this.maxEnergy;
		}
		else
		{
			this.energy = energy;
		}
		if(energy<=0)
		{
			this.isAlive=false;
		}
	}
	public void vieillit()
	{
		this.age++;
		if(this.age_limite<=this.age)
		{
			this.isAlive=false;
		}
	}
	public int getFun() 
	{
		return fun;
	}
	public void setFun(int fun) 
	{
		if(fun>this.maxFun)
		{
			this.fun=this.maxFun;
		}
		else
		{
			this.fun = energy;
		}
		if(energy<=0)
		{
			this.isAlive=false;
		}
	}
	public int getMaxFun() 
	{
		return maxFun;
	}
	public int getEnergy() 
	{
		return this.energy;
	}
	
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean checkAlive()
	{
		if(!isAlive)
		{
			System.out.println(this.getName()+ " : Je suis KO");
			return false;
		}
		
		return true;
		
	}
	public boolean parle()
	{
		String etat;
		boolean b_etat;
		
		if(this.energy>4)
		{
			etat = "Heureux";
			b_etat=true;
		}
		else
		{
			etat = "Affamé";
			b_etat=false;
		}
		System.out.print(etat);
		return b_etat;
	}
	public boolean mange()
	{
		boolean content;
		String s_content;
		if(energy<maxEnergy)
		{
			this.setEnergy(random.nextInt(MAX_PDV_RECUP-MIN_PDV_RECUP+1)+MIN_PDV_RECUP+this.energy);
			content=true;
			System.out.println("Tamagoshi content");
			
		}
		else
		{
			System.out.println("Il n'a pas faim !");
			content=false;
		}
		
		return content;
	}
	public void joue()
	{
		setFun(getFun()+1);
		System.out.println("Merci de jouer avec moi !");
	}
	public void ennuie()
	{
		this.setFun(getFun()-1);
	}
	public void consommeEnergie()
	{
		this.setEnergy(this.energy-1);
		
	}
	
	public String toString()
	{ 
		return "nom = "+this.name+"\nenergie max = "+maxEnergy+"\nenergie ="+energy+"\nage = "+age;
	}
	

}
