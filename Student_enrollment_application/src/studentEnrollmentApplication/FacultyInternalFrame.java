package studentEnrollmentApplication;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class FacultyInternalFrame extends JInternalFrame {
	
private JPanel  panel;
	
	
	public FacultyInternalFrame(JPanel panel) {
		
		this.panel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Faculty user");
		this.setIconifiable(true);
		
		this.setClosable(true);
		this.setSize(250,150);
		
	}

}
