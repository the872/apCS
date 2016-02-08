import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();

		Location loc = getLocation();

		Grid<Actor> gr = getGrid();

		Location oneLeft = loc.getAdjacentLocation(getDirection() - 90);
		Location twoLeft = oneLeft.getAdjacentLocation(getDirection() - 90);

		if (gr.isValid(twoLeft)) {
			
			Actor one = gr.get(oneLeft);
			Actor two = gr.get(twoLeft);
			
			
			if (one == null && two == null)
			{
				locs.add(twoLeft);
			}
		}
		
		Location oneRight = loc.getAdjacentLocation(getDirection() + 90);
		Location twoRight = oneRight.getAdjacentLocation(getDirection() + 90);

		if (gr.isValid(twoRight)) {
			
			Actor one = gr.get(oneRight);
			Actor two = gr.get(twoRight);
			
			
			if (one == null && two == null)
			{
				locs.add(twoRight);
			}
		}
		
		return locs;
	}

}
