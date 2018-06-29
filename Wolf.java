package world;

import java.awt.Color;

public class Wolf  extends Animal{
	public Wolf(int posX, int posY) {
		super(posX, posY);
		color = Color.gray;
		strenght = 9;
		initiative = 5;
		paralysis = 0;
		age = 0;
		symbol = 'W';
		name = "Wilk";
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Wilk rozmnaza sie");
		super.createNew(new Wolf(posX,posY));
	}
	@Override
	public void specialEffect(Organism org) {};
}