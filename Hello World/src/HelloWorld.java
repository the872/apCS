import javax.swing.JOptionPane;


public class HelloWorld {

	/**
	 * This is my great program! 
	 * It will print out Hello World!
	 * Isn't this exciting
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int d = (int)(Math.random()*6)+1;
			JOptionPane.showMessageDialog(null, d);
		}
	}

}
