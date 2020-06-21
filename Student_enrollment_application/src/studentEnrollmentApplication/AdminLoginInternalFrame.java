package studentEnrollmentApplication;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class AdminLoginInternalFrame extends JInternalFrame {
	
	private JPanel  panel;
	
	public AdminLoginInternalFrame(JPanel panel) {
		
		this.panel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Admin Login");
		this.setIconifiable(true);
		
		this.setClosable(true);
		this.setSize(250,150);
		
	}
	

}
