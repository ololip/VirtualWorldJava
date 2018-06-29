package world;

import java.awt.Color;

public class Coffea extends Plant{

	public Coffea(int posX, int posY) {
		super(posX, posY);
		color = Color.red;
		strenght = 0;
		initiative = 0;
		paralysis = 0;
		age = 0;
		symbol = 'K';
		name = "Kawowiec";
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Kawowiec rozrasta sie");
		super.createNew(new Coffea(posX,posY));
	}
	@Override
	public void specialEffect(Organism enemy){
		System.out.println("i otrzymuje dodatkowy ruch");
		enemy.action();
	}
}
