package world;

import java.awt.Color;
import java.util.Random;

public class Snail extends Animal{

	public Snail(int posX, int posY) {
		super(posX, posY);
		color = Color.pink;
		strenght = 1;
		initiative = 1;
		paralysis = 0;
		age = 0;
		symbol = 'S';
		name = "Slimak";
	}
	@Override
	public boolean canI(Organism org)
	{
		if (org.getStrenght() < 2)	//jeœli sila przeciwnika mniejsza od 2 to nie moze zaatakowac
			return false;
		if (org.getStrenght() > 4)	//jeœli sila przeciwnika wieksza od 4 to 60% szans na nie moze zaatakowac
		{
			Random generator = new Random();
			int rand_int = generator.nextInt(10);
			if(rand_int<6)
				return false;
		}
		return true;				//jeœli nie, to mo¿e zaatakowaæ
	}
	@Override
	public void action(){
		Random generator = new Random();
		if(generator.nextInt(10)==1)	//10% szans na wykonanie akcji
			super.action();				//wykonanie akcji z klasy bazowej
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Slimak rozmnaza sie");
		super.createNew(new Snail(posX,posY));
	}
	@Override
	public void specialEffect(Organism org) {};
}
