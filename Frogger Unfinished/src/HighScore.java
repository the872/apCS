import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class HighScore {

	private static LevelSave levels;

	public HighScore()
	{
		levels = new LevelSave();
		levels.loadPrefs();
	}

	public static void addScore(String name, int i)
	{
		levels.addScore(i, name);
	}

	public void draw(Graphics g, int width, int height)
	{
		((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
		g.setColor(Color.WHITE);
		g.fillRoundRect(width / 2 - 100, height / 2 - 200, 200, 400, 10, 10);
		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(4));
		g.drawRoundRect(width / 2 - 100, height / 2 - 200, 200, 400, 10, 10);

		g.drawString("Name:", width / 2 - 50, height / 2 - 175);
		//g.drawString("Scores", width / 2 - 25, height / 2 - 190);
		g.drawString("Score:", width / 2, height / 2 - 175);

		for(int i = 0; i < levels.getScores().size(); i++) {
			int x = 0;
			int score = levels.getScores().get(i);
			int place = i + 1;
			String name = levels.getNames().get(i);
			 
	
			
			g.drawString(place + "", width / 2 - 70, (height / 2 - 160) + i * 15);
			g.drawString(name, width / 2 - 50, (height / 2 - 160) + i * 15);
			g.drawString(x + "", width / 2, (height / 2 - 160) + i * 15);
		}

		for (int i = 0; i < levels.getNames().size(); i++)
		{
			g.drawString(levels.getNames().get(i), width / 2 - 50, (height / 2 - 160) + i * 15);
		}

		for (int i = 0; i < levels.getScores().size(); i++)
		{
			g.drawString(Integer.toString(levels.getScores().get(i)), width / 2, (height / 2 - 160) + i * 15);
		}

		System.out.println(levels.getNames());
		System.out.println(levels.getScores());
		((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	}

}
