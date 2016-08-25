package ResPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ResumeModel
{
	String name; 
	String email;
	String number; 
	String[] ar_activities = {"Youth Group", "Fencing", "Tennis", "NHS"};
	String[] ar_awards = {"Harvard Book Award", "National Honor Society", "AP Scholar", "Salutatorian"};
	String[] ar_work = {"Sikosrky - Intern","Yale - CS50 Course Assistant","Yale - Short-term Research Assistant"};
	String[] ar_years = {"","9th - Freshman", "10th - Sophomore", "11th - Junior", "12th - Senior"};
	
	String[] empty = {""};
	String[] fresh_teacher = {"", "Mrs. Romano", "Mrs. Sara", "Mrs. Dritschler", "Mrs. Kyzer", "Mr. Thornbury", "Mr. DeGroate", "Ms. John"}; 
	String[] soph_teacher = {"", "Mr. Jeffery", "Mr. Nilan", "Mr. Guillet", "Mr. Pascarell", "Mr. Bella", "Ms. DiIulio"}; 
	String[] jun_teacher = {"", "Mr. Nilan", "Mr. Riley", "Mr. Ciccone", "Mrs. Francisco", "Mr. Gourdon", "Ms. Kennedy", "Mr. DeGroate"}; 
	String[] sen_teacher = {"", "Ms. Kennedy", "Ms. Trapasso", "Mrs. Graf", "Mr. Bella"};
	String[][] shortcutTeachers = {empty, fresh_teacher, soph_teacher, jun_teacher, sen_teacher};
	
	
	public ResumeModel (String na, String em, String nu) {
		name = na;
		email = em;
		number = nu;
	}
	
	/* methods to retrieve name, email, and number which is useless now
	String getName() {
		return name;
	}
	
	String getEmail() {
		return email;
	}
	
	String getNumber() {
		return number;
	}
	*/
	
	String[] getActivities() {
		return ar_activities;
	}
	
	String[] getAwards() {
		return ar_awards;
	}
	
	String[] getWork() {
		return ar_work;
	}
	
	String[] getYears() {
		return ar_years;
	}
	
	String[] getTeachers(int index) { 
		return shortcutTeachers[index];
	}
}
