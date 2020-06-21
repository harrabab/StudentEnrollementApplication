package data;

import java.util.ArrayList;

import Business.*;;

public interface FacutyCredentialWriter {
	
	
	boolean addCredential(FacultyCredential credential);
	boolean saveTest(ArrayList<FacultyCredential> credential); 

}
