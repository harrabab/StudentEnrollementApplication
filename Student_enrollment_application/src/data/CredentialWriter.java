package data;

import java.util.ArrayList;

import Business.Credential;


public interface CredentialWriter {
	
	boolean addCredential(Credential credential);
    boolean saveCredential(ArrayList<Credential> credential); 

}
