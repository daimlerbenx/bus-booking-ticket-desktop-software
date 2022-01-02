import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
 

public class LoginStaff extends JFrame implements ActionListener {

	
	private JLabel lblusername = new JLabel("Username");
	private JLabel lblpassword = new JLabel("Password ");
	private JLabel loginMsg = new JLabel("Please login to use this system");
	
	private JTextField usernameInput = new JTextField(13);
	private JPasswordField passwordInput = new JPasswordField(13);
	
	private JButton loginButton = new JButton("Login");
	private JButton cancelButton = new JButton("Cancel");
	
	private JPanel mainPanel = new JPanel();
	private JPanel instructionPanel = new JPanel();
	
	public LoginStaff() throws Exception{
			
			setTitle("Staff Login");
			setSize(260, 160);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			createGUI();
	}
	
	public void createGUI() {
		
		mainPanel.setLayout(new FlowLayout());
		instructionPanel.setLayout(new FlowLayout());
		
		instructionPanel.add(loginMsg);
		
		mainPanel.add(instructionPanel);
		mainPanel.add(lblusername);
		mainPanel.add(usernameInput);
		mainPanel.add(lblpassword);
		mainPanel.add(passwordInput);
		mainPanel.add(loginButton);
		mainPanel.add(cancelButton);
		
		loginButton.addActionListener(this);
		loginButton.setToolTipText("Make sure your username and password is correct");
		cancelButton.addActionListener(this);
		add(mainPanel);
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == loginButton){
	    	try {
	    		
	    		Staff myStaff = new Staff();
	    		
				String username = usernameInput.getText();
				
	    		String password = new String(passwordInput.getPassword());
	    		
	    		FileReader fileReader = new FileReader("./StaffList.txt");
	    		
	    		BufferedReader bufferedReader = new BufferedReader(fileReader);
	    		
	    		myStaff.setStaffKeyInUsername(username);
	    		myStaff.setStaffKeyInPassword(password);
	    		myStaff.loginProcess();
	    		dispose();
	    		
	    		bufferedReader.close();
	    		
	    	}catch(Exception E){
	    		JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
	    		usernameInput.setText("");
                passwordInput.setText("");
	    	}
		}
		else if (e.getSource() == cancelButton){
	    	dispose();
	    }
	}
}
	
