package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class AddResultStudentPanel extends JFrame {
	private JLabel lblStudentId,lblMarksObtained,lblCourseId;
	private JTextField txtStudentId,txtMarksObtained,txtCourseId;
	private JButton btnAddStudent,btnCancel;
	
	private void intialize() {
		lblStudentId=new JLabel();
		lblStudentId.setText("Student Id");
		
		lblCourseId=new JLabel();
		lblCourseId.setText("Course Id");
		
		lblMarksObtained=new JLabel();
		lblMarksObtained.setText("Marks Obtained");
			

		txtStudentId=new JTextField();
		txtCourseId=new JTextField();
		txtMarksObtained=new JTextField();
		
		
		btnAddStudent=new JButton("Add Student");
		btnCancel=new JButton("Cancel");
		
		this.setLayout(new GridLayout(4,2));
		
		this.add(lblStudentId);
		this.add(txtStudentId);
		this.add(lblCourseId);
		this.add(txtCourseId);
		this.add(lblMarksObtained);
		this.add(txtMarksObtained);
		this.add(btnAddStudent);
		this.add(btnCancel);
	
	
	
		
	}
	
	public AddResultStudentPanel() {
		
		this.intialize();
		
	
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
