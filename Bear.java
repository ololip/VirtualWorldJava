package world;

import java.awt.Color;

public class Bear extends Animal{
	public Bear(int posX, int posY) {
		super(posX, posY);
		color = Color.magenta;
		strenght = 12;
		initiative = 6;
		tiredness = 1;
		paralysis = 0;
		age = 0;
		symbol = 'N';
		name = "Niedzwiedz";
	}
	private int tiredness;
	@Override
	public void action(){
		if (tiredness <= 5 && paralysis == 0)
		{
			tiredness++;
			strenght--;
		}
		else
		{
			tiredness--;
			strenght++;
			paralysis = tiredness;
		}
		super.action();
	}
	@Override
	public void createNew(int posX, int posY)
	{
		System.out.println("Niedzwiedz rozmnaza sie");
		super.createNew(new Bear(posX,posY));
	}
	@Override
	public void specialEffect(Organism org) {};
}
