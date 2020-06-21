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

import Business.Credential;



public class CredentialDAOText implements CredentialDAO {
	
	private File testFile = null;
	
	

	public CredentialDAOText() {
		//super();
	  testFile = new File(CredetialConstants.FILENAME_TEXT);
	}
	
	private void checkFile() throws IOException{
		if(!testFile.exists()) {
			testFile.createNewFile();
		}
	}
	
	public boolean saveCredential(ArrayList<Credential> credential) {
		
		PrintWriter out = null;
		
		try {
			
			this.checkFile();
			out = new PrintWriter(new BufferedWriter(new FileWriter(testFile)));
			
			
			for(Credential t: credential) {
				out.print(t.getName() + FIELD_SEP);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	

	@Override
	public Credential getCredetial(Credential credential) {
		// TODO Auto-generated method stub
		ArrayList<Credential> credentials = this.getCredentials();

		for (Credential ts : credentials) {
			if (ts.getName().equalsIgnoreCase(credential.getName()) && ts.getPassword().equalsIgnoreCase(credential.getPassword())) {
				return ts;
			}
		}

		return null;
	}
	
	
	
	public Credential getTest() {
		// TODO Auto-generated method stub
		BufferedReader in =   null;
		Credential t = null;
		
		try {
			this.checkFile();
		
		in = new BufferedReader(new FileReader(testFile));
		ArrayList<Credential> tests = new ArrayList<Credential>();
		
		String line = in.readLine();
		
		while(line != null) {
			String[] columns = line.split(FIELD_SEP);
			String name = columns[0];
			String password = columns[1];
			
			
		     t = new Credential();
			t.setName(name);
			t.setPassword(password);
			
			
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
	public ArrayList<Credential> getCredentials() {
		// TODO Auto-generated method stub
		BufferedReader in = null;

		ArrayList<Credential> tests = new ArrayList<Credential>();
		ArrayList<Credential> tests2 = new ArrayList<Credential>();
		

		try {


				in = new BufferedReader(new FileReader(testFile));
			
				
				String line = in.readLine();
				
				while(line != null) {
					
					String[] columns = line.split(FIELD_SEP);
					String name = columns[0];
					String password = columns[1];
				
					
					Credential tes = new Credential();
					tes.setName(name);
					tes.setPassword(password);
					
				
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
	public boolean addCredential(Credential credential) {
		// TODO Auto-generated method stub
		
		ArrayList<Credential> credentials = this.getCredentials();
		credentials.add(credential);
		
		
		
		return this.saveCredential(credentials);
	}


}
