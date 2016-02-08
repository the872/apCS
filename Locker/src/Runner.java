
public class Runner {


	public static void main(String[] args) {

		Locker[] hallway = new Locker[100];


		for(int i = 0; i < hallway.length; i++)
		{
			hallway[i] = new Locker(i+1);

		}

		for(int i = 0; i < hallway.length; i++)
		{
			for(int x = i; x < hallway.length; x+=i+1) //not ++
			{
				hallway[x].toggle();
			}
		}


		for(int i =0; i < hallway.length; i++)
		{
			System.out.println(hallway[i].isOpen());
		}


	}

}
