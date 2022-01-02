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

public class LoginAdmin extends JFrame implements ActionListener {

	private JLabel lblusername = new JLabel("Username");
	private JLabel lblpassword = new JLabel("Password");
	private JLabel loginMsg = new JLabel("Please login to use this system");

	private JTextField usernameInput = new JTextField(13);
	private JPasswordField passwordInput = new JPasswordField(13); //JPasswordField does not show the characters that the user types

	private JButton cancelButton = new JButton("Cancel");
	private JButton loginButton = new JButton("Login");

	private JPanel mainPanel = new JPanel();
	private JPanel instructionPanel = new JPanel();

	public LoginAdmin() throws Exception{

		setTitle("Admin Login");
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
		cancelButton.addActionListener(this);
		add(mainPanel);
	}
	public void actionPerformed(ActionEvent e) {
		User myUser = new User();

		if(e.getSource() == loginButton){
			try {
				Admin myAdmin = new Admin();

				String username = usernameInput.getText();
				myUser.setUsername(username);
				String password = new String(passwordInput.getPassword());
				myUser.setPassword(password);

				FileReader fileReader = new FileReader("Admin.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while((bufferedReader.readLine()) != null) {
					if(myUser.getUsername().equals(myAdmin.getAdminName()) && myUser.getPassword().equals(myAdmin.getAdminPassword())) {
						dispose();
						JOptionPane.showMessageDialog(LoginAdmin.this,
								"You have successfully logged in as an Admin.",
								"Login Successful",
								JOptionPane.PLAIN_MESSAGE);
						dispose();
						new AdminPage();
					}
					else {
						JOptionPane.showMessageDialog(LoginAdmin.this,
								"Invalid username or password",
								"Login Failed",
								JOptionPane.ERROR_MESSAGE);
						usernameInput.setText("");
						passwordInput.setText("");
					}
				}
				bufferedReader.close();
			}catch(Exception E){
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);	
			}
		}
		else if (e.getSource() == cancelButton){
			dispose();
		}
	}
}