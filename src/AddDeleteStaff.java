import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddDeleteStaff extends JFrame implements ActionListener{

	private JLabel lblName = new JLabel("Name");
	private JLabel lblIC = new JLabel("I/C Number");
	private JLabel lblPhone = new JLabel("Phone Number");
	private JLabel lblUsername = new JLabel("Username");
	private JLabel lblPassword = new JLabel("Password");
	private JLabel lblIcExample = new JLabel("Eg: 96091912");
	private JLabel lblPhoneExample = new JLabel("Eg: 01138485656");

	private JTextField tfName = new JTextField(15);
	private JTextField tfIC = new JTextField(15);
	private JTextField tfPhone = new JTextField(15);
	private JTextField tfUsername = new JTextField(15);
	private JTextField tfPassword = new JTextField(15);

	private JButton btnDel = new JButton("Delete Staff");
	private JButton btnAdd = new JButton("Add Staff");
	private JButton btnPrevious = new JButton("Back to Admin Page");
	private JButton btnConfirm = new JButton("Confirm");
	private JButton btnReset = new JButton("Reset");
	private JButton btnCancel = new JButton("Back");
	private JButton btnDeleteStaff = new JButton("Delete Staff");
	private JButton btnBack = new JButton("Back");
	private JButton btnSearch = new JButton("Search Staff");

	private JPanel mainPanel = new JPanel();
	private JPanel mainPanel1 = new JPanel();
	private JPanel mainPanel2 = new JPanel();
	private JPanel buttonPanel1 = new JPanel();
	private JPanel buttonPanel2 = new JPanel();
	private JPanel buttonPanel3 = new JPanel();

	private JTextArea taStaffInfo = new JTextArea(20,40);

	File file = new File("./StaffList.txt");

	public AddDeleteStaff() {
		setSize(810,600);
		setLocationRelativeTo(null);
		setTitle("Staff Homepage"); //to set title on top
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the apps not run in background while it been close 
		setResizable(false); //lock the size
		setMyFont();
		createGUI();
	}
	public void setMyFont() {
		Font myFont = new Font("monospaced", Font.CENTER_BASELINE, 15);
		Font myFont2 = new Font("monospaced", Font.ITALIC, 13);
		Font myFont3 = new Font("monospaced", Font.CENTER_BASELINE, 14);

		lblIcExample.setFont(myFont2);
		lblPhoneExample.setFont(myFont2);
		lblName.setFont(myFont);
		lblIC.setFont(myFont);
		lblPhone.setFont(myFont2);
		lblUsername.setFont(myFont);
		lblPassword.setFont(myFont);

		tfName.setFont(myFont);
		tfIC.setFont(myFont);
		tfPhone.setFont(myFont);
		tfUsername.setFont(myFont);
		tfPassword.setFont(myFont);

		btnAdd.setFont(myFont3);
		btnDel.setFont(myFont3);
		btnPrevious.setFont(myFont3);
		btnSearch.setFont(myFont3);
		btnConfirm.setFont(myFont3);
		btnReset.setFont(myFont3);
		btnCancel.setFont(myFont3);
		btnDeleteStaff.setFont(myFont3);
		btnBack.setFont(myFont3);
	}
	private void createGUI() {
		
		mainPanel.setLayout(null);
		mainPanel1.setLayout(null);
		mainPanel2.setLayout(new FlowLayout());

		buttonPanel1.setLayout(new FlowLayout());
		buttonPanel2.setLayout(new FlowLayout());

		mainPanel.add(btnAdd);
		mainPanel.add(btnDel);
		mainPanel.add(btnPrevious);
		btnAdd.setBounds(280,140,250,50);
		btnAdd.setForeground(Color.black);
		btnAdd.setBackground(Color.white);
		btnDel.setBounds(280,220,250,50);
		btnDel.setForeground(Color.black);
		btnDel.setBackground(Color.white);
		btnPrevious.setBounds(280,300,250,50);
		btnPrevious.setForeground(Color.black);
		btnPrevious.setBackground(Color.orange);

		mainPanel.add(buttonPanel1);
		mainPanel.add(buttonPanel2);

		add(mainPanel);

		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnPrevious.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnAdd) {
			try {
				mainPanel.setVisible(false);
				mainPanel1.setVisible(true);

				mainPanel1.add(lblName);
				mainPanel1.add(tfName);
				mainPanel1.add(lblIC);
				mainPanel1.add(tfIC);
				mainPanel1.add(lblIcExample);
				mainPanel1.add(lblPhone);
				mainPanel1.add(tfPhone);
				mainPanel1.add(lblPhoneExample);
				mainPanel1.add(lblUsername);
				mainPanel1.add(tfUsername);
				mainPanel1.add(lblPassword);
				mainPanel1.add(tfPassword);

				setTitle("Add Staff Page");
				setSize(810,600);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				lblName.setBounds(250,90,100,30); //add name text
				tfName.setBounds(430,90,200,30); //add name box

				lblIC.setBounds(250,130,100,30); //add IC text
				tfIC.setBounds(430,130,200,30); //add IC box
				lblIcExample.setBounds(650,130,200,30); //IC example text

				lblPhone.setBounds(250,170,100,30); //add phone no text
				tfPhone.setBounds(430,170,200,30); //add phone no box
				lblPhoneExample.setBounds(650,170, 200, 30); //phone no example

				lblUsername.setBounds(250,210,300,30); //add user name text
				tfUsername.setBounds(430,210,200,30); //add user name box

				lblPassword.setBounds(250,250,300,30); //add password text
				tfPassword.setBounds(430,250,200,30); //add password box

				buttonPanel2.add(btnCancel);
				buttonPanel2.add(btnReset);
				buttonPanel2.add(btnConfirm);

				buttonPanel2.setBounds(300, 340, 290, 50); //dimension of button confirm, reset, and back
				btnConfirm.setForeground(Color.black); //confirm button text color
				btnConfirm.setBackground(Color.white); //confirm button background color
				btnReset.setForeground(Color.white); //reset button background color
				btnReset.setBackground(Color.black); //reset button background color
				btnCancel.setForeground(Color.black); //back/cancel button background color
				btnCancel.setBackground(Color.orange); //back/cancel button background color

				btnConfirm.addActionListener(this);
				btnReset.addActionListener(this);
				btnCancel.addActionListener(this);

				mainPanel1.add(buttonPanel2);

				add(mainPanel1);

				tfName.setText("");
				tfIC.setText("");
				tfPhone.setText("");
				tfUsername.setText("");
				tfPassword.setText("");

				String name = tfName.getText();
				String ic = tfIC.getText();
				String phone = tfPhone.getText();
				String username = tfUsername.getText();
				String password = tfPassword.getText();

			}catch(Exception E) {
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
			}


		}
		else if(e.getSource() == btnDel) {
			try {
				mainPanel.setVisible(false);
				mainPanel2.setVisible(true);

				setTitle("Delete Staff Page");
				setSize(810,600);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				mainPanel2.add(lblIC);
				mainPanel2.add(tfIC);
				mainPanel2.add(btnSearch);
				mainPanel2.add(taStaffInfo);

				tfIC.setText("");
				taStaffInfo.setText("");

				buttonPanel3.add(btnBack);
				buttonPanel3.add(btnDeleteStaff);

				buttonPanel3.setBounds(500, 260, 290, 50);
				btnSearch.setForeground(Color.black);
				btnSearch.setBackground(Color.white);
				btnDeleteStaff.setForeground(Color.black);
				btnDeleteStaff.setBackground(Color.white);
				btnBack.setForeground(Color.black);
				btnBack.setBackground(Color.orange);

				btnBack.addActionListener(this);
				btnDeleteStaff.addActionListener(this);
				btnSearch.addActionListener(this);

				mainPanel2.add(buttonPanel3);

				add(mainPanel2);

			}
			catch(Exception E) {

			}

		}
		if(e.getSource() == btnPrevious) {
			dispose();
		}

		if(e.getSource() == btnBack) {
			mainPanel2.setVisible(false);
			mainPanel.setVisible(true);
			setTitle("Staff Homepage");
		}

		if(e.getSource()==btnDeleteStaff) {
			try {

				String IC = tfIC.getText();

				FileReader fr = new FileReader("./StaffList.txt");
				BufferedReader br = new BufferedReader(fr);

				Vector<String>element = new Vector<String>();
				String line;

				int y=0;

				while((line = br.readLine()) != null) {
					element.addElement(line);
					y++;
				}

				fr.close();
				br.close();
				String[][] staffInfo = new String[y][6];

				for(int i=0; i<y; i++) {
					StringTokenizer st = new StringTokenizer(element.elementAt(i));
					int z=0; 
					while(st.hasMoreElements()) {
						String word1 = st.nextToken();
						staffInfo[i][z] = word1;
						z++;
					}
				}

				String staffToDel = "";
				DeleteLine dl = new DeleteLine();
				for(int i=0; i<y; i++) {
					if(IC.equals(staffInfo[i][3])) {
						staffToDel = staffInfo[i][0] + " " + staffInfo[i][1]+ " " + staffInfo[i][2] + " " + staffInfo[i][3] + " "
								+ staffInfo[i][4] + " " + staffInfo[i][5];
						dl.deleteLine("./StaffList.txt", staffToDel);
					}	
				}

				JOptionPane.showMessageDialog(null,"Staff deleted","Successful",JOptionPane.PLAIN_MESSAGE);

				taStaffInfo.setText(null);
			}
			catch(Exception E) {
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}

		if(e.getSource() == btnSearch) {

			try {
				Staff myStaff = new Staff();

				String IC = tfIC.getText();
				myStaff.setIC(IC);

				FileReader fileReader = new FileReader("./StaffList.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				if(taStaffInfo!=null) {
					taStaffInfo.setText(null);
					taStaffInfo.append(myStaff.searchStaff());
				}

				bufferedReader.close();
				fileReader.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		if(e.getSource()==btnConfirm){

			try {

				FileWriter writer = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(writer);

				FileReader reader = new FileReader("./StaffList.txt");
				BufferedReader br = new BufferedReader(reader);

				String username, password, name, ic, phone;

				int numberOfStaff = 0;
				while(br.readLine() !=null) {
					numberOfStaff++;
				}
				username = tfUsername.getText();
				password = tfPassword.getText();
				name = tfName.getText();
				ic = tfIC.getText();
				phone = tfPhone.getText();

				if(numberOfStaff <3) {
					writer.write(username + " " + password + " " + name + " " + ic + " " + phone + " \n");
					JOptionPane.showMessageDialog(null,"Staff Added","Successful",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					System.out.println("error");
					JOptionPane.showMessageDialog(null, "Number of Staff should not exceed 3 persons", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				writer.flush();
				writer.close();
				br.close();
				bw.close();
				reader.close();

				tfName.setText("");
				tfIC.setText("");
				tfPhone.setText("");
				tfUsername.setText("");
				tfPassword.setText("");

			}catch(Exception E) {
				JOptionPane.showMessageDialog(null, "Cannot be empty", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == btnReset) { //button reset to delete all info that has been input in admin page
			tfName.setText("");
			tfIC.setText("");
			tfPhone.setText("");
			tfUsername.setText("");
			tfPassword.setText("");
		}
		else if(e.getSource()==btnCancel) { // or button back to cancel add staff in admin page
			mainPanel1.setVisible(false);
			mainPanel.setVisible(true);
			setTitle("Staff Homepage");
		}
	}
}