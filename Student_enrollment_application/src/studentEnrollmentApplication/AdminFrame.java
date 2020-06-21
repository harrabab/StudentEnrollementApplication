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




public class AdminFrame extends JFrame{

	
private JPanel  panel;
	
public static JMenuBar mBar;
private JMenu mAdmin;
private JMenuItem mAddStudent;
private JMenuItem mModifyStudent;
private JMenuItem mAddProgram;
private JMenuItem mAddcourseToProgram;
private JMenuItem mViewResult;
private JMenuItem mAddAdmin;
private JMenuItem mAddFaculty;
private JMenuItem mDeleteAdmin;
private JMenuItem mDeleteFaculty;
private JDesktopPane desktop;


public AdminFrame()
{
	this.initialize();
	this.setTitle("Admin Screen");
	this.setSize(1000,1000);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
private void initialize()
{
	mBar=new JMenuBar();
	
	desktop=new JDesktopPane();
	this.setContentPane(desktop);
	

	
	mAdmin = new JMenu("Admin");
	mAdmin.setMnemonic(KeyEvent.VK_A);
	
	mAddStudent=new JMenuItem("Add Student");
	mAddStudent.setMnemonic(KeyEvent.VK_A);
	mAddStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
	mAddStudent.addActionListener(new AddEventHandler());
	

	mModifyStudent=new JMenuItem("Modify Student");
	mModifyStudent.setMnemonic(KeyEvent.VK_M);
	mModifyStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
	mModifyStudent.addActionListener(new ModifyStudentPanelhandler());
	
	
	mAddProgram =new JMenuItem("Add or Modify Program");
	mAddProgram.setMnemonic(KeyEvent.VK_P);
	mAddProgram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	mAddProgram.addActionListener(new AddProgramHandler());
	
	mAddcourseToProgram =new JMenuItem("Add or Modify Course");
	mAddcourseToProgram.setMnemonic(KeyEvent.VK_C);
	mAddcourseToProgram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	mAddcourseToProgram.addActionListener(new AddCourseToProgramPanelhandler());
	
	mViewResult =new JMenuItem("View Result of Student");
	mViewResult.setMnemonic(KeyEvent.VK_R);
	mViewResult.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
	mViewResult.addActionListener(new ViewResultPanelhandler());
	
	mAddFaculty =new JMenuItem("Add Faculty Member");
	mAddFaculty.setMnemonic(KeyEvent.VK_F);
	mAddFaculty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
	mAddFaculty.addActionListener(new AddFacultyMemberHandler());
	
	mAddAdmin =new JMenuItem("Add Admin User");
	mAddAdmin.setMnemonic(KeyEvent.VK_U);
	mAddAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	mAddAdmin.addActionListener(new AddAdminUserHandler());
	
	mDeleteAdmin =new JMenuItem("Delete/ Update Admin User");
	mDeleteAdmin.setMnemonic(KeyEvent.VK_D);
	mDeleteAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
	mDeleteAdmin.addActionListener(new DeleteAdminMemberHandler());
	
	mDeleteFaculty =new JMenuItem("Delete/ Update Faculty User");
	mDeleteFaculty.setMnemonic(KeyEvent.VK_B);
	mDeleteFaculty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
	mDeleteFaculty.addActionListener(new DeleteFacultyMemberHandler());
	

	mAdmin.add(mAddStudent);
	mAdmin.add(mModifyStudent);
	mAdmin.add(mAddProgram);
	mAdmin.add(mAddcourseToProgram);
	mAdmin.add(mViewResult);
	mAdmin.add(mAddAdmin);
	mAdmin.add(mAddFaculty);
	mAdmin.add(mDeleteAdmin);
	mAdmin.add(mDeleteFaculty);
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
private class AddEventHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		     JInternalFrame pInternalFrame=new AdminInternalFrame(new AddStudentPanel());
			 pInternalFrame.setVisible(true);
			 AdminFrame.this.desktop.add(pInternalFrame);


		}
}


private class AddProgramHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame AddProgramFrame=new AdminSmallInternsalFrame(new AddProgramPanel());
		AddProgramFrame.setVisible(true);
	    AdminFrame.this.desktop.add(AddProgramFrame);
	}
}

private class AddCourseToProgramPanelhandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame AddcoursetoProgramFrame=new AdminSmallInternsalFrame(new AddCourseToProgramPanel());
		AddcoursetoProgramFrame.setVisible(true);
	    AdminFrame.this.desktop.add(AddcoursetoProgramFrame);
	}
}
private class ModifyStudentPanelhandler implements ActionListener
{
	
	
	public void actionPerformed(ActionEvent e)
	{
		   JInternalFrame  ModifyStudenFrame=new AdminInternalFrame(new ModifyStudentPanel());
			ModifyStudenFrame.setVisible(true);
		    AdminFrame.this.desktop.add(ModifyStudenFrame);	
	}
}
private class ViewResultPanelhandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame pInternalFrame=new AdminSmallInternsalFrame(new ViewResultPanel());
	    pInternalFrame.setVisible(true);
	    AdminFrame.this.desktop.add(pInternalFrame);
	}
}



private class AddFacultyMemberHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame AddFacultyFrame=new AdminSmallInternsalFrame(new AddFacultyUserPanel());
		AddFacultyFrame.setVisible(true);
	    AdminFrame.this.desktop.add(AddFacultyFrame);
	}
}

private class AddAdminUserHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{ JInternalFrame AddAdminFrame=new AdminSmallInternsalFrame(new AddAdminUserPanel());
	   AddAdminFrame.setVisible(true);
	    AdminFrame.this.desktop.add(AddAdminFrame);
	}
}
private class DeleteAdminMemberHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame DeleteAdminMember=new AdminSmallInternsalFrame(new DeleteAdminUserPanel());
		DeleteAdminMember.setVisible(true);
		 AdminFrame.this.desktop.add(DeleteAdminMember);
	}
}

private class DeleteFacultyMemberHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JInternalFrame DeleteFacultyMember=new AdminSmallInternsalFrame(new DeleteFacultyUserPanel());
		DeleteFacultyMember.setVisible(true);
		 AdminFrame.this.desktop.add(DeleteFacultyMember);
	}
}
	
}
