package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Business.Credential;
import data.*;



public class AddAdminUserPanel extends JPanel{
	
	private JLabel lblAdminName, lblAdminPassword;
	private JTextField txtAdminName, txtAdminPassword;
	private JButton btnAddAdmin;
	private CredentialDAO pDao = DaoFactory.getTestDAO();
	
	private Credential  c =null;
	
private void intialize() {
	    c = new Credential();
	    lblAdminName = new JLabel("Admin Name");
	    txtAdminName = new JTextField();
	    
	    lblAdminPassword = new JLabel("Admin Password");
	    txtAdminPassword =  new JPasswordField();;
	    
	    
	    btnAddAdmin = new JButton("Add Admin User");
	    btnAddAdmin.setMnemonic(KeyEvent.VK_A);
	
		
		this.setLayout(new GridLayout(3,2));
		this.add(lblAdminName);
		this.add(txtAdminName);
		this.add(lblAdminPassword);
		this.add(txtAdminPassword);
		this.add(btnAddAdmin);
		
	}

public AddAdminUserPanel() {
	
	this.intialize();
	btnAddAdmin.addActionListener(new AddAdminHandler());

}

private class AddAdminHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
		if(isValidData()) {
			
			String name = txtAdminName.getText();
			String password = txtAdminPassword.getText(); 
			
			
			
			c.setName(name);
			c.setPassword(password);
           
			
			
			pDao.addCredential(c);
            JOptionPane.showMessageDialog(null, "Admin user  is Added Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);
         
		}
	
		}
		

}
public boolean isValidData() {
	if(!Validator.isPresent(txtAdminName,"Admin Name")) return false;
	if(!Validator.isPresent(txtAdminPassword,"Admin Password")) return false;
	return true;



}
}