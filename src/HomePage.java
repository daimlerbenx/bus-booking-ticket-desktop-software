import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

	private JPanel mainPanel = new JPanel();
	
	private JButton staff = new JButton("STAFF");
	private JButton admin = new JButton("ADMIN");
	
	Container con = getContentPane();
	
	public HomePage(){
			
		setTitle("Bus Reservation System"); //title bar
		setSize(810,600); //set the windows size
		setLocationRelativeTo(null); //apps will appear at center of the screen
		setVisible(true); //make it visible *important
		setResizable(false); //lock the windows size that has been set
		setDefaultCloseOperation(EXIT_ON_CLOSE); //close immediately without the apps run in background
		setButton();
		setBackground();
	}
	public void setButton(){
			
			Font a = new Font("Monospaced" , Font.CENTER_BASELINE , 35); //set all the font at same position
			
			mainPanel.add(staff); //main color for staff is white/black
			staff.setForeground(Color.white);
			staff.setBackground(Color.black);
			staff.setToolTipText("Click if you are Staff"); //text appear @hover
			
			mainPanel.add(admin); //main color for admin is black/white
			admin.setForeground(Color.black);
			admin.setBackground(Color.white);
			admin.setToolTipText("Click if you are Admin"); //text appear @hover
			
			staff.setFont(a); //take  the setting in a
			admin.setFont(a); 
			
			staff.addActionListener(this); //function of the button staff
			admin.addActionListener(this); //function of the button admin
		}
	
	//set the background in homepage import image from directory file
	public void setBackground(){
			
			JLabel background = new JLabel(new ImageIcon("image/logo.gif")); //import picture from directory file
			con.add(background); //background in container
			background.setLayout(new FlowLayout());
			background.add(mainPanel);
			validate();
		}
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == staff){
			try {
				new LoginStaff();
			}
			catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
		if(e.getSource() == admin){
			try {
				new LoginAdmin();
			}
			catch (Exception e1) {
					
				e1.printStackTrace();
			}
		}
	}
}