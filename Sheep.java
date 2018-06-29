package world;

import java.awt.Color;

public class Sheep extends Animal{

	public Sheep(int posX, int posY) {
		super(posX, posY);
		color = Color.yellow;
		strenght = 4;
		initiative = 4;
		paralysis = 0;
		age = 0;
		symbol = 'O';
		name = "Owca";
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Owca rozmnaza sie");
		super.createNew(new Sheep(posX,posY));
	}
	@Override
	public void specialEffect(Organism org) {};
}
