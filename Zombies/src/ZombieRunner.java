
public class ZombieRunner {
	public static void main(String[] args) {
		
		Zombie george = new Zombie();
		Zombie romero = new Zombie();
		
		george.eatBrains(8);
		george.hoursPassed(6);
		george.growl();
		
		
		boolean result = george.willDie();
		System.out.println(result);
		
		george.eatBrains(6);
		george.hoursPassed(7);
		
		int answer = george.getNumberOfHoursUndead();
		
		result = george.willDie();
		System.out.println(result);
		
		romero.eatBrains((int)(Math.random()*8 + 3));
		int brains = romero.getNumberOfBrainsEaten();
		System.out.println(brains);
		
		
		
	}
}
