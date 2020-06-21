package data;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Business.Credential;


public class CredentialDaoBinary implements CredentialDAO  {

	
	private File testFile = null;
	
	
	public CredentialDaoBinary() {
		//super();
	  testFile = new File(CredetialConstants.FILENAME_BIN);
	}
	
	
	private void checkFile() throws IOException{
		if(!testFile.exists()) {
			testFile.createNewFile();
		}
	}
	
	
    
public boolean saveCredential(ArrayList<Credential> credentials) {
		
		DataOutputStream out = null;
		
		try {
			
			this.checkFile();
			out = new DataOutputStream(new FileOutputStream(testFile));
				
			for(Credential t: credentials) {
				out.writeUTF(t.getName());
				out.writeUTF(t.getPassword());
			
				
				
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
	

	@Override
	public ArrayList<Credential> getCredentials() {
		// TODO Auto-generated method stub
		DataInputStream in = null;

		ArrayList<Credential> credentials = new ArrayList<Credential>();

		try {

			in = new DataInputStream(new FileInputStream(testFile));

			while (in.available() > 0) {
             
				String name = in.readUTF();
				String password = in.readUTF();
				
				
				Credential t = new Credential();
				t.setName(name);
				t.setPassword(password);
				
				credentials.add(t);
				
				
				
				
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

		return credentials;
	}

	@Override
	public boolean addCredential(Credential credential) {
		// TODO Auto-generated method stub
		
		ArrayList<Credential> credentials = this.getCredentials();
		credentials.add(credential);
		
		
		
		return this.saveCredential(credentials);
	}



}
