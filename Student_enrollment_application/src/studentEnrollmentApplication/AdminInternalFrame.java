package studentEnrollmentApplication;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class AdminInternalFrame extends JInternalFrame {
	
	private JPanel  panel;
	
	
	public AdminInternalFrame(JPanel panel) {
		
		this.panel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Admin User");
		this.setIconifiable(true);
		
		this.setClosable(true);
		this.setSize(500,500);
		
	}

}
