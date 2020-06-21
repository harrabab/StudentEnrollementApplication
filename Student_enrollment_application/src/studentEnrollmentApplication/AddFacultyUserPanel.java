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
import Business.FacultyCredential;
import data.CredentialDAO;
import data.DaoFactory;
import data.FacultyCredentialDao;


public class AddFacultyUserPanel extends JPanel {
	private JLabel lblUserName, lblPassword, lblProgramid,lblCourseId,lblLastName, lblFirstName;
	private JTextField txtUserName, txtUserPassword,txtFirstName,txtLastName;
	private JComboBox<String> comboCourseId,comboProgramId;
	private JButton btnAddAdmin;
	private FacultyCredentialDao pDao = DaoFactory.getTestDA();
	FacultyCredential  c = null;
	
	
	
private void intialize() {
	    c = new FacultyCredential();
		
	    lblUserName = new JLabel("Faculty User Name");
	    txtUserName = new JTextField();
	    
	    lblPassword = new JLabel("Password");
	    txtUserPassword =  new JPasswordField();
	 
	    lblLastName = new JLabel("Faculty Last Name");
	    txtLastName = new JTextField();
	    
	    lblFirstName = new JLabel("Faculty First Name");
	    txtFirstName = new JTextField();
	    
	    lblProgramid=  new JLabel("Program Id");
	    lblCourseId =  new JLabel("Course Id");
	    
	    comboCourseId = new JComboBox<String>();
		comboProgramId = new JComboBox<String>();
		
		
		comboCourseId.addItem("Please Select one of the Course Id");
		comboCourseId.addItem("C101");
		comboCourseId.addItem("C102");
		comboCourseId.addItem("C103");
		comboCourseId.addItem("C104");
		comboProgramId.addItem("Please select One of the Course");
		comboProgramId.addItem("ITC 101");
		comboProgramId.addItem("ITC 102");
		comboProgramId.addItem("ITC 103");
		comboProgramId.addItem("ITC 104");
		comboProgramId.addItem("ITC 105");
	    
	    
	    
	    btnAddAdmin = new JButton("Add Faculty");
	    btnAddAdmin.setMnemonic(KeyEvent.VK_F);
	
		
		this.setLayout(new GridLayout(7,2));
		this.add(lblFirstName);
		this.add(txtFirstName);
		
		this.add(lblLastName);
		this.add(txtLastName);
		
		this.add(lblProgramid);
		this.add(comboProgramId);
		this.add(lblCourseId);
		this.add(comboCourseId);
		
		this.add(lblUserName);
		this.add(txtUserName);
		
		this.add(lblPassword);
		this.add(txtUserPassword);
		
		this.add(btnAddAdmin);
		
	}

public AddFacultyUserPanel() {
	
	this.intialize();
	btnAddAdmin.addActionListener(new AddAdminHandler());

}

private class AddAdminHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
		if(isValidData()) {
			
			String username = txtUserName.getText();
			String password = txtUserPassword.getText(); 
			String firstName = txtFirstName.getText();
			String lastName = txtLastName.getText();
			String programId = comboProgramId.getSelectedItem().toString();
			String courseId = comboCourseId.getSelectedItem().toString();
			
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setProgramId(programId);
			c.setCourseId(courseId);
			c.setUserName(username);
			c.setPassword(password);
			
			
           
           
			
			
			pDao.addCredential(c);
            JOptionPane.showMessageDialog(null, "Faculty user  is Added Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);
           
		}
	
		}
		

}
public boolean isValidData() {
	if(!Validator.isPresent(txtFirstName,"Faculty First Name")) return false;
	if(!Validator.isPresent(txtLastName,"Faculty LastName")) return false;
	if(!Validator.isCourseIdSelected(comboCourseId,"")) return false;
	if(!Validator.isProgramIdSelected(comboProgramId,"")) return false;
	if(!Validator.isPresent(txtUserName,"Faculty Username")) return false;
	if(!Validator.isPresent(txtUserPassword,"Faculty Password")) return false;

	return true;



}
}
