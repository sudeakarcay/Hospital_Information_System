package Inheritance;

import Interface.Interface;

public class Doctors extends Member implements Interface {

	private String gratuatedSchool;
	private String titleOfDoctor;
	private String hireDate;
	private String assistantName;
	private String branch;
	private String city;
	
	public Doctors() {
		
	}

	public Doctors(String name, String surname, String gratuatedSchool, String titleOfDoctor, String hireDate,
			String assistantName, String branch, String city) {
		super(name, surname);
		this.gratuatedSchool = gratuatedSchool;
		this.titleOfDoctor = titleOfDoctor;
		this.hireDate = hireDate;
		this.assistantName = assistantName;
		this.branch = branch;
		this.city =	city;
	}

	
	public String getGratuatedSchool() {
		return gratuatedSchool;
	}


	public void setGratuatedSchool(String gratuatedSchool) {
		this.gratuatedSchool = gratuatedSchool;
	}


	public String getTitleOfDoctor() {
		return titleOfDoctor;
	}


	public void setTitleOfDoctor(String titleOfDoctor) {
		this.titleOfDoctor = titleOfDoctor;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getAssistantName() {
		return assistantName;
	}


	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	@Override
	public double calcExaminationFee() {
		// TODO Auto-generated method stub
		double examinationFee = 0;
		if (titleOfDoctor.equalsIgnoreCase("Associate Professor"))
			examinationFee = 350;

		else if (titleOfDoctor.equalsIgnoreCase("Generalist"))
			examinationFee = 200;

		else
			examinationFee = 450;

		return examinationFee;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "\nGratuated School=" + gratuatedSchool + "\nTitle Of Doctor="
				+ titleOfDoctor + "\nHire Date=" + hireDate + "\nAssistant Name=" + assistantName + "\nBranch="
				+ branch;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String GenerateImageName(int indexOfPhoto) {
		String[] imageOfDoctors = new String [] {"Sude","Merve","Suna","Ali","Melis","Deniz","Ahmet","Leyla",
				"Sefa","Mehmet","Ömer","Meryem","Ayşe","Selin","Yusuf","Berat","Emir","Zümra"};
		return imageOfDoctors[indexOfPhoto];
	}

	
}
