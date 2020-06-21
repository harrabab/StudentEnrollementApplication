package studentEnrollmentApplication;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Business.*;
import data.CredentialDAO;
import data.DaoFactory;
import data.FacultyCredentialDao;
import data.FacultyCredentialDaoText;
import studentEnrollmentApplication.MainFrame;



public class FacultyPanel  extends JPanel {
	
	private JLabel lblFacultyName, lblPassword;
	private JTextField txtFacultyName, txtPassword;
	private JButton btnLogin;
    private FacultyCredentialDao pDao =  DaoFactory.getTestDA();
    FacultyCredential cc = null;
	
	private void intialize() {
		cc = new FacultyCredential();
		lblFacultyName = new JLabel("Faculty Username");
		lblPassword = new JLabel("Password");
	
		
		txtFacultyName = new JTextField();
		txtPassword = new JPasswordField();
	
		
		btnLogin = new JButton("Login");
	
		
		this.setLayout(new GridLayout(3,2));
		this.add(lblFacultyName);
		this.add(txtFacultyName);
		this.add(lblPassword);
		this.add(txtPassword);
		this.add(btnLogin);

		
	
	
		
	}
	public boolean isValidData() {
		if(!Validator.isPresent(txtFacultyName,"Faculty Name")) return false;
		if(!Validator.isPresent(txtPassword,"Faculty Password")) return false;
		return true;



	}
	public FacultyPanel() {
		
		this.intialize();
		btnLogin.addActionListener(new  LoginButtonHandler());
	
	}
	
	
	private class LoginButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			String name = txtFacultyName.getText();
			String password = txtPassword.getText();
			
			if(isValidData()) {
			
			
			cc.setUserName(name);
			cc.setPassword(password);
			
			
			FacultyCredential tes =  pDao.getCredetial(cc);
			
			
			if(tes == null) {
					JOptionPane.showMessageDialog(null, "Invalid User", "Username or Password is incorrect", JOptionPane.ERROR_MESSAGE );
			}
			
			else {
				JOptionPane.showMessageDialog(null,"Username and Password are correct", "Credential Valid", JOptionPane.INFORMATION_MESSAGE);
			
			 System.out.println(tes);		
			try {
				MainFrame.fInternalFrame.setClosed(true);
			
			}
			catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TestMain.frame.setVisible(false);
			JFrame aa =  new FacultyFrame();
			aa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aa.setVisible(true);
			
			aa.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e)
			    {
			    	TestMain.frame.setVisible(true);
			        
			    }
			});
			
			}
	
			
			
			
		
		}
		
		
	}}}


