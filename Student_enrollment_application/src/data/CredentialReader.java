package data;

import java.util.ArrayList;

import Business.Credential;


public interface CredentialReader {

	
	Credential getCredetial(Credential credential);
	ArrayList<Credential> getCredentials();
}
