package world;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OrganismsWindow extends JFrame{
	public OrganismsWindow(World world, int x, int y){
		setBounds(420,110,300,150);
		setTitle("Wybierz organizm");
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton grass = new JButton("Trawa");
		grass.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Grass(x,y));
	        		repaint();
		      }
		});
		add(grass);
		
		JButton belladonna = new JButton("Wilcze jagody");
		belladonna.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Belladonna(x,y));
		      }
		});
		add(belladonna);
		
		JButton coffea = new JButton("Kawowiec");
		coffea.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Coffea(x,y));
		      }
		});
		add(coffea);
		
		JButton sheep = new JButton("Owca");
		sheep.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Sheep(x,y));
		      }
		});
		add(sheep);
		
		JButton wolf = new JButton("Wilk");
		wolf.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Wolf(x,y));
		      }
		});
		add(wolf);
		
		JButton bear = new JButton("Niedzwiedz");
		bear.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Bear(x,y));
		      }
		});
		add(bear);
		
		JButton hedgehog = new JButton("Jez");
		hedgehog.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Hedgehog(x,y));
		      }
		});
		add(hedgehog);
		
		JButton snail = new JButton("Slimak");
		snail.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e)
		      {
	        		world.createOrganism(new Snail(x,y));
		      }
		});
		add(snail);
	}
}
