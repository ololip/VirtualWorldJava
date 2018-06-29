package world;

import java.awt.Color;

public class Hedgehog extends Animal{
	public Hedgehog(int posX, int posY) {
		super(posX, posY);
		color = Color.cyan;
		strenght = 2;
		initiative = 3;
		paralysis = 0;
		age = 0;
		symbol = 'J';
		name = "Jez";
	}
	@Override
	public void specialEffect(Organism enemy){
		enemy.setParalysis(2);
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Jez rozmnaza sie");
		super.createNew(new Hedgehog(posX,posY));
	}
}
