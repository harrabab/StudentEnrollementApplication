package studentEnrollmentApplication;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import Business.Student;
import data.DaoFactory;
import data.StudentDao;
import data.StudentDbAccess;



public class ModifyStudentPanel extends JPanel {
	
	private JLabel lblStudentId,lblStudentName,lblPhone,lblAddress,lblProgramId,lblAge,lblGender;
	private JTextField txtStudentName,txtAddress;
	private JButton btnModifyStudent;
	private JComboBox<String> comboStudentId,comboProgramId;
	private JSpinner spinAge;
	private JRadioButton rdoMGender,rdoFGender;
	private MaskFormatter formatter;
	private JFormattedTextField inputPhone;
	private Connection c;
	private ResultSet rs;
	private StudentDao pDao = DaoFactory.getStudentDao();
	Student ss = null;
	
	private void initialize() {
		ss = new Student();
		lblStudentId=new JLabel();
		lblStudentId.setText("Student Id");
		
		lblStudentName=new JLabel();
		lblStudentName.setText("Student Name");
		
		lblPhone=new JLabel();
		lblPhone.setText("Phone number");
		
		lblAddress=new JLabel();
		lblAddress.setText("Address");
		
		lblProgramId=new JLabel();
		lblProgramId.setText("Program ID");
		
		lblAge=new JLabel();
		lblAge.setText("Age");
		
		spinAge =new JSpinner(new SpinnerNumberModel(20,18,40,1));
		
		lblGender=new JLabel();
		lblGender.setText("Gender");
		
		rdoMGender = new JRadioButton("Male",true);
		rdoFGender = new JRadioButton("Female");
			
		comboStudentId =new JComboBox<String>();
		txtStudentName=new JTextField();
		comboStudentId.addItem("Please select a Student Id");
		try {
			 formatter = new MaskFormatter("##########");
			 inputPhone = new JFormattedTextField(formatter);
			}
			catch (ParseException e) {
			      System.err.println("Unable to add SSN");
			    }
		txtAddress=new JTextField();
		comboProgramId=new JComboBox<String>();
		
		
		txtStudentName.setEnabled(false);
		inputPhone.setEnabled(false);
		txtAddress.setEnabled(false);
		comboProgramId.setEnabled(false);
		rdoMGender.setEnabled(false);
		rdoFGender.setEnabled(false);
		spinAge.setEnabled(false);
		
	
		
		    
		  
		    
				try {
					rs = pDao.getStudentid();
					while (rs.next()) {              
					    

								comboStudentId.addItem(rs.getString(1));
							
					
}
				} catch (SQLException e2) {
					  JOptionPane.showMessageDialog(null, "Student Id Dropdown not loaded properly","Error Message", JOptionPane.INFORMATION_MESSAGE);
					
				} 
		    
		
		
		 
			
			
			   			     
		     
				    
   			 
   				    try {
   				    	rs = pDao.getProgramId();
   						while (rs.next()) {              
   						    

   								
   									
   							
   							comboProgramId.addItem(rs.getString(1));
   								
   									
   						}
   						
   				    }			
   								
   								
   						
   						catch (SQLException e1) {
   						 JOptionPane.showMessageDialog(null, "Program Id Dropdown not loaded properly","Error Message", JOptionPane.INFORMATION_MESSAGE);
   	   					}
		

		
		
		
		btnModifyStudent=new JButton("Modify Student");
		
		btnModifyStudent.setMnemonic(KeyEvent.VK_M);
		
		
		this.setLayout(new GridLayout(8,2));
		
		this.add(lblStudentId);
		this.add(comboStudentId);
		this.add(lblStudentName);
		this.add(txtStudentName);
		this.add(lblPhone);
		this.add(inputPhone);
		this.add(lblAddress);
		this.add(txtAddress);
		this.add(lblAge);
		this.add(spinAge);
		this.add(lblGender);
		JPanel rdoPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
		rdoPanel.add(rdoMGender);
		rdoPanel.add(rdoFGender);
		this.add(rdoPanel);
        this.add(lblProgramId);
		this.add(comboProgramId);

		
		this.add(btnModifyStudent);
		btnModifyStudent.setEnabled(false);
		
		comboStudentId.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       if(!(comboStudentId.getSelectedIndex() == 0)) {
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   
		    	txtStudentName.setEnabled(true);
		    	inputPhone.setEnabled(true);
		   		txtAddress.setEnabled(true);
		   		comboProgramId.setEnabled(true);
				rdoMGender.setEnabled(true);
				rdoFGender.setEnabled(true);
				spinAge.setEnabled(true);
				btnModifyStudent.setEnabled(true);
				
				 
   			   
   			    
   			     
   			     
   				    
   			  
   				    try {
   				     rs = pDao.getStudentDetail(comboStudentId.getSelectedItem().toString());	
   	   			     
   						while (rs.next()) {              
   						    

   								
   									
   							
   									ss.setStudentName(rs.getString(2));
   									ss.setPhoneNumber(rs.getString(3));
   									ss.setAddress(rs.getString(4));
   									ss.setAge(rs.getString(5));
   									ss.setGender(rs.getString(6));
   									ss.setProgramId(rs.getString(7));
   									
   									
   									
   								
   								
   						}
   						
   						
   						
   						txtStudentName.setText(ss.getStudentName());
   						inputPhone.setText(ss.getPhoneNumber());
   						txtAddress.setText(ss.getAddress());
   						int age = Integer.parseInt(ss.getAge());
   						spinAge.setValue(age);
   						comboProgramId.setSelectedItem(ss.getProgramId());
   						
   						if(ss.getGender().equals("F")) {
   							rdoFGender.setSelected(true);
   							rdoMGender.setSelected(false);
   							
   						}
   						else {
   							rdoMGender.setSelected(true);
   							rdoFGender.setSelected(false);
   							
   						}
   						

   						
   						
   					} catch (SQLException e1) {
   					 JOptionPane.showMessageDialog(null, "Student Data on the bais of stuent id  is not loaded properly","Error Message", JOptionPane.INFORMATION_MESSAGE);
   						
   					}
		    	   

		    	   
		       }
		       
		       
               else {
		    	    txtAddress.setText("");
					txtStudentName.setText("");
					comboProgramId.setSelectedIndex(0);
					inputPhone.setText("");
					comboStudentId.setSelectedIndex(0);
            	   
            	
		    		txtStudentName.setEnabled(false);
		    		inputPhone.setEnabled(false);
		    		txtAddress.setEnabled(false);
		    		comboProgramId.setEnabled(false);
		    		rdoMGender.setEnabled(false);
		    		rdoFGender.setEnabled(false);
		    		spinAge.setEnabled(false);
		    		btnModifyStudent.setEnabled(false);
		       }
		    }
		});

	}
	public ModifyStudentPanel()
	{
		this.initialize();
		btnModifyStudent.addActionListener(new  ModifyStudentButtonHandler());
	
		
	}
	
	public boolean isValidData() {
		if(!Validator.isPresent(txtStudentName,"Student Name")) return false;
		if(!Validator.isPhoneNo(inputPhone,"Phone Number")) return false;
		if(!Validator.isPresentAddress(txtAddress,"Address")) return false;
		return true;
	}
		
		
private class ModifyStudentButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			 if(isValidData()) {
			
				    
			        
			     
			        ss.setStudentName(txtStudentName.getText());
			        
			        ss.setAddress(txtAddress.getText());
				    ss.setAge(spinAge.getValue().toString());
				    if(rdoFGender.isSelected()) {
				    	 ss.setGender("F");
				    }
				    else {
				    	 ss.setGender("M");
				    }
				   ss.setPhoneNumber(inputPhone.getText());
				   ss.setProgramId(comboProgramId.getSelectedItem().toString());
			       ss.setStudentId(comboStudentId.getSelectedItem().toString());
			   

				   
				   
			     
	
	
			       int flag;
				try {
					flag = pDao.ModifyStudentDetail(ss);
					 if(flag == 1) {
				    	   JOptionPane.showMessageDialog(null, "Student Details Modified Successfully","Success Message", JOptionPane.INFORMATION_MESSAGE);
				    	    txtAddress.setText("");
							txtStudentName.setText("");
							comboProgramId.setSelectedIndex(0);
							inputPhone.setText("");
							comboStudentId.setSelectedIndex(0);
							
				    	   
				       }
				       else {
				    	   
				    	   JOptionPane.showMessageDialog(null, "Student Details are not  Modified Successfully","Error Message", JOptionPane.INFORMATION_MESSAGE);   
				    	   
				       }
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(null, "Student Details are not  Modified Successfully","Error Message", JOptionPane.INFORMATION_MESSAGE);
				}  
			     
			      
			       
			       
			   
				    
				
				
				}

		}
		
		
	}
}
