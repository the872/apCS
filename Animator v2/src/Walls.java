import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Walls 
{
	boolean isButtonPressed;
	int mx, my;

	public void mouseEntered( MouseEvent e ) {
		// called when the pointer enters the applet's rectangular area
	}
	public void mouseExited( MouseEvent e ) {
		// called when the pointer leaves the applet's rectangular area
	}
	public void mouseClicked( MouseEvent e ) {
		// called after a press and release of a mouse button
		// with no motion in between
		// (If the user presses, drags, and then releases, there will be
		// no click event generated.)
	}
	public void mousePressed( MouseEvent e ) {  // called after a button is pressed down
		isButtonPressed = true;
		// "Consume" the event so it won't be processed in the
		// default manner by the source which generated it.
		e.consume();
	}
	public void mouseReleased( MouseEvent e ) 
	{  // called after a button is released
		isButtonPressed = false;
		e.consume();
	}
	public void mouseMoved( MouseEvent e ) 
	{  // called during motion when no buttons are down
		mx = e.getX();
		my = e.getY();
		
		e.consume();
	}
	public void mouseDragged( MouseEvent e ) 
	{  // called during motion with buttons down
		mx = e.getX();
		my = e.getY();
		e.consume();
	}

	

}


