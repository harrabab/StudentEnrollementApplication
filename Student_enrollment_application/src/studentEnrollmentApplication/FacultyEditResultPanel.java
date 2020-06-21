package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.Marks;
import Business.Program;
import Business.Student;
import data.CourseDao;
import data.CourseDbAccess;
import data.CredentialDAO;
import data.DaoFactory;
import data.MarksDao;
import data.MarksDbAccess;
import data.ProgramDbAccess;
import data.StudentDao;
import data.StudentDbAccess;

public class FacultyEditResultPanel extends JPanel {
	private JLabel lblStudentName, lblCourseName, lblProgramId, lblMarksObtained, lblStudentId, lblCourseId;
	private JTextField txtStudentName, txtProgramId, txtMarksObtained, txtCourseId;
	private JComboBox<String> comboStudentId, comboCourseName;
	private JButton btnSubmitMarks, btnUpdateMarks;
	private ResultSet rs;
	Marks mm = null;
	Student ss = null;
	private CourseDao pDao1 = DaoFactory.getCourseDao();
	private MarksDao pDao2 = DaoFactory.getMarksDao();
	private StudentDao pDao = DaoFactory.getStudentDao();

	private void initialize() {
		mm = new Marks();
		ss = new Student();
		lblStudentId=new JLabel();
		lblStudentId.setText("Student Id");
		
		comboStudentId = new JComboBox<String>();
		
		comboStudentId.addItem("Please Select Student Id");

		
		   
		    try {
				rs = pDao.getStudentid();
				while (rs.next()) {              
				    
					
					comboStudentId.addItem(rs.getString(1));
				
		}
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null,"Not able to retrieve student Id","Error Message",JOptionPane.INFORMATION_MESSAGE);	
			}
		    
		
		
    	lblStudentName=new JLabel();
		lblStudentName.setText("Student Name");
		
		
		txtStudentName=new JTextField();
		
		txtCourseId=new JTextField();
		
		
		lblProgramId=new JLabel();
		lblProgramId.setText("Program Id");
		
		txtProgramId = new JTextField();
		
		lblCourseName=new JLabel();
		lblCourseName.setText("Course Name");
		
		lblCourseId=new JLabel();
		lblCourseId.setText("Course Id");
		
		comboCourseName = new JComboBox<String>();
		

			
		lblMarksObtained=new JLabel();
		lblMarksObtained.setText("Marks Obtained");
		
		btnSubmitMarks = new JButton("Submit Marks");
		btnSubmitMarks.setMnemonic(KeyEvent.VK_S);
		
		btnUpdateMarks= new JButton("Update Marks");
		btnUpdateMarks.setMnemonic(KeyEvent.VK_U);
		
		txtMarksObtained=new JTextField();
		
		this.setLayout(new GridLayout(7,2));
		
		this.add(lblStudentId);
		this.add(comboStudentId);
		this.add(lblStudentName);
		this.add(txtStudentName);
		this.add(lblProgramId);
		this.add(txtProgramId);
		
		this.add(lblCourseName);
		this.add(comboCourseName);
		
		
		this.add(lblCourseId);
		this.add(txtCourseId);
		
		
		this.add(lblMarksObtained);
		this.add(txtMarksObtained);

		this.add(btnSubmitMarks);
		this.add(btnUpdateMarks);
		
		txtStudentName.setEnabled(false);
		txtProgramId.setEnabled(false);
		comboCourseName.setEnabled(false);
		txtCourseId.setEnabled(false);
		btnSubmitMarks.setEnabled(false);
		btnUpdateMarks.setEnabled(false);
	   	comboCourseName.addItem("Please Select a Course Name");
		
		comboStudentId.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       if(!(comboStudentId.getSelectedIndex() == 0)) {
		    	   	    
   			
   				    try {
   				     rs = pDao.getStudentDetail(comboStudentId.getSelectedItem().toString());	
   						while (rs.next()) {              
   						    

   								
   									
   							
   									ss.setStudentName(rs.getString(2));
   									ss.setProgramId(rs.getString(7));
   									
   									
   									
   							  								
   						}
   						
   						
   				    

   						txtStudentName.setText(ss.getStudentName());
   						txtProgramId.setText(ss.getProgramId());
   						
   						
   						rs =pDao1.findCourseWithProgramId(ss.getProgramId());
   					    comboCourseName.setEnabled(true);
   					    int gg = comboCourseName.getItemCount();
   					   ArrayList<String> list = new ArrayList<String>();
   				    	 if(gg > 1) {
   					    for(int i = 0 ; i+1 <= gg ; i++ ) {
   					    
   					  
   					    list.add(comboCourseName.getItemAt(i+1));
   				    		
   					    }
   					 for (String st : list) { 		      
   						 comboCourseName.removeItem(st); 		
   			      }
   					
   					    

   					    }
   					       				
   						
   					 try {
    						while (rs.next()) {              
    						    

    							comboCourseName.addItem(rs.getString(2));
    									
    							
    						
    									
    									
    							  								
    						}
    						
   					 }
    						catch (SQLException e1) {
    							JOptionPane.showMessageDialog(null,"Not Able to Retrieve Course Name","Error Message",JOptionPane.INFORMATION_MESSAGE);	
    	   					}
   						
   						
   					}
      				 catch (SQLException e1) {
        					JOptionPane.showMessageDialog(null,"Not Able to Retrieve Student Id","Error Message",JOptionPane.INFORMATION_MESSAGE);	

     					}
		    	   
		    		btnSubmitMarks.setEnabled(false);
		    		btnUpdateMarks.setEnabled(false);
		    		txtCourseId.setText("");
		    		txtMarksObtained.setText("");
		    		txtMarksObtained.setEnabled(false);
		    	   
		       }
		       
		
		       
               else {
		    	   
            	   
            	    txtMarksObtained.setEnabled(false);
            	    comboCourseName.setEnabled(false);
		    		txtStudentName.setText("");
		    		txtProgramId.setText("");
		    		txtMarksObtained.setText("");
		    		comboCourseName.setSelectedIndex(0);
		    		comboCourseName.addItem("");
		    		btnSubmitMarks.setEnabled(false);
		    		btnUpdateMarks.setEnabled(false);
		    		txtCourseId.setText("");
		    		txtMarksObtained.setText("");
		    		txtMarksObtained.setEnabled(false);
		    		
		       }
		}
		});

		comboCourseName.addActionListener (new ActionListener () {

	public void actionPerformed(ActionEvent e) {
		if (!(comboCourseName.getSelectedIndex() == 0)) {

			txtMarksObtained.setEnabled(true);
			btnSubmitMarks.setEnabled(true);

			try {

				ResultSet rs = pDao1.findCourse((comboCourseName.getSelectedItem()).toString());
				while (rs.next()) {

					txtCourseId.setText(rs.getString(1));

				}

				mm.setCourseId(Integer.parseInt(txtCourseId.getText()));
				mm.setProgramId(txtProgramId.getText());
				mm.setStudentId((comboStudentId.getSelectedItem()).toString());
				ResultSet rr = pDao2.findMarks(mm);

				if (rr.next()) {

					txtMarksObtained.setText(rr.getString(1).toString());
					btnSubmitMarks.setEnabled(false);
					btnUpdateMarks.setEnabled(true);
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else {

			txtMarksObtained.setEnabled(false);
			btnUpdateMarks.setEnabled(false);
			btnSubmitMarks.setEnabled(false);
			txtCourseId.setText("");
			txtMarksObtained.setText("");

		}
	}

	});

	}

	public FacultyEditResultPanel() {
		this.initialize();
		btnSubmitMarks.addActionListener(new SubmitMarksHandler());
		btnUpdateMarks.addActionListener(new UpdateMarksHandler());
	}

	public boolean isValidData() {

		if (!Validator.isInteger(txtMarksObtained, "Marks Obtained"))
			return false;
		if (!Validator.isCourseIdSelected(comboCourseName, " "))
			return false;
		if (!Validator.isStudentIdSelected(comboStudentId, " "))
			return false;
		return true;
	}

	private class UpdateMarksHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (isValidData()) {

				mm.setProgramId(txtProgramId.getText());
				mm.setCourseId(Integer.parseInt(txtCourseId.getText()));
				mm.setMarksobtained(Integer.parseInt(txtMarksObtained.getText()));

				mm.setStudentId((comboStudentId.getSelectedItem()).toString());

				try {

					int flag = pDao2.updateMarks(mm);

					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Marks Updated", "Update Marks",
								JOptionPane.INFORMATION_MESSAGE);

					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "Not able to Update Marks ?", "Update Marks",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

	private class SubmitMarksHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (isValidData()) {

				Random rand = new Random();
				int markid = 50000 + rand.nextInt(20000);

				mm.setProgramId(txtProgramId.getText());
				mm.setCourseId(Integer.parseInt(txtCourseId.getText()));
				mm.setMarksobtained(Integer.parseInt(txtMarksObtained.getText()));

				mm.setStudentId((comboStudentId.getSelectedItem()).toString());
				mm.setMarkId(markid);

				try {

					int flag = pDao2.SubmitMarks(mm);

					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Marks Updated", "Update Marks",
								JOptionPane.INFORMATION_MESSAGE);
						btnSubmitMarks.setEnabled(false);
						btnUpdateMarks.setEnabled(true);
					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "Not able to Update Marks ?", "Update Marks",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

}
