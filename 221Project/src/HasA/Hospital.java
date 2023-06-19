package HasA;

public class Hospital {

	private String city;
	private String phoneNumber;
	private String mailAddress;
	
	
	public Hospital() {
		// TODO Auto-generated constructor stub
		this.city="No City";
		this.phoneNumber="No phone number.";
		this.mailAddress="No mail address.";
	}
	
	public Hospital(String city,String phoneNumber,String mailAddress) {
		this.city=city;
		this.phoneNumber=phoneNumber;
		this.mailAddress=mailAddress;
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
}
