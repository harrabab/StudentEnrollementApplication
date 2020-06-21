package studentEnrollmentApplication;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import data.*;

import Business.Program;

public class AddProgramPanel extends JPanel {

	private JLabel lblProgramId, lblProgramName, lblSemesters, lblYears;
	private JTextField txtProgramId, txtProgramName, txtSemesters, txtYears;
	private JButton btnAddProgram, btnFindProgram, btnUpdateProgram, btnDeleteProgram;
	private ResultSet rs;
	Program c = null;
	private ProgramDAO pDao = DaoFactory.getProgramDao();

	private void intialize() {
		c = new Program();
		lblProgramId = new JLabel("Program Id");
		lblProgramName = new JLabel("Program Name");
		lblSemesters = new JLabel("Semesters");
		lblYears = new JLabel("Years");

		txtProgramId = new JTextField();
		txtProgramName = new JTextField();
		txtSemesters = new JTextField();
		txtYears = new JTextField();

		btnAddProgram = new JButton("Add");
		btnFindProgram = new JButton("Find");
		btnUpdateProgram = new JButton("Update");
		btnDeleteProgram = new JButton("Delete");
		this.setLayout(new GridLayout(6, 2));
		this.add(lblProgramId);
		this.add(txtProgramId);
		this.add(lblProgramName);
		this.add(txtProgramName);
		this.add(lblSemesters);
		this.add(txtSemesters);
		this.add(lblYears);
		this.add(txtYears);
		this.add(btnAddProgram);
		this.add(btnFindProgram);
		this.add(btnUpdateProgram);
		this.add(btnDeleteProgram);
	}

	public AddProgramPanel() {

		this.intialize();
		btnAddProgram.addActionListener(new AddButtonHandler());
		btnFindProgram.addActionListener(new FindButtonHandler());
		btnUpdateProgram.addActionListener(new UpdateButtonhandler());
		btnDeleteProgram.addActionListener(new DeleteButtonHandler());
	}

	private class UpdateButtonhandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (isValidData()) {

				
				c.setProgramId(txtProgramId.getText());
				c.setProgramName(txtProgramName.getText());
				c.setSemesters(Integer.parseInt(txtSemesters.getText()));
				c.setYears(Integer.parseInt(txtYears.getText()));

				try {

					int flag = pDao.updateProgram(c);

					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Program Updated", "Update Program",
								JOptionPane.INFORMATION_MESSAGE);

					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "No Program Exist with this Program Id ?", "Update Program",
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

				String id = txtProgramId.getText();

				int flag=0;
				try {
					flag = pDao.deleteProgram(id);
					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Program Deleted", "Delete Program",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (flag == 2) {

						JOptionPane.showMessageDialog(null,
								"Program Cannot be  Deleted Since there are students still Enrolled", "Delete Program",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (flag == 0) {

						JOptionPane.showMessageDialog(null, "No Program Exist with this Program Id ?", "Delete Program",
								JOptionPane.INFORMATION_MESSAGE);
					}

					txtProgramId.setText(" ");
					txtProgramName.setText(" ");
					txtSemesters.setText(" ");
					txtYears.setText(" ");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Not able to delete  Program Id ?", "Delete Program",
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
				String id = txtProgramId.getText();

				try {
					rs = pDao.findProgram(id);
					if (rs.next()) {

						txtProgramName.setText(rs.getString(2));
						txtSemesters.setText(Integer.toString(rs.getInt(3)));
						txtYears.setText(Integer.toString(rs.getInt(4)));

					}

					else {

						txtSemesters.setText(" ");
						txtYears.setText(" ");
						txtProgramName.setText(" ");
						JOptionPane.showMessageDialog(null, "No Program Exist with this Program Id ?", "Find Program",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Not able to find Program ?", "Find Program",
							JOptionPane.INFORMATION_MESSAGE);
				
				}

			

					

				

				

			}

		}

	}

	private class AddButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if (isValidData()) {
				String id = txtProgramId.getText();
				String name = txtProgramName.getText();
				int sem = Integer.parseInt(txtSemesters.getText());
				int year = Integer.parseInt(txtYears.getText());

				
				c.setProgramId(id);
				c.setProgramName(name);
				c.setSemesters(sem);
				c.setYears(year);

				int flag;
				try {
					flag = pDao.addProgram(c);

					if (flag == 1) {

						JOptionPane.showMessageDialog(null, "Program is Added Successfully", "Success Message",
								JOptionPane.INFORMATION_MESSAGE);
					}

					else {

						JOptionPane.showMessageDialog(null, "Program is Not  Added ", "Error Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		}
	}

	public boolean isValidData() {
		// TODO Auto-generated method stub
		if (!Validator.isPresent(txtProgramId, "Program Id"))
			return false;
		if (!Validator.isPresentProgramName(txtProgramName, "Program Name"))
			return false;
		if (!Validator.isInteger(txtSemesters, "Semesters"))
			return false;
		if (!Validator.isInteger(txtYears, "Years"))
			return false;
		return true;
	}

	public boolean isValidFindData() {
		// TODO Auto-generated method stub
		if (!Validator.isPresent(txtProgramId, "Program Id"))
			return false;
		return true;
	}

}
