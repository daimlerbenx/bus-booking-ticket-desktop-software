import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminPage extends JFrame implements ActionListener{

	private JLabel lbladminGreetings = new JLabel("You are logged in as Admin");
	
	private JPanel mainPanel = new JPanel();
	
	private JButton btnAddDelStaff = new JButton("Update Staff");
	private JButton btnAddDelRoute = new JButton("Update Route");
	private JButton btnAddDelTime = new JButton("Update Time");
	private JButton btnLogout = new JButton("Logout");
	
	public AdminPage() {
		setSize(810,600);
	    setLocationRelativeTo(null);
	    setTitle("Admin Homepage");
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    createGUI();
	    setMyFont();
	}
	
	public void setMyFont() {
		Font myFont = new Font("monospaced", Font.CENTER_BASELINE, 15);
		
		btnAddDelStaff.setFont(myFont);
		btnAddDelStaff.setForeground(Color.black);
		btnAddDelStaff.setBackground(Color.white);
		btnAddDelRoute.setFont(myFont);
		btnAddDelRoute.setForeground(Color.black);
		btnAddDelRoute.setBackground(Color.white);
		btnAddDelTime.setFont(myFont);
		btnAddDelTime.setForeground(Color.black);
		btnAddDelTime.setBackground(Color.white);
		btnLogout.setFont(myFont);
		btnLogout.setForeground(Color.black);
		btnLogout.setBackground(Color.red);
	}
	
	public void createGUI() {
			
		mainPanel.setLayout(null);
			
		mainPanel.add(btnAddDelRoute);
		mainPanel.add(btnAddDelTime);
		mainPanel.add(btnAddDelStaff);
		mainPanel.add(btnLogout);
		
		btnAddDelRoute.setBounds(270,140,250,50);
		btnAddDelTime.setBounds(270,220,250,50);
		btnAddDelStaff.setBounds(270,300,250,50);
		btnLogout.setBounds(270,380,250,50);
		
		btnAddDelRoute.addActionListener(this);
		btnAddDelTime.addActionListener(this);
		btnAddDelStaff.addActionListener(this);
		btnLogout.addActionListener(this);
		
		add(mainPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnAddDelStaff) {
			new AddDeleteStaff();
		}
		else if(e.getSource() == btnAddDelTime) {
			new AddDeleteTime();
		}
		else if(e.getSource() == btnAddDelRoute) {
			new AddDeleteRoute();
		}
		else if(e.getSource() == btnLogout) {
			JOptionPane.showMessageDialog(AdminPage.this,
					"Thanks for using this system",
                    "Logging Out",
                    JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
	}
}