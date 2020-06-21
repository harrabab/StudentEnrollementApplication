package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Business.*;
import Business.FacultyCredential;

public class FacultyCredentialDaoText implements FacultyCredentialDao  {
	private File testFile = null;
	
	

	public FacultyCredentialDaoText() {
		//super();
	  testFile = new File(CredetialConstants.FILENAME_Faculty_TEXT);
	}
	
	private void checkFile() throws IOException{
		if(!testFile.exists()) {
			testFile.createNewFile();
		}
	}
	
	public boolean saveTest(ArrayList<FacultyCredential> credential) {
		
		PrintWriter out = null;
		
		try {
			
			this.checkFile();
	     	
			out = new PrintWriter(new BufferedWriter(new FileWriter(testFile)));
			
			
			for(FacultyCredential t: credential) {
				
				out.print(t.getFirstName() + FIELD_SEP);
				out.print(t.getLastName() + FIELD_SEP);
				out.print(t.getProgramId() + FIELD_SEP);
				out.print(t.getCourseId() + FIELD_SEP);
				out.print(t.getUserName() + FIELD_SEP);
				out.println(t.getPassword() + FIELD_SEP);
			
				
			}
		
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
		finally {
			this.close(out);
		}
		
		return true;
	}
	
	
	private void close(Closeable stream) {
		
		if(stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	

	@Override
	public FacultyCredential getCredetial(FacultyCredential credential) {
		
		ArrayList<FacultyCredential> credentials = this.getCredentials();

		for (FacultyCredential ts : credentials) {
			if (ts.getUserName().equalsIgnoreCase(credential.getUserName()) && ts.getPassword().equalsIgnoreCase(credential.getPassword())) {
				return ts;
			}
		}

		return null;
	}
	
	
	
	public FacultyCredential getTest() {
		
		BufferedReader in =   null;
		FacultyCredential t = null;
		
		try {
			this.checkFile();
		
		in = new BufferedReader(new FileReader(testFile));
		ArrayList<FacultyCredential> tests = new ArrayList<FacultyCredential>();
		
		String line = in.readLine();
		
		while(line != null) {
			String[] columns = line.split(FIELD_SEP);
			String FirstName = columns[0];
			String LastName = columns[1];
			String ProgramId = columns[2];
			String CourseId = columns[3];
			String username = columns[4];
			String Password = columns[5];
			
			
			
		    t = new FacultyCredential();
		    t.setFirstName(FirstName);
		    t.setLastName(LastName);
		    t.setProgramId(ProgramId);
			t.setCourseId(CourseId);
			t.setUserName(username);
			t.setPassword(Password);
			
			
			tests.add(t);
			
			line = in.readLine();
					
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}
	
	
	
	
	

	@Override
	public ArrayList<FacultyCredential> getCredentials() {
		
		BufferedReader in = null;

		ArrayList<FacultyCredential> tests = new ArrayList<FacultyCredential>();
		ArrayList<FacultyCredential> tests2 = new ArrayList<FacultyCredential>();
		

		try {


				
				in = new BufferedReader(new FileReader(testFile));
				
				
				String line = in.readLine();
				
				while(line != null) {
					
					String[] columns = line.split(FIELD_SEP);
					String FirstName = columns[0];
					String LastName = columns[1];
					String ProgramId = columns[2];
					String CourseId = columns[3];
					String username = columns[4];
					String Password = columns[5];
				
					
					FacultyCredential tes = new FacultyCredential();
					tes.setFirstName(FirstName);
					tes.setLastName(LastName);
					tes.setProgramId(ProgramId);
					tes.setCourseId(CourseId);
					tes.setUserName(username);
					tes.setPassword(Password);
						
					
				
					tests2.add(tes);
					
					line = in.readLine();
					
					
				}
				
				
			

		} catch (FileNotFoundException e) {

			System.out.println("File was not found ------");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

			System.out.println("File was not found ------");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tests2;
	}

	@Override
	public boolean addCredential(FacultyCredential credential) {
		
		ArrayList<FacultyCredential> credentials = this.getCredentials();
		credentials.add(credential);
		
		
		
		return this.saveTest(credentials);
	}



}
