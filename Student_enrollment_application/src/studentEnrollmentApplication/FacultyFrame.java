package studentEnrollmentApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class FacultyFrame extends JFrame {
	
	private JPanel  panel;
	
	public static JMenuBar mBar;
	private JMenu mAdmin;
	private JMenuItem mAddResult;
	private JDesktopPane desktop;
	
	


	public FacultyFrame()
	{
		this.initialize();
		this.setTitle("Faculty Screen");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initialize()
	{
		mBar=new JMenuBar();
		
		desktop=new JDesktopPane();
		this.setContentPane(desktop);
		

		
		mAdmin = new JMenu("Faculty");
		mAdmin.setMnemonic(KeyEvent.VK_S);
		
		mAddResult =new JMenuItem("View And Edit Result");
		mAddResult.setMnemonic(KeyEvent.VK_R);
		mAddResult.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		mAddResult.addActionListener(new AddResultToStudenthandler());
		

		
				
		
		mAdmin.add(mAddResult);
		mBar.add(mAdmin);
		
		this.setJMenuBar(mBar);
	}
	private class ExitEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	private class AddResultToStudenthandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JInternalFrame FacultyEditResultPanel=new FacultyInternalFrame(new FacultyEditResultPanel());
			FacultyEditResultPanel.setVisible(true);
		    FacultyFrame.this.desktop.add(FacultyEditResultPanel);
			
		}
	}


	
	
	

}
