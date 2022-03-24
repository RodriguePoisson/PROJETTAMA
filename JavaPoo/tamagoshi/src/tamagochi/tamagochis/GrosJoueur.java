package tamagochi.tamagochis;

public class GrosJoueur extends Tamagoshi
{
	public GrosJoueur(String name,int age_limite)
	{
		super(name,age_limite);
	}
	public void ennuie()
	{
		this.setFun(getFun()-2);
	}
}
