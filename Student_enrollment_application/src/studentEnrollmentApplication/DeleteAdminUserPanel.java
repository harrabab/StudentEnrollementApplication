package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Business.Credential;
import data.CredentialDAO;
import data.DaoFactory;



public class DeleteAdminUserPanel extends JPanel{

	private JLabel lblAdminName;
	private JLabel lblPasswordName;
    private JButton btnDeleteAdmin;
	private JButton btnUpdateAdmin;
    private JTextField textAdminUser;
    private JTextField textAdminPass;
	private CredentialDAO pDao = DaoFactory.getTestDAO();
	
	
private void intialize() {
		
	    lblAdminName = new JLabel("Admin Name");
	    lblPasswordName = new JLabel("Admin Password");
	    btnDeleteAdmin = new JButton("Delete Admin User");
	    btnDeleteAdmin.setMnemonic(KeyEvent.VK_D);
	    
	    btnUpdateAdmin = new JButton("Update Password");
	    btnUpdateAdmin.setMnemonic(KeyEvent.VK_U);
	    
	   
	    
	    textAdminUser = new JTextField();
	    textAdminPass = new JPasswordField();
	 
		
		
	
		
		this.setLayout(new GridLayout(3,2));
		this.add(lblAdminName);
		this.add(textAdminUser);
		this.add(lblPasswordName);
		this.add(textAdminPass);
		this.add(btnDeleteAdmin);
		this.add(btnUpdateAdmin);
		
	}


private class UpdateAdminHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
	
		
		if(isValidDatapass()) {
			ArrayList<Credential> oldcred = new ArrayList<Credential>();
			ArrayList<Credential> newcred = new ArrayList<Credential>();
			oldcred =	pDao.getCredentials();
			int flag =0;
			
			String updatename = (String) textAdminUser.getText();
			String updatepass = (String) textAdminPass.getText();

			for (Credential credential : oldcred) {
				if(!(updatename.equals(credential.getName()))) {
					
					newcred.add(credential);
					
				}
				
				else {
					
					credential.setPassword(updatepass);
					newcred.add(credential);
					flag++;
				}
				
			}
			pDao.saveCredential(newcred);
			if(flag ==1) {
				JOptionPane.showMessageDialog(null, "Admin user  is Updated Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);	
	         

			}
			if(flag ==0) {
				
				JOptionPane.showMessageDialog(null, "User donot exist","Error Message", JOptionPane.INFORMATION_MESSAGE);	
				
			}
		            
			
			}
			
		
		}
		
	
		}
public DeleteAdminUserPanel() {
	
	this.intialize();
	btnDeleteAdmin.addActionListener(new DeleteAdminHandler());
	btnUpdateAdmin.addActionListener(new UpdateAdminHandler());
}

public boolean isValidDatapass() {
	

	if(!Validator.isPresent(textAdminUser, "Admin User")) return false;
	if(!Validator.isPresent(textAdminPass, "Admin Password")) return false;
	return true;



}

public boolean isValidData() {
	

	if(!Validator.isPresent(textAdminUser, "Admin User")) return false;
	return true;



}
private class DeleteAdminHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
	
		
		if(isValidData()) {
			ArrayList<Credential> oldcred = new ArrayList<Credential>();
			ArrayList<Credential> newcred = new ArrayList<Credential>();
			oldcred =	pDao.getCredentials();
			int flag =0;
		
			String deletename = (String) textAdminUser.getText();

			for (Credential credential : oldcred) {
				if(!(deletename.equals(credential.getName()))) {
					
					newcred.add(credential);
					
				}
				
				else {
					
					flag++;
				}
				
			}
			pDao.saveCredential(newcred);
			if(flag ==1) {
				JOptionPane.showMessageDialog(null, "Admin user  is Deleted Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);	
	         

			}
			if(flag ==0) {
				
				JOptionPane.showMessageDialog(null, "User donot exist","Error Message", JOptionPane.INFORMATION_MESSAGE);	
				
			}
		            
			
			}
			
		
		}
		
	
		}
		

}
