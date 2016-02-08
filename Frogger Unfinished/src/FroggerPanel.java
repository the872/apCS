import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FroggerPanel extends JPanel implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frogger frogger; //the protagonist in our watery ballad
	private ArrayList<Frogger> savedFrogs = new ArrayList<Frogger>();


	private Timer timer;
	private int lives; //lives the Frog has left
	private int timeLeft; //amount of time the Frog has to get to a goal
	private int score = 0;
	private boolean paused = false;
	private boolean menu = true; 
	private boolean instructions = false;
	private boolean charChoice = true;
	private boolean highScores = false;

	private int level = 1;

	private static Image frogster = ImageLoader.loadImage("frogster.png");

	private static int frogColor = 1; 

	private static Image green = ImageLoader.loadImage("frog.png");
	private static Image blue = ImageLoader.loadImage("bluefrog.png");
	private static Image red = ImageLoader.loadImage("redfrog.png");


	//how other classes can access methods of the one FroggerPanel instance the program uses
	//Use: FroggerPanel.sharedInstance.method();
	public static final FroggerPanel sharedInstance = new FroggerPanel();

	public ArrayList<FroggerObject> obstacles = new ArrayList<FroggerObject>();



	private FroggerPanel() 
	{
		addKeyListener(this);
		timer = new Timer(50, this);
		frogger = new Frogger(new Rectangle(320,600,40,40));
	}

	//sets up a brand new game
	public void initGame()
	{		

		//score = 0;
		timer.stop();
		obstacles = new ArrayList<FroggerObject>();
		savedFrogs = new ArrayList<Frogger>();



		timeLeft = 540;	

		obstacles.add(new Grass(new Rectangle(0,520,640,120), 0));
		obstacles.add(new Grass(new Rectangle(0,240,640,120), 0));

		obstacles.add(new Water(new Rectangle(0,0,640,240), 0));

		obstacles.add(new Road(new Rectangle(0, 360,640, 80), 0));
		obstacles.add(new Road(new Rectangle(0, 440,640, 80), 0));


		obstacles.add(new Truck(new Rectangle((getWidth()/4)*3, 400, 120, 50), level));
		obstacles.add(new Truck(new Rectangle(((getWidth()/4))*2, 400, 120, 50), level));
		obstacles.add(new Truck(new Rectangle(((getWidth()/4))-80, 400, 120, 50), level));
		obstacles.add(new Truck(new Rectangle(getWidth()+80, 400, 120, 50), level));

		obstacles.add(new Truck(new Rectangle(((((getWidth()-120)/4)*3))+100, 435, 120, 50), -level));
		obstacles.add(new Truck(new Rectangle((((getWidth()-120)/4)*2)+50, 435, 120, 50), -level));
		obstacles.add(new Truck(new Rectangle(((getWidth()-120)/4)-75, 435, 120, 50), -level));
		obstacles.add(new Truck(new Rectangle(((getWidth()-120))+175, 435, 120, 50), -level));


		obstacles.add(new Car(new Rectangle(((getWidth()-50)/3)-50, 362, 60, 30), -level-1));
		obstacles.add(new Car(new Rectangle((((getWidth()-50)/3)*2), 362, 60, 30), -level-1));
		obstacles.add(new Car(new Rectangle((getWidth()-50) + 50, 362, 60, 30), -level-1));

		obstacles.add(new Car(new Rectangle((getWidth()/4)+50, 487, 60, 30), level+1));
		obstacles.add(new Car(new Rectangle(((getWidth()/4)*2)+50, 487, 60, 30), level+1));
		obstacles.add(new Car(new Rectangle(((getWidth()/4)*3)+50, 487, 60, 30), level+1));
		obstacles.add(new Car(new Rectangle(0, 487, 60, 30), level+1));


		obstacles.add(new LilyPad(new Rectangle((getWidth()/15)*1, 0, 40, 40), 0));
		obstacles.add(new LilyPad(new Rectangle((getWidth()/15)*4, 0, 40, 40), 0));
		obstacles.add(new LilyPad(new Rectangle((getWidth()/15)*7, 0, 40, 40), 0));
		obstacles.add(new LilyPad(new Rectangle((getWidth()/15)*10, 0, 40, 40), 0));
		obstacles.add(new LilyPad(new Rectangle((getWidth()/15)*13, 0, 40, 40), 0));

		obstacles.add(new Log(new Rectangle((getWidth()/4)-40, 200, 80, 40), 3));
		obstacles.add(new Log(new Rectangle(((getWidth()/4)*2)+20, 200, 80, 40), 3));
		obstacles.add(new Log(new Rectangle(((getWidth()/4)*3)+60, 200, 80, 40), 3));
		obstacles.add(new Log(new Rectangle(0, 200, 80, 40), 3));

		obstacles.add(new Log(new Rectangle((getWidth()/3), 120, 120, 40), 3));
		obstacles.add(new Log(new Rectangle((getWidth()/3)*2, 120, 120, 40), 3));
		obstacles.add(new Log(new Rectangle(0, 120, 120, 40), 3));

		obstacles.add(new Log(new Rectangle((getWidth()/3), 40, 120, 40), 4));
		obstacles.add(new Log(new Rectangle((getWidth()/3)*2, 40, 120, 40), 4));
		obstacles.add(new Log(new Rectangle(0, 40, 120, 40), 4));


		obstacles.add(new Turtle(new Rectangle(getWidth(), 160, 50, 40), -2));
		obstacles.add(new Turtle(new Rectangle(getWidth()+50, 160, 50, 40), -2));
		obstacles.add(new Turtle(new Rectangle(getWidth()+200, 160, 50, 40), -2));
		obstacles.add(new Turtle(new Rectangle(getWidth()+400, 160, 50, 40), -2));

		obstacles.add(new Turtle(new Rectangle(getWidth(), 80, 50, 40), -3));
		obstacles.add(new Turtle(new Rectangle(getWidth()-320, 80, 50, 40), -3));

		timer.start();
		lives = 3; 
	}

	//called every 50 milliseconds to update all the Objects in the game
	public void actionPerformed(ActionEvent e)
	{
		update();
		if (paused)
			repaint();
	}

	//updates all the Objects in the game
	public void update()
	{	

		if(paused == false){
			if(timeLeft > 0){
				for (FroggerObject obs : obstacles)
				{
					obs.update(frogger);
					obs.handleWrapping(getWidth());
				}
				if(frogger.couldDrown() == true)
				{         
					FroggerPanel.sharedInstance.died();
				}


				frogger.update();
				frogger.keepOnScreen(getWidth(), getHeight()-40);

				timeLeft --;
				repaint();

			}
			else 
			{
				FroggerPanel.sharedInstance.died();
			}
		}
	}
	
	private HighScore Highscore = new HighScore();

	//draws all the Objects in the game
	public void paint(Graphics g)
	{
		for (FroggerObject obs : obstacles)
			obs.draw(g);

		for (Frogger sav : savedFrogs)
			sav.draw(g);

		if(timeLeft < 540/4)
		{
			if(timeLeft % 4 == 0)
			{
				g.setColor(new Color(255,0,0,100));
				g.fillRect(0, 0, getWidth(), getHeight()-40);
			}
		}

		g.setColor(Color.BLACK);
		g.fillRect(0, getHeight()-40, 640, 40);
		g.setColor(Color.green);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Lives: " + lives, 10, getHeight()-12);
		g.drawString("Level " + level, 225, getHeight()-12);


		if(timeLeft < 540/4){
			g.setColor(Color.red);
			g.fillRoundRect((getWidth()-(timeLeft/4))-25,getHeight()-30, timeLeft, 20,10,10);
			frogger.draw(g);
		}
		else if(timeLeft < 540/2){
			g.setColor(Color.orange);
			g.fillRoundRect((getWidth()-(timeLeft/4))-25,getHeight()-30, timeLeft, 20,10,10);
			frogger.draw(g);
		}
		else if(timeLeft > 540/2){
			g.setColor(Color.green);
			g.fillRoundRect((getWidth()-(timeLeft/4))-25,getHeight()-30, timeLeft, 20,10,10);
			frogger.draw(g);
		}

		g.setColor(Color.green);
		g.drawString("Time Remaining:", (getWidth()-325) ,getHeight()-12);

		g.drawString("Score: " + score, 100, getHeight()-12);

		((Graphics2D) g).setStroke(new BasicStroke(4));
		g.drawLine(0, getHeight()-40, getWidth(), getHeight()-40 );

		frogger.draw(g);

		if(charChoice == true)
		{
			timer.stop();
			g.setColor(new Color(100,100,100,100));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.green);
			g.fillRoundRect(100, 250, getWidth()-200, getHeight()-400,15,15);
			g.setColor(Color.black);
			g.drawRoundRect(100, 250, getWidth()-200, getHeight()-400,15,15);
			g.setColor(Color.white);
			g.fillRoundRect(172, 420, 300, 50, 10, 10);
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Choose your player!", 175, 290);
			g.drawLine(175, 295, 461, 295);
			g.drawString("Press 'Enter' to start", 175, 455);
			g.drawRoundRect(172, 420, 300, 50, 10, 10);
			g.setColor(Color.white);
			g.fillRoundRect(195, 320, 50, 70, 5, 5);
			g.fillRoundRect(295, 320, 50, 70, 5, 5);
			g.fillRoundRect(395, 320, 50, 70, 5, 5);

			g.setColor(Color.black);

			g.drawString("1",212,350);
			g.drawString("2",312,350);
			g.drawString("3",412,350);

			g.drawImage(green, 200, 350, 40, 40, null); 
			g.drawImage(blue, 300, 350, 40, 40, null); 
			g.drawImage(red, 400, 350, 40, 40, null); 


			if(frogColor == 1)
			{
				g.setColor(new Color(0, 255, 0, 100));
				g.fillRoundRect(195, 320, 50, 70, 5, 5);
				//i was too lazy to delete 
				//g.fillRoundRect(172, 420, 300, 50, 10, 10);

			}
			if(frogColor == 2)
			{
				g.setColor(new Color(0, 0, 255, 100));
				g.fillRoundRect(295, 320, 50, 70, 5, 5);
				//g.fillRoundRect(172, 420, 300, 50, 10, 10);
			}
			if(frogColor == 3)
			{
				g.setColor(new Color(255, 0, 0, 100));
				g.fillRoundRect(395, 320, 50, 70, 5, 5);
				//g.fillRoundRect(172, 420, 300, 50, 10, 10);
			}
			
			g.setColor(Color.black);
			g.drawRoundRect(195, 320, 50, 70, 5, 5);
			g.drawRoundRect(295, 320, 50, 70, 5, 5);
			g.drawRoundRect(395, 320, 50, 70, 5, 5);
			
			repaint();
		}

		if(paused == true)
		{
			g.setColor(new Color(148,148,148,150));
			g.fillRect(0, 0, getWidth(), getHeight()-40);
			g.setColor(Color.white);
			g.fillRoundRect((getWidth()/2)-110, (getHeight()/2)-32, 240, 50,10,10);
			g.setColor(Color.orange);
			((Graphics2D) g).setStroke(new BasicStroke(4));
			g.drawRoundRect((getWidth()/2)-110, (getHeight()/2)-32, 240, 50,10,10);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Press 'P' to continue.", (getWidth()/2)-90, getHeight()/2 );
		}

		if(menu == true)
		{
			timer.stop();
			g.setColor(Color.green);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(Color.white);
			((Graphics2D) g).setStroke(new BasicStroke(4));
			g.fillRoundRect(115, 100, 385, 150, 20, 20);
			g.setColor(Color.black);
			((Graphics2D) g).setStroke(new BasicStroke(4));
			g.drawRoundRect(115, 100, 385, 150, 20, 20);
			g.setColor(Color.black);
			g.setFont(new Font("IMPACT", Font.BOLD, 50));
			g.setColor(new Color(0,100,0));
			g.drawString("FR   GGER", 210, 160);
			g.drawImage(green,260,120,40,40, null);
			g.setColor(Color.white);
			g.fillRoundRect(145, 535, 325, 50, 10, 10);
			g.setColor(Color.black);
			g.drawRoundRect(145, 535, 325, 50, 10, 10);
			g.setFont(new Font("IMPACT", Font.PLAIN, 40));
			g.setColor(new Color(0,100,0));
			g.drawString("Press enter to play!", 150, 575);
			g.setColor(Color.black);
			g.setFont(new Font("IMPACT", Font.PLAIN, 25));
			g.setColor(Color.white);
			g.fillRoundRect(30, 610, 260, 40, 10,10);
			g.fillRoundRect(352, 610, 260, 40, 10, 10);
			g.setColor(new Color(0,100,0));
			g.drawString("Press 'i' for instructions.", 36, 640);
			g.drawString("Press 'h' for highscores.", 358, 640);
			g.setColor(Color.black);
			g.drawRoundRect(30, 610, 260, 40, 10,10);
			g.drawRoundRect(352, 610, 260, 40, 10, 10);
			g.setFont(new Font("ARIAL", Font.BOLD, 30));
			g.drawString("Designed By: Aid Idrizovic", 120, 215);


			//how to measure word length 
			//Rectangle2D strRect = g.getFontMetrics().getStringBounds("hi mom", g);
			//int wid = (int)strRect.getWidth();

			g.drawImage(frogster, 200, 300,200,200,null);	
		}

		if(highScores == true && menu == true)
		{
			
			g.setColor(Color.white);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(new Color(0,200,0,100));
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(Color.green);
			g.fillRoundRect(160, 18, 307, 57, 10,10);
			g.setColor(new Color(0,100,0));
			g.drawRoundRect(160, 18, 307, 57, 10,10);
			g.setFont(new Font("ARIAL", Font.BOLD, 50));
			g.setColor(Color.white);
			g.drawString("Highscores!", 170, 60);
			g.setColor(Color.black);
			((Graphics2D) g).setStroke(new BasicStroke(4));
			g.setFont(new Font("ARIAL", Font.BOLD, 12));
			Highscore.draw(g, getWidth(), getHeight());
			g.setFont(new Font("ARIAL", Font.BOLD, 50));
			/**
			g.drawString("1.", 50, 160);
			g.drawString("2.", 50, 210);
			g.drawString("3.", 50, 260);
			g.drawString("4.", 50, 310);
			g.drawString("5.", 50, 360);
			g.drawString("6.", 50, 410);
			g.drawString("7.", 50, 460);
			g.drawString("8.", 50, 510);
			g.drawString("9.", 50, 560);
			g.drawString("10.", 33, 610);
			**/
			g.setFont(new Font("ARIAL", Font.BOLD, 20));
			g.setColor(Color.green);
			g.fillRoundRect(getWidth()-450, getHeight()-42, 255, 30, 10, 10);
			g.setColor(new Color(0,100,0));
			g.drawRoundRect(getWidth()-450, getHeight()-42, 255, 30, 10, 10);
			g.setColor(Color.white);
			g.drawString("Press 'ESC' to go back", getWidth()-430, getHeight()-20);
		}

		if(instructions == true && menu == true)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(Color.green);
			g.fillRoundRect(160, 18, 305, 50, 10,10);
			g.setColor(new Color(0,100,0));
			g.drawRoundRect(160, 18, 305, 50, 10,10);
			g.setFont(new Font("ARIAL", Font.BOLD, 50));
			g.setColor(Color.white);
			g.drawString("Instructions", 170, 60);
			g.setColor(Color.black);
			g.setFont(new Font("ARIAL", Font.BOLD, 35));
			g.setColor(Color.green);
			g.drawString("Gameplay:", 20, 105 );
			g.setColor(Color.black);
			g.setFont(new Font("ARIAL", Font.BOLD, 25));
			g.drawString("Use the arrow keys to move.", 20, 150);
			g.drawString("Avoid the cars, trucks and falling into the water.", 20, 200);
			g.drawString("Fill up the lily pads but with one frog on each one.", 20, 250);
			g.drawString("Press 'ESC' to restart the game.", 20, 300);
			g.setFont(new Font("ARIAL", Font.BOLD, 35));
			g.setColor(Color.green);
			g.drawString("Miscellaneous:", 20, 350);
			g.setFont(new Font("ARIAL", Font.BOLD, 25));
			g.setColor(Color.black);
			g.drawString("Press 'Alt' and 'F4' to quit.", 20, 400);
			g.drawString("Press 'P' to pause the game.", 20, 450);
			g.drawString("Try finding some of the cheat codes!", 20, 500);
			g.setColor(Color.green);
			g.setFont(new Font("ARIAL", Font.BOLD, 35));
			g.drawString("To Play:", 20, 555);
			g.setColor(Color.black);
			g.setFont(new Font("ARIAL", Font.BOLD, 25));
			g.drawString("Press 'Enter' to play.", 20, 605);
			g.setFont(new Font("ARIAL", Font.BOLD, 20));
			g.setColor(Color.green);
			g.fillRoundRect(getWidth()-450, getHeight()-42, 255, 30, 10, 10);
			g.setColor(new Color(0,100,0));
			g.drawRoundRect(getWidth()-450, getHeight()-42, 255, 30, 10, 10);
			g.setColor(Color.white);
			g.drawString("Press 'ESC' to go back", getWidth()-430, getHeight()-20);
			repaint();
		}
		repaint();


	}

	//Called every time the user presses a key - should tell the Frog
	//to move in a certain direction
	public void keyPressed(KeyEvent e) {

		if(charChoice == true && menu == false)
		{
			if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
			{
				frogColor = 1;
			}
			if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
			{
				frogColor = 2;
			}
			if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
			{
				frogColor = 3;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(frogColor > 0 && frogColor < 3)
				{
					frogColor++;
				}
				else 
				{
					frogColor -=2;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(frogColor < 4 && frogColor > 1)
				{
					frogColor--;
				}
				else 
				{
					frogColor +=2;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				charChoice = false;
				timer.start();
			}

		}


		if(paused == false){
			if (e.getKeyCode() == KeyEvent.VK_P) {

				paused = true;
			}
		}
		else
		{
			if (e.getKeyCode() == KeyEvent.VK_P){
				paused = false;
			}
		}

		//cheat codes 
		/**
		if(e.getKeyCode() == KeyEvent.VK_F1)
		{
			if(timeLeft < 540)
			{
				timeLeft += 40;
			}
		}
		if(lives < 10)
		{
			if(e.getKeyCode() == KeyEvent.VK_F2)
			{
				lives+=1;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_F3)
		{
			score+=100;
		}
		if(timeLeft > 40)
		{
			if(e.getKeyCode() == KeyEvent.VK_F4)
			{
				timeLeft -=40;
			}
		}
		if(lives > 0)
		{
			if(e.getKeyCode() == KeyEvent.VK_F5)
			{
				FroggerPanel.sharedInstance.died();
			}
		}
		if(score > 100)
		{
			if(e.getKeyCode() == KeyEvent.VK_F6)
			{
				score -=100;
			}
		}
		 **/




		if(menu == true && highScores == false)
		{
			if(e.getKeyCode() == KeyEvent.VK_H)
			{
				highScores = true;
			}
		}




		if(menu == false){
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				int result = JOptionPane.showConfirmDialog(this, "Restart?", "Frogger", JOptionPane.YES_NO_OPTION);

				if(JOptionPane.YES_OPTION == result)
				{
					initGame();
				}
				else if(JOptionPane.NO_OPTION == result)
				{
					System.exit(0);
				}
				menu = true;
				charChoice = true;
			}
		}


		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			menu = false;
			timer.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_I)
		{
			instructions = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			instructions = false;
			highScores = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_ALT && e.getKeyCode() == KeyEvent.VK_F4)
		{
			System.exit(0);
		}




		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
		{
			frogger.setMoveDirection(0);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
		{
			frogger.setMoveDirection(180);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		{
			frogger.setMoveDirection(270);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			frogger.setMoveDirection(90);
		}
	}

	public static Image frogColor()
	{
		if(frogColor == 1)
		{
			return green;
		}
		if(frogColor == 2)
		{
			return blue;
		}
		if(frogColor == 3)
		{
			return red;
		}
		return null;
	}
	//unused methods
	public void keyReleased(KeyEvent e) {frogger.setMoveDirection(-1);}
	public void keyTyped(KeyEvent arg0) {}

	//called when the Frog dies
	public void died() 
	{
		lives--;
		spawnFrogger();
		if(lives == 0)
		{
			gameOver();
		}
	}

	//called when the Frog reaches a goal
	public void reachedGoal() 
	{
		savedFrogs.add(frogger);

		score += timeLeft;
		
		if(level < 11){
			if(savedFrogs.size() < 5)
			{
				spawnFrogger();
			}
			else
			{
				level++;
				initGame();
				
			}
		}
		else
		{
			wonGame();
		}

	}




	//spawns a new frogger object at the bottom of the screen
	public void spawnFrogger() 
	{
		timeLeft = 540;	
		frogger = new Frogger(new Rectangle(320,600,40,40));
	}

	//called to handle the game over condition
	public void gameOver()
	{
		String high = JOptionPane.showInputDialog("Please enter your name");
		Highscore.addScore(high, score);
		int result = JOptionPane.showConfirmDialog(this, "You lost! Score: " + score + " Play again?", "=(", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == result)
		{
			initGame();
			score = 0;
			charChoice = true;
		}
		else
		{
			score = 0;
			menu =true;
		}
	}

	//called to handle the game won condition
	public void wonGame()
	{
		String high = JOptionPane.showInputDialog("Please enter your name");
		Highscore.addScore(high, score);
		int result = JOptionPane.showConfirmDialog(this, "You won! Score: " + score + " Play again?", "=D", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == result)
		{
			initGame();
			score = 0;
			charChoice = true;
		}
		else
		{
			score = 0;
			menu= true;
		}
	}

}
