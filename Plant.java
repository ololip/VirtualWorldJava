package world;

import java.awt.Graphics;
import java.util.Random;

public abstract class Plant  extends Organism{
	public Plant(int posX, int posY) {
		super(posX, posY);
	}
	@Override
	public void paintComponent(Graphics g){
		g.setColor(color);
		g.fillRect(positionX, positionY, 20, 20);
	}
	@Override
	public void action(){
		Random generator = new Random();
		int random_int = generator.nextInt(40);
		if(random_int == 0)
			sowUp();
		else if(random_int == 1)
			sowDown();
		else if(random_int == 2)
			sowRight();
		else  if(random_int == 3)
			sowLeft();
			
		repaint();
	}
	public void sowUp(){
		if(world.freeSpace(getPosX(), getPosY()+20))
			createNew(getPosX(),getPosY()+20);
	}
	public void sowDown(){
		if(world.freeSpace(getPosX(), getPosY()-20))
			createNew(getPosX(),getPosY()-20);
	}
	public void sowRight(){
		if(world.freeSpace(getPosX()+20, getPosY()))
			createNew(getPosX()+20, getPosY());
	}
	public void sowLeft(){
		if(world.freeSpace(getPosX()-20, getPosY()))
			createNew(getPosX()-20, getPosY());
	}
}