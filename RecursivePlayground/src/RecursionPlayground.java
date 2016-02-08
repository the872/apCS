import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

public class RecursionPlayground extends JPanel implements ActionListener
{
    private Image image;
    
    private JButton[] buttons = new JButton[]{
        new JButton("Nested Boxes"),
        new JButton("Sierpinski"),
        new JButton("Tree"),
        new JButton("Mystery 1"),
        new JButton("Mystery 2"),
        new JButton("Mystery 3"),
        new JButton("Mystery 4"),
        new JButton("Mystery 5"),
        new JButton("Mystery 6"),
        new JButton("Mystery 7"),
        new JButton("Mystery 8"),
        new JButton("Mystery 9"),
        new JButton("Mystery 10"),
        new JButton("Hail Stone Sequence"),
        new JButton("Clear")
    };
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Recursion Playground!");
        
        Container c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        
        RecursionPlayground panel = new RecursionPlayground(c);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setMinimumSize(new Dimension(500, 500));
        
        
        
        
        c.add(panel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
    }
    
    public RecursionPlayground(Container c)
    {
        image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        clearImage();
        Graphics g = image.getGraphics();
        
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(500, 150));
        south.setMinimumSize(new Dimension(500, 150));
        
        c.add(south, BorderLayout.SOUTH);
        for(JButton butt: buttons) {
            butt.addActionListener(this);
            south.add(butt);
        }
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
    }
    
    public void clearImage() {
        Graphics g = image.getGraphics();
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
        Graphics g = image.getGraphics();
        
        if(o == buttons[0]) {
            int num = Prompter.promptForInteger("How many boxes do you want?");
            drawNestedBoxes(g, num, 0, 0, 200, 200);
        }
        if(o == buttons[1]) {
            int n = Prompter.promptForInteger("What iteration do you want?");
            drawSierpinski(g, n, 0, 0, 500, 500);
        }
        if(o == buttons[2]) {
            recursiveTree(g, 5, 250, 500, 100, Math.PI/2);
        }
        if(o == buttons[3]) {
            int n = Prompter.promptForInteger("Enter an integer");
            int result = mystery(n);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[4]) {
            String phrase = Prompter.promptForString("Enter an phrase");
            String result = mystery2(phrase);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[5]) {
            int n = Prompter.promptForInteger("Enter an integer");
            int result = mystery3(n);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[6]) {
            int n = Prompter.promptForInteger("Enter an integer");
            int result = mystery4(n);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[7]) {
            int n = Prompter.promptForInteger("Enter an integer");
            String result = mystery5(n);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[8]) {
            String phrase = Prompter.promptForString("Enter an phrase");
            String result = mystery6(phrase);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[9]) {
            String phrase = Prompter.promptForString("Enter an phrase");
            int result = mystery7(phrase);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[10]) {
            String phrase = Prompter.promptForString("Enter an phrase");
            boolean result = mystery8(phrase);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[11]) {
            int num = Prompter.promptForInteger("Enter an integer");
            int result = mystery9(num);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[12]) {
            int num1 = Prompter.promptForInteger("Enter an integer");
            int num2 = Prompter.promptForInteger("Enter another integer");
            int result = mystery10(num1, num2);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[13]) {
            int num = Prompter.promptForInteger("Enter an integer");
            String result = hailstoneSequence(num);
            JOptionPane.showMessageDialog(null, result);
        }
        if(o == buttons[14]) {
            clearImage();
        }
        
        repaint();
    }
    
    public void drawNestedBoxes(Graphics g, int numBoxesLeft, int x, int y, int w, int h)
    {
        if(numBoxesLeft != 0)
        {
            g.setColor(Color.RED);
            g.fillRect(x, y, w, h);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, w, h);
        
            drawNestedBoxes(g, numBoxesLeft -1, x + 5, y + 5, w - 10, h - 10);
        }
    }
    
    public void drawSierpinski(Graphics g, int numItersLeft, int x, int y, int w, int h)
    {
        Polygon blackTriangle = new Polygon();
        blackTriangle.addPoint(x, y + h);
        blackTriangle.addPoint(x + w, y + h);
        blackTriangle.addPoint(x + w/2, y);
        g.setColor(new Color((int)(Math.random() *256), (int)(Math.random() *256), (int)(Math.random() *256)));
        g.fillPolygon(blackTriangle);
        
        if(numItersLeft > 0)
        {
            Polygon whiteTriangle = new Polygon();
            whiteTriangle.addPoint(x + w/4, y + h/2);
            whiteTriangle.addPoint(x + 3*w/4, y + h/2);
            whiteTriangle.addPoint(x + w/2, y + h);
            g.setColor(Color.WHITE);
            g.fillPolygon(whiteTriangle);
            
            drawSierpinski(g, numItersLeft-1, x + w/4, y, w/2, h/2);
            drawSierpinski(g, numItersLeft-1, x, y + h/2, w/2, h/2);
            drawSierpinski(g, numItersLeft-1, x + w/2, y + h/2, w/2, h/2);
        }
    }
    
    public void recursiveTree(Graphics g, int numItersLeft, int x1, int y1, int length, double angle) {
        
        g.setColor(Color.BLACK);
        
        int x2 = x1 + (int)(length*Math.cos(angle));
        int y2 = y1 - (int)(length*Math.sin(angle));
                
        g.drawLine(x1, y1, x2, y2);
        
        if(numItersLeft > 0)
        {
            recursiveTree(g, numItersLeft-1, x2, y2, 3*length/4, angle + Math.random()*Math.PI/6);
            recursiveTree(g, numItersLeft-1, x2, y2, 3*length/4, angle - Math.random()*Math.PI/6);
        }
    }
    
    public int mystery(int n)
    {
        if(n == 0 || n == 1)
            return n;
        else
            return mystery(n-1) + mystery(n-2);
    }
    
    public String mystery2(String phrase)
    {
        if(phrase.length() < 1)
            return phrase;
        else
            return mystery2(phrase.substring(1)) + phrase.substring(0, 1);
    }
    
    public int mystery3(int n)
    {
        if(n == 0)
            return 0;
        else
            return n + mystery3(n-1);
    }
    
    public int mystery4(int n)
    {
        if(n == 0)
            return 0;
        else
            return n % 10 + mystery4(n / 10);
    }
    
    public String mystery5(int num)
    {
        if(num == 0)
            return "0";
        else if(num == 1)
            return "1";
        
        return mystery5(num/2) + (num%2);
    }
    
    public String mystery6(String word)
    {
        if(word.length() == 0)
            return word;
        
        String s = word.substring(0, 1);
        if(s.equals("a"))
            return mystery6(word.substring(1));
        else
            return s + mystery6(word.substring(1));
    }
    
    public int mystery7(String word)
    {
        if(word.length() == 0)
            return 0;
        
        String s = word.substring(0, 1);
        if(s.equals("a"))
            return 1 + mystery7(word.substring(1));
        else
            return mystery7(word.substring(1));
    }
    
    public boolean mystery8(String word)
    {
        if(word.length() <= 1)
            return true;
        
        String a = word.substring(0, 1);
        String b = word.substring(word.length()-1);
        String c = word.substring(1, word.length()-1);
        
        if(a.equals(b))
            return mystery8(c);
        else
            return false;
    }
    
    public int mystery9(int x)
    {
        if (x == 0)
            return 0;
        else
            return x + mystery9(x/2) + mystery9(x/4);
    }
    
    public int mystery10(int a, int b)
    {
        if(b == 0)
            return a;
        else
            return mystery10(b, a % b);
    }
    
    public String hailstoneSequence(int n)
    {
        if(n == 1)
            return "1";
        
        if(n % 2 == 0)
            return n + " " + hailstoneSequence(n/2);
        else
            return n + " " + hailstoneSequence(3*n + 1);
    }
    
}