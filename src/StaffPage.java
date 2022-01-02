import java.awt.Color;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;

public class StaffPage extends JFrame implements ActionListener{

	private JLabel lblstaffGreetings = new JLabel("You are logged in as Staff");
	private JPanel mainPanel = new JPanel();
	private JButton btnBooking = new JButton("Book Ticket");
	private JButton btnLogout = new JButton("Logout");
	private Container contentPane;
	
	public StaffPage() {
		setSize(810,600);
		setLocationRelativeTo(null);
	    setTitle("Staff Homepage");
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    createGUI();
	    setMyFont();
	}
	
	public void setMyFont() {
		Font myFont = new Font("monospaced" , Font.PLAIN , 15);
		
		btnBooking.setFont(myFont);
		btnBooking.setToolTipText("Plan your destination");
		
		btnLogout.setFont(myFont);
	
	}
	
	public void createGUI() {
		mainPanel.setLayout(null);
			
		mainPanel.add(btnBooking);
		
		mainPanel.add(btnLogout);
		
		btnBooking.setBounds(300,140,250,50);
		btnBooking.setForeground(Color.white);
		btnBooking.setBackground(Color.black);
		
		btnLogout.setBounds(300,300,250,50);
		btnLogout.setForeground(Color.white);
		btnLogout.setBackground(Color.red);
		
		btnLogout.addActionListener(this);
		btnBooking.addActionListener(this);
		
		add(mainPanel);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnBooking) {
			new TheStaffPage();
		}
		else if(e.getSource() == btnLogout) {
			JOptionPane.showMessageDialog(StaffPage.this,
					"Thanks for using this system",
                    "Logging Out",
                    JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
	}
}
