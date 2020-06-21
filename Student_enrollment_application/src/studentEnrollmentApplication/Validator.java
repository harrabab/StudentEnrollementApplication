package studentEnrollmentApplication;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {
	
	
	public static boolean isPresent(JTextComponent c,String title) {
		if(c.getText().length()==0)
		{
			showMessage(c,title + " is a required field.\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		if(c.getText().length()>=10)
		{
			showMessage(c,title + " should be less than or equal to 10 char .\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		
		
		
		
		return true;
	}
	
	
	public static boolean isPresentAddress(JTextComponent c,String title) {
		if(c.getText().length()==0)
		{
			showMessage(c,title + " is a required field.\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		if(c.getText().length()>=40)
		{
			showMessage(c,title + " should be less than or equal to 20 char .\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		
		
		
		
		return true;
	}
	

	public static boolean isPresentProgramName(JTextComponent c,String title) {
		if(c.getText().length()==0)
		{
			showMessage(c,title + " is a required field.\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		if(c.getText().length()>=20)
		{
			showMessage(c,title + " should be less than or equal to 20 char .\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		
		
		
		
		return true;
	}
	
	
	
	
	public static boolean isPhoneNo(JTextComponent c,String title) {
		
		
		if(c.getText().contains(" "))
		{
			showMessage(c,title + " Should be of 10 numbers.\n Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		
		return true;
	}
	
	public static boolean isUserSelected(JComboBox<String> c,String title) {
		if(c.getSelectedIndex()== 0)
		{
			showMessage(c,title + " Should select a User Name.\n Please Select a User Name.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	public static boolean isProgramIdSelected(JComboBox<String> c,String title) {
		if(c.getSelectedIndex()== 0)
		{
			showMessage(c,title + " Should select a Prgoram Id.\n Please Select a Program Id.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	public static boolean isCourseIdSelected(JComboBox<String> c,String title) {
		if(c.getSelectedIndex()== 0)
		{
			showMessage(c,title + " Should select a Course Id.\n Please Select a Course Id.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	public static boolean isStudentIdSelected(JComboBox<String> c,String title) {
		if(c.getSelectedIndex()== 0)
		{
			showMessage(c,title + " Should select a Student Id.\n Please Select a Student Id.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	public static void showMessage(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c,message,"Invalid Entry",JOptionPane.ERROR_MESSAGE);
	}
	public static void showMessage(JComboBox<String> c, String message) {
		JOptionPane.showMessageDialog(c,message,"Invalid Entry",JOptionPane.ERROR_MESSAGE);
	}
	public static boolean isInteger(JTextComponent c,String title)
	{
		try
		{
			int i=Integer.parseInt(c.getText());
			return true;
		}
		catch(NumberFormatException e)
		{
			showMessage(c,title + " must be integer.\n Please re-enter. ");
			c.requestFocusInWindow();
			return false;
		}
	}

	
}
