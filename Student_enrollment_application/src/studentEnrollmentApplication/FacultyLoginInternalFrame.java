package studentEnrollmentApplication;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class FacultyLoginInternalFrame extends JInternalFrame {
	
private JPanel  panel;
	
	
	public FacultyLoginInternalFrame(JPanel panel) {
		
		this.panel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Faculty Login");
		this.setIconifiable(true);
		
		this.setClosable(true);
		this.setSize(250,150);
		
	}
}
