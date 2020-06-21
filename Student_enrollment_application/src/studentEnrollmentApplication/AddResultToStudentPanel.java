package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class AddResultToStudentPanel extends JFrame{

	
	
	private JLabel lblProgramName;
	private JTextField txtProgram;
	private JButton btnLogin;
	
	private void intialize() {
		
		lblProgramName = new JLabel("Program Name");
		
	
		
		txtProgram = new JTextField();
	
		
		btnLogin = new JButton("Add Program");
	
		
		this.setLayout(new GridLayout(2,2));
		this.add(lblProgramName);
		this.add(txtProgram);
		this.add(btnLogin);

		
	
	
		
	}
	
	public AddResultToStudentPanel() {
		
		this.intialize();
		btnLogin.addActionListener(new  LoginButtonHandler());
	
	}
	
	
	private class LoginButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		
				
				JOptionPane.showMessageDialog(null,"Username and Password are correct", "Credential Valid", JOptionPane.INFORMATION_MESSAGE);
				try {
					MainFrame.fInternalFrame.setClosed(true);
					MainFrame.mBar.setVisible(false);
					
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new FacultyFrame().setVisible(true);
			}
			
			
			
		
		}
}
