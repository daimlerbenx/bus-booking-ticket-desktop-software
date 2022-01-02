import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Staff {
	private String staffUn;
	private String staffPwd;
	
	File file = new File("./StaffList.txt");
	private String username, password, ic;
	private String staffUsername, staffPassword, staffName, staffIC, staffPhone;
	private boolean found = false;
	
	public Staff() throws Exception{ //staff object (username, password, ic no)
		file.createNewFile();
	}
	
	public void setStaffKeyInUsername(String nm) {
		username = nm;
	}
	
	public void setStaffKeyInPassword(String pss) {
		password = pss;
	}
	
	public String getStaffKeyInUsername() {
		return username;
	}
	
	public String getStaffKeyInPassword() {
		return password;
	}
	
	public void setIC(String icNo) {
		ic = icNo;
	}
	
	public void loginProcess() {
		try {
			FileReader fr = new FileReader("./StaffList.txt");
			BufferedReader br = new BufferedReader(fr);
			Vector<String>element = new Vector<String>();
			String line;
			int y=0;
			while((line = br.readLine()) != null) {
				element.addElement(line);
				y++;
			}
			String[][] credential = new String[y][6];
			
			for(int i=0; i<y; i++) {
				StringTokenizer st = new StringTokenizer(element.elementAt(i));
				int z=0; 
				while(st.hasMoreElements()) {
					String word1 = st.nextToken();
					credential[i][z] = word1;
					z++;
				}
			}
			for(int i=0; i<y; i++) {
				
				if(username.equals(credential[i][0]) && password.equals(credential[i][1])) {
					found = true;
					JOptionPane.showMessageDialog(null,
                            "You have successfully logged in as an Staff.",
                            "Login Successful",
                            JOptionPane.PLAIN_MESSAGE);
					new StaffPage();
				}
			}
			if(found ==false) {
				JOptionPane.showMessageDialog(null,
                        "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);	
			}
			br.close();
		} catch(IOException e) {
			
		}	
	}
	public String searchStaff() throws IOException{
			
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
			for(int i=0; i<y; i++) {
				
				if(ic.equals(staffInfo[i][3])) {
					
					String name = staffInfo[i][2];
					String ic = staffInfo[i][3];
					String phone = staffInfo[i][4];
					String username = staffInfo[i][0];
					String password = staffInfo[i][1];
					
					line = "Staff Name: " + name +
							"\nI/C Number: " + ic +
							"\nPhone Number: " + phone +
							"\nUsername: " + username +
							"\nPassword: " + password;
				}
			}
			return line;
	}	
}