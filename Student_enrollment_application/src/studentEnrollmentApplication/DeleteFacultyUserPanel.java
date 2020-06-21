package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Business.Credential;
import Business.FacultyCredential;
import data.CredentialDAO;
import data.DaoFactory;
import data.FacultyCredentialDao;


public class DeleteFacultyUserPanel extends JPanel{

	private JLabel lblFacultyName;
	private JLabel lblPasswordName;
    private JButton btnDeleteFaculty;
	private JButton btnUpdateFaculty;
    private JTextField textFacultyUser;
    private JTextField textFacultyPass;

	private FacultyCredentialDao pDao1 = DaoFactory.getTestDA();
	
	
	
private void intialize() {
		
	    lblFacultyName = new JLabel("Faculty Name");
	    lblPasswordName = new JLabel("Faculty Password"); 
	    btnDeleteFaculty = new JButton("Delete Faculty User");
	    btnDeleteFaculty.setMnemonic(KeyEvent.VK_D);
	    
	    btnUpdateFaculty = new JButton("Update Password");
	    btnUpdateFaculty.setMnemonic(KeyEvent.VK_U);
	    
	   
	    
	    textFacultyUser = new JTextField();
	    textFacultyPass = new JPasswordField();
	 
		
		
	
		
		this.setLayout(new GridLayout(3,2));
		this.add(lblFacultyName);
		this.add(textFacultyUser);
		this.add(lblPasswordName);
		this.add(textFacultyPass);
		this.add(btnDeleteFaculty);
		this.add(btnUpdateFaculty);
		
	}


private class UpdateFacultyHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
	
		
		if(isValidDatapass()) {
			ArrayList<FacultyCredential> oldcred = new ArrayList<FacultyCredential>();
			ArrayList<FacultyCredential> newcred = new ArrayList<FacultyCredential>();
	
			
			oldcred =	pDao1.getCredentials();	
			int flag =0;
			
			String updatename = (String) textFacultyUser.getText();
			String updatepass = (String) textFacultyPass.getText();

			for (FacultyCredential fcredential : oldcred) {
				if(!(updatename.equals(fcredential.getUserName()))) {
					
					newcred.add(fcredential);
					
				}
				
				else {
					
					fcredential.setPassword(updatepass);
					newcred.add(fcredential);
					flag++;
				}
				
			}
			
			pDao1.saveTest(newcred);
			if(flag ==1) {
				JOptionPane.showMessageDialog(null, "Faculty user  is Updated Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);	
	         

			}
			if(flag ==0) {
				
				JOptionPane.showMessageDialog(null, "Faculty user donot exist","Error Message", JOptionPane.INFORMATION_MESSAGE);	
				
			}
		            
			
			}
			
		
		}
		
	
		}
public DeleteFacultyUserPanel() {
	
	this.intialize();
	btnDeleteFaculty.addActionListener(new DeleteFacultyHandler());
	btnUpdateFaculty.addActionListener(new UpdateFacultyHandler());
}

public boolean isValidDatapass() {
	

	if(!Validator.isPresent(textFacultyUser, "Faculty User")) return false;
	if(!Validator.isPresent(textFacultyPass, "Faculty Password")) return false;
	return true;



}

public boolean isValidData() {
	

	if(!Validator.isPresent(textFacultyUser, "Faculty User")) return false;
	return true;



}
private class DeleteFacultyHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
	
		
		if(isValidData()) {
			ArrayList<FacultyCredential> oldcred = new ArrayList<FacultyCredential>();
			ArrayList<FacultyCredential> newcred = new ArrayList<FacultyCredential>();
			oldcred =	pDao1.getCredentials();
			int flag =0;
		
			String deletename = (String) textFacultyUser.getText();

			for (FacultyCredential credential : oldcred) {
				if(!(deletename.equals(credential.getUserName()))) {
					
					newcred.add(credential);
					
				}
				
				else {
					
					flag++;
				}
				
			}
			pDao1.saveTest(newcred);
			if(flag ==1) {
				JOptionPane.showMessageDialog(null, "Faculty user  is Deleted Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);	
	         

			}
			if(flag ==0) {
				
				JOptionPane.showMessageDialog(null, "Faculty donot exist","Error Message", JOptionPane.INFORMATION_MESSAGE);	
				
			}
		            
			
			}
			
		
		}
		
	
		}
		

}


