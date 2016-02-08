import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class KingCrab extends CrabCritter {
		
		public void processActors(ArrayList<Actor> actors)
		{
			
			Grid<Actor> gr = getGrid();
			
			
			for(Actor a : actors)
			{
				
				Location aLoc = a.getLocation();
				Location ourLoc = getLocation();
				int dir = ourLoc.getAdjacentLocation(dir);
				
				
				if(gr.isValid(spot))
				{
					Actor aSpot = gr.get(spot);
					if(aSpot == null)
					{
						a.moveTo(spot);
					}
					else 
						a.removeSelfFromGrid();
				}
				else
					a.removeSelfFromGrid();
		}
	} 

}
