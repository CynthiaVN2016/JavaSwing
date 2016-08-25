package ResPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class CynthiaLabel extends JLabel
{ 
	public CynthiaLabel(final String string) 
	{
		super(string);
	}
	
	public void paintComponent(final Graphics g) 
	{ 
		final Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			super.paintComponent(g2d);	
	}
}

class CynthiaPanel extends JPanel 
{
	public CynthiaPanel(String header, String[] array) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		int x_axis = 5;
		int y_axis = 0;
			
		CynthiaLabel title = new CynthiaLabel("<html><h3>" + header +"</h3></html>");
		title.setSize(title.getPreferredSize());
		title.setLocation(x_axis, y_axis);
		add(title);
		y_axis += title.getSize().getHeight();
		double width = title.getSize().getWidth();
		
		for (int i = 0; i < array.length; ++i) {
			CynthiaLabel temp = new CynthiaLabel("<html><ul style='list-style-type:disc'><li><font size = 3>" + array[i] + "</font></li></ul></html>");
			temp.setSize(temp.getPreferredSize());
			if (temp.getSize().getWidth() > width)
				width = temp.getSize().getWidth();
			temp.setLocation(x_axis, y_axis);
			add(temp);
			y_axis += temp.getSize().getHeight();
		}
		setSize((int)(width + .5) + 25, y_axis);
	}
}
	

public class ResumeView extends JFrame
{
	private Resume resume;
	
	private Container content;
	private JButton getWorkExp;
	
	public ResumeView() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 800);
		
		content = getContentPane();
			content.setBackground(new Color(173, 248, 255));
			content.setLayout(null);
			
		getWorkExp = new JButton("Work Experience");
			getWorkExp.setSize(getWorkExp.getPreferredSize());
			getWorkExp.setLocation(200, 725);
			addBtnListener();			// adds an actionlistener
			content.add(getWorkExp);	
	}
	
	void setResume(Resume re)
	{
		resume = re;
		resume.setView(this);
	}
	
	void addBtnListener() 
	{
		getWorkExp.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFrame open = new JFrame("Work Experience");
	 			CynthiaPanel workExperience = new CynthiaPanel("Work Experience", model.getWork());
				open.setSize((int)workExperience.getSize().getWidth(), (int)(workExperience.getSize().getHeight()) + 40);
				open.getContentPane().add(workExperience);
				open.setVisible(true);
				open.setLocation(50, 50);
				open.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
