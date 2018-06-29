package world;

import java.awt.Color;

public class Grass extends Plant{

	public Grass(int posX, int posY) {
		super(posX, posY);
		color = Color.green;
		strenght = 0;
		initiative = 0;
		symbol = 'T';
		name = "Trawa";
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Trawa rozrasta sie");
		super.createNew(new Grass(posX,posY));
	}
	@Override
	public void specialEffect(Organism org) {};
}
