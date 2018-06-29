package world;

import java.awt.Color;

public class Belladonna extends Plant{

	public Belladonna(int posX, int posY) {
		super(posX, posY);
		color = Color.black;
		strenght = 0;
		initiative = 0;
		symbol = 'B';
		name = "Wilcze jagody";
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Wilcze jagody rozrastja sie");
		super.createNew(new Belladonna(posX,posY));
	}
	@Override
	public void specialEffect(Organism enemy){
		System.out.println("i sam ginie");
		world.removeOrganism(enemy);
	}
}
