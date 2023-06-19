package Inheritance;

import java.util.ArrayList;
import java.util.Arrays;

import HasA.Records;
import Interface.Interface;

public class Patients extends Member {
	private final double VAT = 1.8;
	private ArrayList<Records> records = new ArrayList<>();
	private int patientId;
	private int age;
	private String gender;
	private String titleOfDoctorForFee;
	
	public Patients() {
	};

	public Patients(String name, String surname, int patientId, int age, String gender, String title) {
		super(name, surname);
		this.patientId = patientId;
		this.age = age;
		this.gender = gender;
		this.titleOfDoctorForFee = title;
	}

	@Override
	public double calcExaminationFee() {
		// TODO Auto-generated method stub

		double examinationFee = 0;

		if (titleOfDoctorForFee.equalsIgnoreCase("AssociateProfessor"))
			examinationFee = 350 * VAT;
		else if (titleOfDoctorForFee.equalsIgnoreCase("Generalist"))
			examinationFee = 200 * VAT;
		else
			examinationFee = 450 * VAT;

		return examinationFee;
	}

	public ArrayList<Records> getRecords() {
		return records;
	}
	
	public String[] getBranches(ArrayList<Records> records) {
		String str[]= new String[records.size()];
		for(int i=0;i<records.size();i++) {
			str[i]=records.get(i).getBranch();
		} 
		
		return str;
	}

	public void setRecords(ArrayList<Records> records) {
		this.records = records;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitleOfDoctor() {
		return titleOfDoctorForFee;
	}

	public void setTitleOfDoctor(String titleOfDoctorForFee) {
		this.titleOfDoctorForFee = titleOfDoctorForFee;
	}

	public double getVat() {
		return VAT;
	}

	@Override
	public String toString() {
		return "Patients\n" + super.toString() + "\nRecords=" + records + "\nPatient Id=" + patientId + "\nAge=" + age
				+ "\nGender=" + gender + "\nTitle Of Doctor=" + titleOfDoctorForFee; 
	}

	@Override
	public String GenerateImageName(int branch) {
		// TODO Auto-generated method stub
		return null;
	}

}
