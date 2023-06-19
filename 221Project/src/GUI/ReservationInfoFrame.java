package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Doctors;
import MainAndSystem.HospitalSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservationInfoFrame extends JFrame {

	private JPanel contentPane;
	ReservationFrame rf ;
	DoctorFrame df = new DoctorFrame(this);
	
	public static JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	

	

	public static JTextArea getTextArea() {
		return textArea;
	}
	
	/**
	 * Create the frame.
	 */
	public ReservationInfoFrame(ReservationFrame reservation) {
		rf = reservation;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservation Information");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel.setBounds(22, 10, 493, 72);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 89, 660, 252);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();

		
		scrollPane.setViewportView(textArea);
		
		JButton cancelInfo = new JButton("CANCEL THIS RESERVATION");
		
		cancelInfo.setBounds(22, 362, 227, 34);
		contentPane.add(cancelInfo);
		
		JButton mainBtn = new JButton("BACK");
		
		mainBtn.setBounds(449, 362, 232, 34);
		contentPane.add(mainBtn);
		
		JButton doctorBtn = new JButton("DOCTOR INFO");
	
		doctorBtn.setBounds(259, 362, 180, 34);
		contentPane.add(doctorBtn);
		
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.setVisible(true);
				dispose();
			}
		});
		
		cancelInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean chk;
				
				chk=HospitalSys.deleteReservation(ReservationFrame.id);
				 if(chk) {
					 textArea.setText("Cancelled");
				 } else {
					 textArea.setText("Cannot be cancelled");
				 }
				
			}
		});
		
		doctorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=0;

				Doctors d=new Doctors();
				if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Sude")) {
					index=0;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Merve")) {
					index=1;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				}else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Suna")) {
					index=2;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Ali")) {
					index=3;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Melis")) {
					index=4;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Deniz")){
					index=5;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Ahmet")) {
					index=6;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Leyla")) {
					index=7;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Sefa")) {
					index=8;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Mehmet")) {
					index=9;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Ömer")) {
					index=10;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Meryem")) {
					index=11;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Ayşe")) {
					index=12;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Selin")) {
					index=13;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Yusuf")) {
					index=14;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Berat")) {
					index=15;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else if(ReservationFrame.selectedDoctor.equalsIgnoreCase("Emir")) {
					index=16;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} else {
					index=17;
					df.getTextArea().setText(HospitalSys.displayDoctorInfo(ReservationFrame.selectedDoctor));
				} 
				
				String docImg=d.GenerateImageName(index);
				
				ImageIcon path = new ImageIcon(this.getClass().getResource("/images/doctors/"+docImg+".jpg"));
				
				df.getImgLabel().setIcon(path);
				df.setVisible(true);
				
				
			}
		});
	}
}
