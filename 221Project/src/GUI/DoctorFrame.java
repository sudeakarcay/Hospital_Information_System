package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorFrame extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;
	public static JLabel imgLabel;

	public static JLabel getImgLabel() {
		return imgLabel;
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	ReservationInfoFrame resFrame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DoctorFrame(ReservationInfoFrame reservationFrame) {
		resFrame = reservationFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 440);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton exitBtn = new JButton("CLOSE");
		exitBtn.setBounds(568, 372, 85, 21);
		contentPane.add(exitBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 60, 294, 286);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel = new JLabel("Doctor Info");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 25, 116, 25);
		contentPane.add(lblNewLabel);

		imgLabel = new JLabel("");
		imgLabel.setBounds(392, 98, 219, 200);
		contentPane.add(imgLabel);

		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resFrame.setVisible(true);
				dispose();
			}
		});

	}
}
