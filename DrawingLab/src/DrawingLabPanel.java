import java.awt.*;
import javax.swing.*;

public class DrawingLabPanel extends JPanel
{

	//the method that does the drawing
	public void paint(Graphics g)
	{
		//PUT YOUR CODE IN HERE!

		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w/2, h/2);
		g.drawOval(0, 0, w/2, h/2);

		g.setColor(Color.RED);
		g.fillOval(0, 0, w/2, h/2);

		g.setColor(Color.CYAN);
		g.fillRect(0, h/2, w/2, h/2);

		((Graphics2D)g).setStroke(new BasicStroke(2));
		g.setColor(Color.RED);
		g.drawLine(0,h,w/2,h/2);

		g.setColor(Color.BLUE);
		g.fillRect(w/2, 0, w/2, h/2); 

		g.setColor(new Color(250, 109, 5));
		Polygon tri= new Polygon();
		tri.addPoint(w/2, 0);
		tri.addPoint(w,0);
		tri.addPoint(3*w/4, h/2);
		g.fillPolygon(tri);

		g.setColor(new Color(106, 33, 143));
		g.fillRect(w/2, h/2, w, h);

		g.setColor(Color.YELLOW);
		g.fillArc(w/2, h/2, w/2, h/2, 90, 90);

		g.setColor(Color.GREEN);
		g.fillArc(w/2, h/2, w/2, h/2, 0, 90);





	}

}