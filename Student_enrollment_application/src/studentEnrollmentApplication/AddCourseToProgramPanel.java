
package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.Course;
import Business.Program;
import data.*;

public class AddCourseToProgramPanel extends JPanel {
	private JLabel lblProgramId;
	private JComboBox<String> comboProgramId;
	private JLabel lblCourseName, lblCourseCredit, lblCourseDescription;
	private JTextField txtCourseName, txtCourseCredit, txtCourseDescription;
	private ResultSet rs;
	Course ca = null;
	private StudentDao pDao = DaoFactory.getStudentDao();
	private CourseDao pDao1 = DaoFactory.getCourseDao();

	private JButton btnAddCoursetoprog, btnDeleteCoursetoprog, btnFindCoursetoprog, btnUpdateCoursetoprog;

	private void intialize() {
		ca = new Course();

	
		lblProgramId = new JLabel("Program Id");
		lblCourseName = new JLabel("Course Name");
		lblCourseCredit = new JLabel("Course Credit");
		lblCourseDescription = new JLabel("Course Description");

		comboProgramId = new JComboBox<String>();
		txtCourseName = new JTextField();
		txtCourseCredit = new JTextField();
		txtCourseDescription = new JTextField();

		btnAddCoursetoprog = new JButton("Add course");
		btnDeleteCoursetoprog = new JButton("Delete course");
		btnFindCoursetoprog = new JButton("Find course");
		btnUpdateCoursetoprog = new JButton("Update course");

		btnAddCoursetoprog.setMnemonic(KeyEvent.VK_C);
		comboProgramId.addItem("Please select One of the Course");

		try {
			rs = pDao.getProgramId();
			while (rs.next()) {

				comboProgramId.addItem(rs.getString(1));

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Not Able to retrieve Program Id", " Program Id",
					JOptionPane.INFORMATION_MESSAGE);
		}

		this.setLayout(new GridLayout(6, 2));

		this.add(lblCourseName);
		this.add(txtCourseName);
		this.add(lblProgramId);
		this.add(comboProgramId);

		this.add(lblCourseCredit);
		this.add(txtCourseCredit);

		this.add(lblCourseDescription);
		this.add(txtCourseDescription);

		this.add(btnAddCoursetoprog);
		this.add(btnDeleteCoursetoprog);
		this.add(btnFindCoursetoprog);
		this.add(btnUpdateCoursetoprog);

	}

	public boolean isValidData() {
		if (!Validator.isPresent(txtCourseName, "Course Name"))
			return false;
		if (!Validator.isProgramIdSelected(comboProgramId, "Program Id"))
			return false;
		if (!Validator.isInteger(txtCourseCredit, "Course Credit"))
			return false;
		if (!Validator.isPresentAddress(txtCourseDescription, "Course Description"))
			return false;

		return true;
	}

	public boolean isValidFindData() {
		if (!Validator.isPresent(txtCourseName, "Course Name"))
			return false;
		return true;
	}

	public AddCourseToProgramPanel() {

		this.intialize();
		btnAddCoursetoprog.addActionListener(new AddCourseToProgramHandler());
		btnDeleteCoursetoprog.addActionListener(new DeleteButtonHandler());
		btnFindCoursetoprog.addActionListener(new FindButtonHandler());
		btnUpdateCoursetoprog.addActionListener(new UpdateButtonHandler());

	}

	private class UpdateButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (isValidData()) {

				Course mm = new Course();
				mm.setCourseName(txtCourseName.getText());
				mm.setCourseDescription(txtCourseDescription.getText());
				mm.setCourseCredit(Integer.parseInt(txtCourseCredit.getText()));
				mm.setProgramId((comboProgramId.getSelectedItem()).toString());

				try {

					int flag = pDao1.updateCourse(mm);

					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Course Updated", "Update Course",
								JOptionPane.INFORMATION_MESSAGE);

					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "No Course Exist with this Course Name ", "Update Course",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	private class DeleteButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (isValidFindData()) {

				String name = txtCourseName.getText();

				int flag = 0;
				try {
					flag = pDao1.deleteCourse(name);
					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Course Deleted", "Delete Course",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "No Course Exist with this Course Name ?", "Delete Course",
								JOptionPane.INFORMATION_MESSAGE);

					}

					if (flag == 2) {

						JOptionPane.showMessageDialog(null,
								"Not able to delete the Course since it has students enrolled in it", "Delete Course",
								JOptionPane.INFORMATION_MESSAGE);
					}

					txtCourseCredit.setText(" ");
					txtCourseDescription.setText(" ");
					txtCourseName.setText(" ");
					comboProgramId.setSelectedIndex(0);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "No Course Exist with this Course Name ?", "Delete Course",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		}
	}

	private class FindButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (isValidFindData()) {
				String name = txtCourseName.getText();

				try {
					rs = pDao1.findCourse(name);
					if (rs.next()) {

						txtCourseDescription.setText(rs.getString(3));
						txtCourseCredit.setText(Integer.toString(rs.getInt(4)));
						comboProgramId.setSelectedItem(rs.getString(5));

					}

					else {

						txtCourseDescription.setText(" ");
						txtCourseCredit.setText(" ");
						comboProgramId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "No Course Exist with this Course Name ?", "Find Course",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Not able to fid course ?", "Find Course",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}

		}

	}

	private class AddCourseToProgramHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (isValidData()) {

				ca.setCourseCredit(Integer.parseInt(txtCourseCredit.getText()));
				ca.setCourseDescription(txtCourseDescription.getText());
				ca.setCourseName(txtCourseName.getText());
				Random rand = new Random();
				ca.setCourseId(30000 + rand.nextInt(20000));
				ca.setProgramId(comboProgramId.getSelectedItem().toString());
				int flag = 0;
				try {
					flag = pDao1.addCourse(ca);
					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Course Added to Course", "Success Message",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "Course was not able to  add to Course", "Error Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Course was not able to  add to Course", "Error Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

				

			}
		}

	}
}
