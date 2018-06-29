package world;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class World extends JFrame{
	World world;
	//JFrame window = new JFrame();
	JButton btnNowaTura = new JButton("Nowa tura!");
	//MouseSupport mouse  = new MouseSupport();
	private LinkedList<Organism> org_tab = new LinkedList<Organism>();
	private int size;
	private int worldAge;
	public World(){
		world = this;
		worldAge = 0;
		size = 400;
		//ustawienia okna
		setBounds(10,10,size+20,size+100);
		setTitle("Oliwer Lipinski 167930");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
	        int x = e.getX()-3;
	        int y = e.getY()-16;
	        x -= (x%20);
	        y -= (y%20);
	        if(freeSpace(x, y))
	        {
	        	OrganismsWindow choosing_window = new OrganismsWindow(world, x, y);
	        }
	        else
	        	System.out.println("Na tym polu nie mozna utworzyc organizmu");
			}
			
		});
		
		//ustawienia przycisku
		btnNowaTura.addActionListener(new ActionListener()	//oclick dla przycisku
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  worldAge++;
	    	  System.out.println("---Runda numer " + getWorldAge() + "---");
	    	  for (int j = 6; j >= 0; j--)	//uwzglednienie inicjatywy
	    		  for(int i=0;i<org_tab.size();i++)
	    		  {
	    			  if (org_tab.get(i).getInitiative() == j)
	    			  org_tab.get(i).action();	//wykonywanie akcji kazdego organizmu
	    		  }
	    	  for(int i=0;i<org_tab.size();i++)
    			  org_tab.get(i).increaseAge();	//podnoszenie wieku organizmów
    		  
	    	  revalidate();
	      }
	    });
		add(btnNowaTura, BorderLayout.SOUTH);	//ustawienie przycisku na dole okna
		//window.getContentPane().add(btnNowaTura, BorderLayout.SOUTH);

		revalidate();
	}
	public void createOrganism(Organism org){
        if(freeSpace(org.getPosX(), org.getPosY()))
        {
			org.setWorld(this);		//ustawienie pola swiat dla organizmu
			org_tab.add(org);		//dodanie organizmu do listy
			add(org);		//dodanie organizmu do okna
			revalidate();	//odswiezenie okna
        }
	}
	public void removeOrganism(Organism org){
		org_tab.remove(org);	//usuniecie organizmu z listy organizmow
		remove(org);		//usuniecie organizmu z okna
		revalidate();	//odsiwezenie okna
	}
	public void refresh(){		//odswiezenie okna
		revalidate();
	}
	private int getWorldAge(){
		return worldAge;
	}
	public boolean freeSpace(int posX, int posY)				//zwraca informacje czy dane pole jest puste
	{
		if (posX >= size || posX < 0 || posY < 0 || posY >= size)	//je¿eli poza plansz¹ to zwracam false
			return false;
		for (int i = 0; i < org_tab.size(); i++)
			if (org_tab.get(i).samePosition(posX, posY))
				return false;									//je¿eli jakiœ organizm tam jest to zwracam false
		return true;
	}
	public Organism whoIs(int posX, int posY)				//zwraca informacje o organizmie znajdujacym sie na danym polu
	{
		for (int i = 0; i<org_tab.size(); i++)
			if (org_tab.get(i).samePosition(posX, posY))
				return org_tab.get(i);
		return null;
	}
	public int getWorldSize(){
		return size;
	}
	
}
