package world;

import java.util.Random;

public abstract class Animal extends Organism{

	public Animal(int posX, int posY) {
		super(posX, posY);
	}
	@Override
	public void action(){

		if (paralysis > 0)
		{
			setParalysis(paralysis - 1);
		}
		else
		{
			Random generator = new Random();
			int random_int = generator.nextInt(4);
			if(random_int == 0)
				moveUp();
			else if(random_int == 1)
				moveDown();
			else if(random_int == 2)
				moveRight();
			else 
				moveLeft();
		}
		repaint();
	}
	public void moveUp(){
		if(world.freeSpace(getPosX(), getPosY()+20))
			setPosY(getPosY()+20);
		else if(world.whoIs(getPosX(), getPosY()+20) != null)
		{
			collision(world.whoIs(getPosX(), getPosY()+20));
		}
	}
	public void moveDown(){
		if(world.freeSpace(getPosX(), getPosY()-20))
			setPosY(getPosY()-20);
		else if(world.whoIs(getPosX(), getPosY()-20) != null)
		{
			collision(world.whoIs(getPosX(), getPosY()-20));
		}
	}
	public void moveRight(){
		if(world.freeSpace(getPosX()+20, getPosY()))
			setPosX(getPosX()+20);
		else if(world.whoIs(getPosX()+20, getPosY()) != null)
		{
			collision(world.whoIs(getPosX()+20, getPosY()));
		}
	}
	public void moveLeft(){
		if(world.freeSpace(getPosX()-20, getPosY()))
			setPosX(getPosX()-20);
		else if(world.whoIs(getPosX()-20, getPosY()) != null)
		{
			collision(world.whoIs(getPosX()-20, getPosY()));
		}
	}
}
