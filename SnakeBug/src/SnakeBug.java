import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class SnakeBug extends Bug 
{
	private int grow;
	private ArrayList<Location>snake;

	private HighScores hS = new HighScores();


	public SnakeBug() 
	{
		grow = 4;

		snake = new ArrayList<Location>();
	}



	public void randomFlower()
	{
		Grid<Actor> gr= getGrid();
		Random randomGenerator = new Random();
		int col= randomGenerator.nextInt(gr.getNumCols()-1);
		int row= randomGenerator.nextInt (gr.getNumRows()-1);
		Location place = new Location (row,col);

		Flower flower= new Flower ();
		if(gr.isValid(place) == true)
		{
			flower.putSelfInGrid(gr, place);
		}
	}

	public void addRockBehindHead(Location loc) 
	{
		Grid<Actor> gr = getGrid();
		Rock rock = new Rock(getColor());
		rock.putSelfInGrid(gr, loc);
		snake.add(0, loc);
	}

	public void eraseTail()
	{	
		Location loc = snake.get(snake.size()-1); 
		Grid <Actor> gr = getGrid ();

		gr.remove(loc);
		snake.remove(snake.size()-1);
	}


	public void act()
	{
		ActorWorld world = new ActorWorld(new BoundedGrid(19, 19));
		SnakeBug head = new SnakeBug();

		if (canMove() == false)
		{
			//its times 100 just so you get larger scores
			JOptionPane.showMessageDialog(null, "Score: " + (snake.size()*100), "GAME OVER!", 0);
			removeSelfFromGrid();
			
			hS.storeScore(snake);
			System.exit(0);
		}

		Grid<Actor> gr = getGrid();
		Location a = getLocation();
		Location b = a.getAdjacentLocation(getDirection());
		Actor c = gr.get(b);



		if (c instanceof Flower && gr.isValid(b))
		{
			c.removeSelfFromGrid();
			randomFlower();
			grow+=3;
		}

		if (gr.isValid(b))
		{   
			moveTo(b);
			addRockBehindHead(a);
		}

		if(grow > 0)
		{
			grow --; 
		}
		else
		{
			eraseTail();
		}
	}
}






