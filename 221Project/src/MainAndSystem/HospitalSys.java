package MainAndSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import HasA.Hospital;
import HasA.Records;
import Inheritance.Doctors;
import Inheritance.Patients;

public class HospitalSys {

	private static Hospital[] hospitals = new Hospital[3];
	private static HashSet<Doctors> doctorSet = new HashSet<>();
	private static HashSet<Patients> patientSet = new HashSet<>();

	public static boolean readFromHospitalFile() {

		File file = new File("hospital.txt");
		Scanner sc;

		try {
			sc = new Scanner(file);
			int i = 0;
			while (sc.hasNext()) {
				String city = sc.next();
				String phoneNumber = sc.next();
				String mailAddress = sc.next();

				Hospital hsp = new Hospital(city, phoneNumber, mailAddress);
				hospitals[i] = hsp;
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		sc.close();
		return true;
	}

	public static boolean checkPatientId(int id) {
		for (Patients p : patientSet) {
			if (p.getPatientId() == id) {
				return false;
			}
		}
		return true;
	}

	public static boolean addPatient(String name, String surname, int patientId, int age, String gender,
			String titleOfDoctor) {
		if (checkPatientId(patientId)) {
			Patients p = new Patients(name, surname, patientId, age, gender, titleOfDoctor);
			return patientSet.add(p);
		} else {
			return false;
		}

	}

	public static boolean addRecord(String medicalImage, String branch, int patId, String date) {
		Records r = new Records( medicalImage, branch, date);

		Patients p = searchPatient(patId);
		p.getRecords().add(r);
		return true;
	}

	public static boolean readFromDoctorFile() {

		File file = new File("doctors.txt");
		Scanner sc;

		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String name = sc.next();
				String surname = sc.next();
				String graduatedSchool = sc.next();
				String titleOfDoctor = sc.next();
				String hireDate = sc.next();
				String assistantName = sc.next();
				String branch = sc.next();
				String city = sc.next();
				Doctors d = new Doctors(name, surname, graduatedSchool, titleOfDoctor, hireDate, assistantName, branch, city);
				doctorSet.add(d);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		sc.close();
		return true;

	}

	
	public static String displayRecordInfo(int id) {
		String res = "";
		for (Patients p : patientSet) {
			if (p.getPatientId() == id) {
				res += p.getRecords().toString() + "";
			}
		}
		return res;
	}

	
	public static String displayDoctorInfo(String docName) {
		String res = "";
		for (Doctors d : doctorSet) {
			if (d.getName() == docName) {
				res += d.toString() + "";
			}
		}
		return res;
	}
	
	public static String[] getBranchName(HashSet<Doctors> doc,String branch) {
		String str[] = new String[2];
		int index = 0;

		for (Doctors d : doc) {
			if (d.getBranch().equalsIgnoreCase(branch)) {
				str[index] = d.getName();
				index++;
			}
		}
		return str;
	}

	public static HashSet<Doctors> getCityName(String city) {
		HashSet<Doctors> doc=new HashSet<Doctors>();

		for (Doctors d : doctorSet) {
			if (d.getCity().equalsIgnoreCase(city)) {
				doc.add(d);
			}
		}
		return doc;
	}
	
	public static Patients searchPatient(int id) {
		for (Patients p : patientSet) {
			if (p.getPatientId() == id) {
				return p;
			}
		}

		return null;
	}

	public static boolean deleteReservation(int id) {
		Patients p = searchPatient(id);
		p.getRecords().remove(p.getRecords().size()-1);
		return true;
	}

	public static double calCheckUpPrice(String checkUpType) {
		double price = 0;
		switch (checkUpType) {
		case "Cholesterol":
			price = 600;
			break;
		case "Diabetes":
			price = 1000;
			break;
		case "Effor Test":
			price = 1500;
			break;
		case "None":
			price=0;
			break;
		}
		return price;
	}

	public static HashSet<Patients> getPatientSet() {
		return patientSet;
	}

	public static HashSet<Doctors> getDoctorSet() {
		return doctorSet;
	}

	public static Hospital[] getHospitals() {
		return hospitals;
	}

	public static Hospital getHospital(int index) {
		return hospitals[index];
	}
}
