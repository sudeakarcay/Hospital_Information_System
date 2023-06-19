package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasA.Records;
import Inheritance.Doctors;
import Inheritance.Patients;
import MainAndSystem.HospitalSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ReservationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField dateField;
	private JTextField ageField;
	public static int id; 
	public static JComboBox doctorComboBox;
	
	WelcomeFrame wf ;
	ReservationInfoFrame rInfo = new ReservationInfoFrame(this);
	
	public static String selectedBranch;
	public static String selectedDoctor;
	public static int selectedHospital;
	public static String date;
	private JTextField genderField;
	private JTextField idField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	 public JComboBox<String> getCombo() {
	     return doctorComboBox;
	 }
	 
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ReservationFrame(WelcomeFrame welcome) {
		wf = welcome;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(27, 72, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(new Color(29, 148, 226));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 50, 87, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(new Color(29, 148, 226));
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurname.setBounds(69, 86, 87, 37);
		contentPane.add(lblSurname);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(29, 148, 226));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(69, 124, 87, 37);
		contentPane.add(lblDate);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(new Color(29, 148, 226));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(69, 162, 87, 37);
		contentPane.add(lblAge);
		
		nameField = new JTextField();
		nameField.setBounds(154, 59, 179, 25);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(154, 95, 179, 28);
		contentPane.add(surnameField);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(154, 133, 179, 25);
		contentPane.add(dateField);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(154, 171, 179, 25);
		contentPane.add(ageField);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(new Color(29, 148, 226));
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(515, 50, 37, 37);
		contentPane.add(lblCity);
		
		JLabel lblNewLabel_1_1 = new JLabel("Branch:");
		lblNewLabel_1_1.setForeground(new Color(29, 148, 226));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(489, 124, 63, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox cityComboBox = new JComboBox();
		cityComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHospital=cityComboBox.getSelectedIndex();
			}
		});
		cityComboBox.setForeground(new Color(27, 72, 228));
		cityComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Ankara", "Kocaeli", "Sivas"}));
		cityComboBox.setBounds(562, 51, 143, 34);
		contentPane.add(cityComboBox);
		
		JComboBox branchComboBox = new JComboBox();
	
		branchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Neurology", "Cardiology", "Orthopedics"}));
		branchComboBox.setForeground(new Color(27, 72, 228));
		branchComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		branchComboBox.setBounds(562, 125, 143, 34);
		contentPane.add(branchComboBox);
		
		
		JLabel lblDoctorChoice = new JLabel("Doctor Choice:");
		lblDoctorChoice.setForeground(new Color(29, 148, 226));
		lblDoctorChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoctorChoice.setBounds(433, 203, 119, 25);
		contentPane.add(lblDoctorChoice);
		
		doctorComboBox = new JComboBox();
		doctorComboBox.setForeground(new Color(27, 72, 228));
		doctorComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		doctorComboBox.setBounds(562, 198, 143, 34);
		contentPane.add(doctorComboBox);
		
		JLabel messageField = new JLabel("");
		messageField.setForeground(new Color(29, 148, 226));
		messageField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		messageField.setBounds(154, 334, 432, 37);
		contentPane.add(messageField);
		
		JButton submitBtn = new JButton("SUBMIT");
		
		submitBtn.setForeground(new Color(27, 72, 228));
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submitBtn.setBounds(94, 393, 156, 43);
		contentPane.add(submitBtn);
		
		JButton btnExit = new JButton("EXIT");
		
		btnExit.setForeground(new Color(27, 72, 228));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(477, 393, 156, 43);
		contentPane.add(btnExit);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(154, 206, 179, 25);
		contentPane.add(genderField);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(new Color(29, 148, 226));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(69, 203, 87, 25);
		contentPane.add(lblGender);
		
		JLabel lblNewLabel_1 = new JLabel("Ex: 30.12.2022");
		lblNewLabel_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1.setBounds(343, 139, 88, 13);
		contentPane.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(154, 24, 179, 25);
		contentPane.add(idField);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(new Color(29, 148, 226));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(69, 15, 87, 37);
		contentPane.add(lblId);
		
		JRadioButton cRB = new JRadioButton("Cholesterol");
		cRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(cRB);
		cRB.setBounds(212, 293, 103, 21);
		contentPane.add(cRB);
		
		JRadioButton dRB = new JRadioButton("Diabetes");
		dRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(dRB);
		dRB.setBounds(344, 293, 103, 21);
		contentPane.add(dRB);
		
		JRadioButton eRB = new JRadioButton("Effor Test");
		eRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(eRB);
		eRB.setBounds(467, 293, 103, 21);
		contentPane.add(eRB);
		
		JRadioButton nRB = new JRadioButton("None");
		nRB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(nRB);
		nRB.setBounds(589, 293, 103, 21);
		contentPane.add(nRB);
		
		JLabel lblCheckupOptions = new JLabel("Checkup Options:");
		lblCheckupOptions.setForeground(new Color(29, 148, 226));
		lblCheckupOptions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheckupOptions.setBounds(40, 273, 156, 58);
		contentPane.add(lblCheckupOptions);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wf.setVisible(true);
				dispose();
			}
		});
		
		branchComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedBranch=branchComboBox.getSelectedItem().toString();
				wf.fillComboBox();
			}
		});
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			    if(idField.getText().isEmpty()||nameField.getText().isEmpty() || surnameField.getText().isEmpty() 
			    		|| dateField.getText().isEmpty() || ageField.getText().isEmpty()  || selectedBranch.isEmpty()
			    		|| buttonGroup.getSelection()==null ){
			    	messageField.setText("Fill the necessary fields!");
			    } else {
			    	String name = nameField.getText();
					String surname = surnameField.getText();
					date = dateField.getText();
					int age = Integer.parseInt(ageField.getText());
					String gender = genderField.getText();
					id = Integer.parseInt(idField.getText());
					selectedDoctor=doctorComboBox.getSelectedItem().toString();
					String title="";
					for(Doctors d:HospitalSys.getDoctorSet()) {
						if(d.getName().equalsIgnoreCase(selectedDoctor))
							title=d.getTitleOfDoctor();
					}
			
					boolean res;
					res=HospitalSys.addPatient(name, surname, id, age, gender,title);
					
					int index;
					if(selectedBranch.equalsIgnoreCase("neurology")) {
						index=0;
					} else if(selectedBranch.equalsIgnoreCase("cardiology")) {
						index=1;
					} else {
						index=2;
					}
					
					String imgName="";
					Records r=new Records();
					imgName=r.GenerateImageName(index);
					boolean isRec;
					isRec=HospitalSys.addRecord(imgName, selectedBranch,HospitalSys.searchPatient(id).getPatientId(),date);
					
					idField.setText("");
					nameField.setText("");
					surnameField.setText("");
					dateField.setText("");
					ageField.setText("");
					genderField.setText("");
					
					rInfo.setVisible(true);
					dispose();
					String rName="";
					if(nRB.isSelected()) {
						rName="None";
					}
					else if(eRB.isSelected()) {
						rName="Effor Test";
					}
					else if(dRB.isSelected()) {
						rName="Diabetes";
					}
					else {
						rName="Cholesterol";
					}
					double price=HospitalSys.calCheckUpPrice(rName);
					
					rInfo.getTextArea().setText("-Medicana "+HospitalSys.getHospital(selectedHospital).getCity()
											+"-\n\nReservation\n-------------------\n"+ "Date: "+date
											+"\nBranch: "+selectedBranch
											+"\nPhone Number: "+HospitalSys.getHospital(selectedHospital).getPhoneNumber()
											+"\nEmail Address: "+HospitalSys.getHospital(selectedHospital).getMailAddress()
											+"\nCheckup Price:" + price + " TL");
					}
			    
			}
			
		
		});
	}
}