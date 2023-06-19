package MainAndSystem;

import java.util.Scanner;

import GUI.WelcomeFrame;
import HasA.Hospital;

public class HospitalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HospitalSys.readFromDoctorFile();
		HospitalSys.readFromHospitalFile();
		
		WelcomeFrame wf= new WelcomeFrame();
		wf.setVisible(true);
	}

}
