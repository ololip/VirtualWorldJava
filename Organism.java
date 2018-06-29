package world;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class Organism extends JComponent{
	World world;
	protected int positionX;
	protected int positionY;
	protected int strenght;
	protected int initiative;
	protected int paralysis;
	protected String name;
	protected char symbol;
	protected int age;
	protected Color color;
	public Organism(int posX, int posY){
		positionX = posX;
		positionY = posY;
		age = 0;
		symbol = '?';
		paralysis = 0;
		strenght = 0;
		initiative = 0;
		color = Color.blue;
	}
	abstract void action();
	public void paintComponent(Graphics g){
		g.setColor(color);
		g.fillOval(positionX, positionY, 20, 20);
	}
	public String getName(){
		return name;
	}
	public void setAge(int a){
		age = a;
	}
	public void increaseAge(){
		age++;
	}
	public int getAge(){
		return age;
	}
	public void setInitiative(int i){
		initiative = i;
	}
	public int getInitiative(){
		return initiative;
	}
	public void setSymbol(char s){
		symbol = s;
	}
	public char getSymbol(){
		return symbol;
	}
	public void setStrenght(int s){
		strenght = s;
	}
	public int getStrenght(){
		return strenght;
	}
	public void setParalysis(int p){
		paralysis = p;
	}
	public int getParalysis(){
		return paralysis;
	}
	public void setPosX(int x){
		positionX = x;
	}
	public int getPosX(){
		return positionX;
	}
	public void setPosY(int y){
		positionY = y;
	}
	public int getPosY(){
		return positionY;
	}
	public void setWorld(World w){
		world = w;
	}
	public boolean samePosition(int posX, int posY){
		if (positionX == posX && positionY == posY)
			return true;
		return false;
	}
	public void collision(Organism enemy){
		if(getSymbol() == enemy.getSymbol())		//sprawdzenie czy to organizm tego samego rodzaju
		{
			if(world.freeSpace(getPosX(), getPosY()+20))		//sprawdzenie 4 pozycji wokol jednego organizmu
				createNew(getPosX(),getPosY()+20);				//i utworzenie nowego organizmu (rozmnazanie)
			else if(world.freeSpace(getPosX(), getPosY()-20))
				createNew(getPosX(),getPosY()-20);
			else if(world.freeSpace(getPosX()+20, getPosY()))
				createNew(getPosX()+20,getPosY());
			else if(world.freeSpace(getPosX()-20, getPosY()))
				createNew(getPosX()-20,getPosY());
			else if(world.freeSpace(enemy.getPosX(), enemy.getPosY()+20))	//sprawdzanie 4 pozycji wokol drugiego organizmu
				createNew(enemy.getPosX(),enemy.getPosY()+20);
			else if(world.freeSpace(enemy.getPosX(), enemy.getPosY()-20))
				createNew(enemy.getPosX(),enemy.getPosY()-20);
			else if(world.freeSpace(enemy.getPosX()+20, enemy.getPosY()))
				createNew(enemy.getPosX()+20,enemy.getPosY());
			else if(world.freeSpace(enemy.getPosX()-20, enemy.getPosY()))
				createNew(enemy.getPosX()-20,enemy.getPosY());
		}
		else if(enemy.canI(this))	//sprawdzenie, czy coœ nie blokuje ataku (slimak)
		{
			if (getStrenght() > enemy.getStrenght())
			{
				System.out.println(getName() + " pokonuje " + enemy.getName());
				fight(enemy,true);
			} else if (getStrenght() < enemy.getStrenght())
			{
				System.out.println(enemy.getName() + " pokonuje " + getName());
				fight(enemy,false);
			} else if (getInitiative() > enemy.getInitiative())
			{
				System.out.println(getName() + " pokonuje " + enemy.getName());
				fight(enemy,true);
			}else if (getInitiative() < enemy.getInitiative())
			{
				System.out.println(enemy.getName() + " pokonuje " + getName());
				fight(enemy,false);
			} else if (getAge() > enemy.getAge())
			{
				System.out.println(getName() + " pokonuje " + enemy.getName());
				fight(enemy,true);
			}else if (getAge() < enemy.getAge())
			{
				System.out.println(enemy.getName() + " pokonuje " + getName());
				fight(enemy,false);
			} else
			{
				System.out.println(getName() + " pokonuje " + enemy.getName());
				fight(enemy,true);
			}
		}
		
	}
	abstract void createNew(int posX, int posY);
	public void createNew(Organism org)
	{
		world.createOrganism(org);
	}
	abstract void specialEffect(Organism enemy);
	public void fight(Organism enemy, boolean win){
		if(win)
		{
			setPosX(enemy.getPosX());
			setPosY(enemy.getPosY());
			enemy.specialEffect(this);
			world.removeOrganism(enemy);			
		}
		else
		{
			specialEffect(enemy);
			world.removeOrganism(this);
		}
	}
	public boolean canI(Organism org) { return true; }	//metoda dla slimaka, dla reszty zwraca true
}
