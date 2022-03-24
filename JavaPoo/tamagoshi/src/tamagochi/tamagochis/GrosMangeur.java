package tamagochi.tamagochis;

public class GrosMangeur extends Tamagoshi
{
	public GrosMangeur(String name,int age_limite)
	{
		super(name,age_limite);
	}
	
	public void consommeEnergie()
	{
		this.setEnergy(this.getEnergy()-2);	
		System.out.println("JEEEEEEEE SUIS LE GROOOOOOOOS MANGEUR");
	}
}
