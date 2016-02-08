public class Jeroo
{
    //the position of the Jeroo on a grid
    public int xPos, yPos; //instance variable
    
    //the direction of the Jeroo: 0 is East, 90 is North, 180 is West, and 270 is South
    public int direction; //instance variable
    
    //holds the number of Jeroos that have been created
    public static int numJeroos; // class variable 
    
    //Creates a Jeroo at (0,0) and pointing East
    public Jeroo() //constructer 
    {
        xPos = 0;
        yPos = 0;
        direction = 0;
        numJeroos++;
    }
    
    //Creates a Jeroo at (x, y) and pointing East
    public Jeroo(int x, int y) //constructer 
    {
        xPos = x;
        yPos = y;
        direction = 0;
        numJeroos++;
    }
    
    //Creates a Jeroo at (x,y) and pointing in the direction indicated by dir
    public Jeroo(int x, int y, int dir) //constructer 
    {
        xPos = x;
        yPos = y;
        direction = dir;
        numJeroos++;
    }
    
    //has the Jeroo hop one spot in its direction
    public void hop() //instance method
    {
        if(direction == 0)
            xPos++;
        else if(direction == 90)
            yPos--;
        else if(direction == 180)
            xPos--;
        else
            yPos++;
    }
    
    //has the Jeroo hop twice
    public void doubleHop() //instance method
    {
        hop();
        hop();
    }
    
    public void printInfo() //instance method
    {
        System.out.println("Jeroo is at (" + xPos + ", " + yPos + ") and its direction is " + direction);
    }
    
    //Asks the Jeroo for it's x-coordinate
    public int getxPosition() //instance method - GETTER
    {
        return xPos;
    }
    
    //Asks the Jeroo for it's y-coordinate
    public int getYPosition()
    {
        return yPos;
    }
    
    //Asks the Jeroo for it's current direction
    public int getDirection()
    {
        return direction;
    }
    
    //rotates the Jeroo by the given angle
    public void rotateBy(int angle) //instance method - mutator 
    {
        direction += angle;
    }
    
    //Asks the Jeroo how far it is from the origin
    public double distanceFromOrigin()
    {
        return Math.sqrt(xPos*xPos + yPos*yPos);
    }

}