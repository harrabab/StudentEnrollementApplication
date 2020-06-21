package studentEnrollmentApplication;
import javax.swing.*;

import Business.Credential;
import data.CredentialDAO;
import data.DaoFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.awt.ActiveEvent.*;

public class AdminLoginPanel extends JPanel {
	
	private JLabel lblAdminName, lblPassword;
	private JTextField txtAdminName, txtPassword;
	private JButton btnLogin;
	private CredentialDAO pDao = DaoFactory.getTestDAO();
	
	private void intialize() {
	
		lblAdminName = new JLabel("Admin Username");
		lblPassword = new JLabel("Password");
	
		
		txtAdminName = new JTextField();
		txtPassword = new JPasswordField();
	
		
		btnLogin = new JButton("Login");
		btnLogin.setMnemonic(KeyEvent.VK_L);
		
		
		this.setLayout(new GridLayout(3,2));
		this.add(lblAdminName);
		this.add(txtAdminName);
		this.add(lblPassword);
		this.add(txtPassword);
		this.add(btnLogin);
		

		
	
		
		
	}
	
	public AdminLoginPanel() {
		
		this.intialize();
		btnLogin.addActionListener(new  LoginButtonHandler());
	
	}
	
	public boolean isValidData() {
		if(!Validator.isPresent(txtAdminName,"Admin Name")) return false;
		if(!Validator.isPresent(txtPassword,"Admin Password")) return false;
		return true;



	}
	
	
	private class LoginButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String name = txtAdminName.getText();
			String password = txtPassword.getText();
			
			if(isValidData()) {
			
			Credential cc = new Credential();
			cc.setName(name);
			cc.setPassword(password);
			
			
			Credential tes =  pDao.getCredetial(cc);
			
		if(tes == null) {
				JOptionPane.showMessageDialog(null, "Invalid User", "Username or Password is incorrect", JOptionPane.ERROR_MESSAGE );
		}
			else {
				JOptionPane.showMessageDialog(null,"Username and Password are correct", "Credential Valid", JOptionPane.INFORMATION_MESSAGE);
			
			 System.out.println(tes);
			
			
			
			try {
				MainFrame.pInternalFrame.setClosed(true);
			
			}
			catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TestMain.frame.setVisible(false);
			JFrame aai =  new AdminFrame();
			aai.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aai.setVisible(true);
			
			aai.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e)
			    {
			    	TestMain.frame.setVisible(true);
			        
			    }
			});
			
			}
		}

		}
		
		
	}

}


