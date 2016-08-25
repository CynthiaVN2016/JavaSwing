package ResPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Resume 
{	
	private ResumeView view;
	private ResumeModel model;

	public Resume() {};
	
	public static void main(String[] args) 
	{
		Resume resume = new Resume();
		ResumeModel model = new ResumeModel("Cynthia Vu", "cynthia.vu@yale.edu", "(203)551-4160");
		resume.setModel(model); // resume needs model for view
		ResumeView view = new ResumeView(resume);
		view.setResume(resume);
		view.setVisible(true);
	}

	void setView(ResumeView vi)
	{
		view = vi;
	}
	
	void setModel(ResumeModel mo)
	{
		model = mo;
	}
}
