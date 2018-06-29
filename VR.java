package world;

import java.util.Random;

public class VR {

	public static void main(String[] args) {
		World world = new World();
		Random generator = new Random();
		int x = (generator.nextInt(world.getWorldSize()));
		int y = (generator.nextInt(world.getWorldSize()));

		Sheep owca1 = new Sheep(x-x%20,y-y%20);
		world.createOrganism(owca1);
		
		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Sheep owca2 = new Sheep(x-x%20,y-y%20);
		world.createOrganism(owca2);
		
		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Wolf wilk1 = new Wolf(x-x%20,y-y%20);
		world.createOrganism(wilk1);
		
		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Wolf wilk2 = new Wolf(x-x%20,y-y%20);
		world.createOrganism(wilk2);
		
		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Grass trawa1 = new Grass(x-x%20,y-y%20);
		world.createOrganism(trawa1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Belladonna jagody1 = new Belladonna(x-x%20,y-y%20);
		world.createOrganism(jagody1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Coffea kawowiec1 = new Coffea(x-x%20,y-y%20);
		world.createOrganism(kawowiec1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Snail slimak1 = new Snail(x-x%20,y-y%20);
		world.createOrganism(slimak1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Snail slimak2 = new Snail(x-x%20,y-y%20);
		world.createOrganism(slimak2);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Bear niedzwiedz1 = new Bear(x-x%20,y-y%20);
		world.createOrganism(niedzwiedz1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Bear niedzwiedz2 = new Bear(x-x%20,y-y%20);
		world.createOrganism(niedzwiedz2);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Hedgehog jez1 = new Hedgehog(x-x%20,y-y%20);
		world.createOrganism(jez1);

		x = (generator.nextInt(world.getWorldSize()));
		y = (generator.nextInt(world.getWorldSize()));
		Hedgehog jez2 = new Hedgehog(x-x%20,y-y%20);
		world.createOrganism(jez2);
		
	}

}
