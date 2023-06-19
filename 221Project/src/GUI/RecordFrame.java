package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasA.Records;
import Inheritance.Patients;
import MainAndSystem.HospitalSys;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RecordFrame extends JFrame {

	private JPanel contentPane;
	public static Patients p;
	WelcomeFrame wf;
	private JTextField enterIdField;

	Records r = new Records();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RecordFrame(WelcomeFrame welcome) {
		wf = welcome;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton exitBtn = new JButton("EXIT");

		exitBtn.setBounds(534, 394, 101, 30);
		contentPane.add(exitBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 104, 404, 320);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel = new JLabel("RECORDS");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 10, 141, 44);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Your Id:");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(22, 42, 115, 49);
		contentPane.add(lblNewLabel_1_1);

		enterIdField = new JTextField();

		enterIdField.setBounds(147, 54, 90, 30);
		contentPane.add(enterIdField);
		enterIdField.setColumns(10);

		JLabel neuroLabel = new JLabel("");
		neuroLabel.setBounds(503, 54, 101, 86);
		contentPane.add(neuroLabel);

		JLabel cardioLabel = new JLabel("");
		cardioLabel.setBounds(503, 157, 101, 86);
		contentPane.add(cardioLabel);

		JLabel orthoLabel = new JLabel("");
		orthoLabel.setBounds(503, 267, 101, 86);
		contentPane.add(orthoLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("(Press Enter)");
		lblNewLabel_1_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(247, 45, 115, 49);
		contentPane.add(lblNewLabel_1_1_1);

		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wf.setVisible(true);
				dispose();
			}
		});

		enterIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int patId = 0;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (enterIdField.getText().isEmpty()) {
						textArea.setText("Please Enter Your Id.");
					} else {
						patId = Integer.parseInt(enterIdField.getText());
						Patients p = new Patients();
						p = HospitalSys.searchPatient(patId);
						if (p == null) {
							textArea.setText("Patient is not found");
						} else {
							textArea.setText(HospitalSys.displayRecordInfo(patId));
							enterIdField.setText("");

							for (Patients patient : HospitalSys.getPatientSet()) {
								int index = 0;

								String[] branchs = patient.getBranches(p.getRecords());
								System.out.println(branchs);
								String imgName = "";
								for (int i = 0; i < branchs.length; i++) {
									if (branchs[i].equalsIgnoreCase("Cardiology")) {
										index = 0;
										imgName = r.GenerateImageName(index);
										ImageIcon path = new ImageIcon(this.getClass().getResource("/images/branchs/"+imgName+".jpg"));
										cardioLabel.setIcon(path);

									} else if (branchs[i].equalsIgnoreCase("Neurology")) {
										index = 1;
										imgName = r.GenerateImageName(index);
										ImageIcon path = new ImageIcon(this.getClass().getResource("/images/branchs/"+imgName+".jpg"));
										neuroLabel.setIcon(path);
									} else {
										index = 2;
										imgName = r.GenerateImageName(index);
										ImageIcon path = new ImageIcon(this.getClass().getResource("/images/branchs/"+imgName+".jpg"));
										orthoLabel.setIcon(path);
									}
								}

							}
						}
					}

				}
			}
		});

	}
}
