public class SearchLab
{
	public static void main(String[] args)
	{
		Coordinate[] points = new Coordinate[(int)(Math.random()*10) + 10];
		for(int i = 0; i < points.length; i++)
		{
			int x = (int)(Math.random()*21) - 10;
			int y = (int)(Math.random()*21) - 10;
			points[i] = new Coordinate(x, y);
			System.out.println("Adding point (" + x + "," + y + ") at index " + i);
		}


		//Task #1 - search through the array and find the location of the point with the largest x coordinate
		//			and print out the index.  If there are two or more points with the largest x coordinate,
		//			print out the index of the first

		Coordinate latest = points[0];
		for(int i = 1; i < points.length; i++)
		{
			Coordinate current = points[i];

			if(current > points) 
			{
				totalMinutes = currentMinutes;
				latest = current;
			}
		}

		//Task #2 - search through the array and find the point that is farthest from the origin (hint: use the
		//			distance formula!)  Print out the distance.



		//If you're done early...
		//Task #3 - search through the array and find the point that is closest to the origin when using
		//			taxi cab geometry: http://jwilson.coe.uga.edu/EMT668/EMAT6680.F99/DDavis/Taxicab/taxicab.html
		//			For example, the taxi cab distance from the origin to (3, -4) would be 7.
		//			Print out the coordinates of the point with the smallest distance (in the event of a tie, 
		//			only print out the first one found)
	}
}