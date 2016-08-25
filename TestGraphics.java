import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import java.awt.font.*;
import java.text.*;

public class TestGraphics extends JFrame
{
	private Container content;
	final BufferedImage bImage = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
	final Graphics2D graphics = bImage.createGraphics();
	
	public static void main (String[] args)
	{
		TestGraphics test = new TestGraphics();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public TestGraphics()
	{
		content = getContentPane();
		setLayout(null);
		setSize(600, 600);
		
		makeGraphics();
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage((Image)bImage, 0, 0, null); // why does it work w/ negative?
			}
		};
		panel.setBounds(100, 100, 400, 300);
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(75, 75, 75)));

		content.add(panel);
		
		setVisible(true);
	}
	
	private void makeGraphics()
	{	
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		graphics.setColor(new Color(250, 250, 250));
		graphics.fill(new RoundRectangle2D.Double(10, 10, 380, 280, 50, 50));
		
		graphics.setStroke(new BasicStroke(3));
		
		graphics.setColor(new Color(190, 255, 190));
		graphics.fillRect(100, 100, 200, 100);
			graphics.setColor(new Color(125, 255, 125)); // rectangle border
			graphics.draw(new Rectangle(100, 100, 200, 100));
		graphics.setColor(new Color(255, 190, 190));
		graphics.fillRect(125, 125, 150, 50);
			graphics.setColor(new Color(255, 125, 125));
			graphics.draw(new Rectangle(125, 125, 150, 50));
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Arial", Font.BOLD, 14)); 
		graphics.drawString("	I'm Testing Out the Graphics", 100, 75); 
		
		AttributedString string = new AttributedString("Annyeong Chingudeuls");
			string.addAttribute(TextAttribute.FONT, new Font("Arial", Font.BOLD, 14));
			string.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 0, 15);
			graphics.drawString(string.getIterator(), 200, 275);
		int dark = 0;
		Point2D top = new Point2D.Double();
		Point2D bottom = new Point2D.Double();
		int y = bImage.getHeight();
		int x = 0;
		for (int i = 1; i <= 10; ++i)
		{
			top.setLocation(x, y - (15*i));
			bottom.setLocation(x + (15*i), y);
			graphics.setColor(new Color(dark, dark, dark));
			graphics.draw(new Line2D.Double(top, bottom));

			dark += 25;
		}
		
		dark = 0;
		int forArc = 0;
		for (int i = 1; i <= 18; ++i)
		{
			graphics.setColor(new Color(dark, dark, 255));
			Arc2D arc = new Arc2D.Double();
			arc.setArc(0, 0, 100, 100, forArc, 10, Arc2D.PIE);
			graphics.fill(arc);
			
			forArc += 20;
			dark += 14;
		}
	}
	
}
