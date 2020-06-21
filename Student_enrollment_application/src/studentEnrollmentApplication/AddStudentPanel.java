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
import java.util.Random;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
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
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

import Business.Student;
import data.DaoFactory;
import data.StudentDao;
import data.StudentDbAccess;

public class AddStudentPanel extends JPanel {

	private JLabel lblStudentName, lblPhone, lblAddress, lblProgramId, lblAge, lblGender;
	private JTextField txtStudentName, txtAddress;
	private JButton btnAddStudent;
	private JComboBox<String> comboProgramId;
	private JSpinner spinAge;
	private JRadioButton rdoMGender, rdoFGender;
	private MaskFormatter formatter;
	private JFormattedTextField inputPhone;
	private Connection c;
	private ResultSet rs;
	private StudentDao pDao = DaoFactory.getStudentDao();
	Student s = null;
	private void initialize() {
		s = new Student();

		lblStudentName = new JLabel();
		lblStudentName.setText("Student Name");

		lblPhone = new JLabel();
		lblPhone.setText("Phone number");

		lblAddress = new JLabel();
		lblAddress.setText("Address");

		lblAge = new JLabel();
		lblAge.setText("Age");

		spinAge = new JSpinner(new SpinnerNumberModel(20, 18, 40, 1));

		lblGender = new JLabel();
		lblGender.setText("Gender");

		rdoMGender = new JRadioButton("Male", true);
		rdoFGender = new JRadioButton("Female");

		lblProgramId = new JLabel();
		lblProgramId.setText("Program ID");

		txtStudentName = new JTextField();

		txtAddress = new JTextField();
		try {
			formatter = new MaskFormatter("##########");
			inputPhone = new JFormattedTextField(formatter);
		} catch (ParseException e) {
			System.err.println("Unable to add SSN");
		}

		comboProgramId = new JComboBox<String>();

		comboProgramId.addItem("Please select One of the Course");

		
		
		try {
			rs = pDao.getProgramId();
			while (rs.next()) {

				comboProgramId.addItem(rs.getString(1));

			}

		} catch (SQLException e) {
			
			 JOptionPane.showMessageDialog(null, "Program Id Dropdown not loaded properly","Error Message", JOptionPane.INFORMATION_MESSAGE);
		}



		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setMnemonic(KeyEvent.VK_A);

		this.setLayout(new GridLayout(7, 2));

		this.add(lblStudentName);
		this.add(txtStudentName);
		this.add(lblPhone);
		this.add(inputPhone);
		this.add(lblAddress);
		this.add(txtAddress);
		this.add(lblAge);
		this.add(spinAge);
		this.add(lblGender);
		JPanel rdoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rdoPanel.add(rdoMGender);
		rdoPanel.add(rdoFGender);
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdoMGender);
		genderGroup.add(rdoFGender);
		this.add(rdoPanel);
		this.add(lblProgramId);
		this.add(comboProgramId);

		this.add(btnAddStudent);

	}

	public AddStudentPanel() {
		this.initialize();
		btnAddStudent.addActionListener(new AddStudentButtonHandler());

	}

	private class AddStudentButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (isValidData()) {

				
				s.setStudentName(txtStudentName.getText());
				s.setAddress(txtAddress.getText());
				s.setAge(spinAge.getValue().toString());
				if (rdoFGender.isSelected()) {
					s.setGender("F");
				} else {
					s.setGender("M");
				}
				s.setPhoneNumber(inputPhone.getText());
				s.setProgramId(comboProgramId.getSelectedItem().toString());
				Random rand = new Random();

				int stuentid = 10000 + rand.nextInt(20000);
				String stu = Integer.toString(stuentid);
				s.setStudentId(stu);

			
				int flag;
				try {
					flag = pDao.addStudent(s);
					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Student Added Successfully with id "+stu, "Success Message",
								JOptionPane.INFORMATION_MESSAGE);
						txtAddress.setText("");
						txtStudentName.setText("");
						comboProgramId.setSelectedIndex(0);
						inputPhone.setText("");

					}

					else {

						JOptionPane.showMessageDialog(null, "Student Was Not Added Successfully", "Error Message",
								JOptionPane.INFORMATION_MESSAGE);

					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Student Was Not Added Successfully", "Error Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

			

			}

		}

		public boolean isValidData() {
			if (!Validator.isPresent(txtStudentName, "Student Name"))
				return false;
			if (!Validator.isPhoneNo(inputPhone, "Phone Number"))
				return false;
			if (!Validator.isPresentAddress(txtAddress, "Address"))
				return false;
			if (!Validator.isProgramIdSelected(comboProgramId, "Program Id"))
				return false;
			return true;
		}

	}

}
