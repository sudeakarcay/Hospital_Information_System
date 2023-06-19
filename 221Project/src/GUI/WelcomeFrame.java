package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Doctors;
import MainAndSystem.HospitalSys;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {

	private JPanel contentPane;
	RecordFrame rf = new RecordFrame(this);
	ReservationFrame resFrame =  new ReservationFrame(this);
	
	public void fillComboBox() { 
		resFrame.getCombo().setModel(new DefaultComboBoxModel(HospitalSys.getBranchName(HospitalSys.getCityName(HospitalSys.getHospitals()[ReservationFrame.selectedHospital].getCity()), ReservationFrame.selectedBranch)));
	}

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public WelcomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/images/hospitalImage.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(99, 112, 872, 392);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO THE HOSPITAL INFORMATION SYSTEM\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(0, 102, 204));
		lblNewLabel_1.setBackground(new Color(0, 51, 102));
		lblNewLabel_1.setBounds(128, 23, 809, 59);
		contentPane.add(lblNewLabel_1);
		
		JButton showRecordBtn = new JButton("Show Your Old Record");
		
		showRecordBtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		showRecordBtn.setBounds(188, 530, 264, 48);
		contentPane.add(showRecordBtn);
		
		JButton makeReservationBtn = new JButton("Make A New Reservation");
		
		makeReservationBtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		makeReservationBtn.setBounds(627, 530, 274, 48);
		contentPane.add(makeReservationBtn);
		
		JLabel messageField = new JLabel("");
		messageField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		messageField.setBounds(660, 487, 332, 35);
		contentPane.add(messageField);
		
		showRecordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					rf.setVisible(true);
					dispose();
			}
		});
		
		makeReservationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					resFrame.setVisible(true);
					dispose();
				}
		});
	}
}