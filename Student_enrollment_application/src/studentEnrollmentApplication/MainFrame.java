package studentEnrollmentApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import data.DbConnection;
public class MainFrame extends JFrame {

	public static JMenuBar mBar;
	private JMenu mFile;
	private JMenu mShow;
	private JMenuItem mItemExit;
	private JMenuItem mItemAdmin;
	private JMenuItem mItemFaculty;
	private JDesktopPane desktop;
	public static JInternalFrame pInternalFrame=new AdminLoginInternalFrame(new AdminLoginPanel());
	public static JInternalFrame fInternalFrame=new FacultyLoginInternalFrame(new FacultyPanel());
	
	
	
	public MainFrame()
	{
		this.initialize();
		this.setTitle("Student Enrollment");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void initialize()
	{
		mBar=new JMenuBar();
		
		desktop=new JDesktopPane();
		this.setContentPane(desktop);
		

		
		mShow=new JMenu("Login");
		mShow.setMnemonic(KeyEvent.VK_L);
		
		mItemAdmin=new JMenuItem("Login as Admin");
		mItemAdmin.setMnemonic(KeyEvent.VK_A);
		mItemAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		mItemAdmin.addActionListener(new AdminEventHandler());
		

		mItemFaculty=new JMenuItem("Login as Faculty ");
		mItemFaculty.setMnemonic(KeyEvent.VK_F);
		mItemFaculty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		mItemFaculty.addActionListener(new FacultyEventHandler());
		
		mFile=new JMenu("Exit");
		mFile.setMnemonic(KeyEvent.VK_E);
		
		mItemExit=new JMenuItem("Close");
		mItemExit.setMnemonic(KeyEvent.VK_X);
		mItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		mItemExit.addActionListener(new ExitEventHandler());
		
		
		
		mFile.add(mItemExit);
		mShow.add(mItemAdmin);
		mShow.add(mItemFaculty);
		
	
		mBar.add(mShow);
		mBar.add(mFile);
		this.setJMenuBar(mBar);
	}
	private class ExitEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	private class AdminEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			pInternalFrame.setVisible(true);
			MainFrame.this.desktop.add(pInternalFrame);
		}
	}
	
	private class FacultyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			fInternalFrame.setVisible(true);
			MainFrame.this.desktop.add(fInternalFrame);
		}
	}
}