import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;


public class Admin { // admin object (username, password)
	
	private String adminUsername;
	private String adminPwd;
	
	File file = new File("./Admin.txt");
	
	public Admin() throws Exception{
		
		file.createNewFile();
		readAdminLogin();
	}
	
	public void setAdminName(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	
	public String getAdminName() {
		return adminUsername;
	}
	
	public void setAdminPassword(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	
	public String getAdminPassword() {
		return adminPwd;
	}
	
	public void readAdminLogin() throws Exception{
			
		try {
			FileReader fr = new FileReader(file); //read the admin username and password from text file 
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while((line = br.readLine()) != null) {
				String[] stringArr = line.split("\\,");
					setAdminName(stringArr[0]);
					setAdminPassword(stringArr[1]);
			}
			br.close();
		} catch(IOException e) {
			
		}
	}
	public String displayRoutesAvailable() throws Exception{
		String line2 = "All Available Route\n\n";
		try {
			String departFrom, departTo, routePrice;
			FileReader fr = new FileReader("./patternplace.txt");
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
			
			String[][] routeInfo = new String[y][3];
						
			for(int i=0; i<y; i++) {
				StringTokenizer st = new StringTokenizer(element.elementAt(i));
				int z=0; 
				while(st.hasMoreElements()) {
					String word1 = st.nextToken();
					routeInfo[i][z] = word1;
					z++;
				}
			}
			String allRoutes[] = new String[y];
			
			for(int i=0; i<y; i++) {
							
				departFrom = routeInfo[i][0];
				departTo = routeInfo[i][1];
				routePrice = routeInfo[i][2];
					
					
				allRoutes[i] = "Route ID: " + (i + 1) +
							"\nDepart From: " + departFrom +
							"\nDepart To: " + departTo +
							"\nRoute Price: RM" + routePrice+
							"\n\n";
					
				 line2 += allRoutes[i];
			}
		}
		catch(Exception E) {
		}
		return line2;
	}
	public String displayTimeAvailable() throws Exception{
		String line2 = "\tAll Available Times\n\n";
		try {
			String time;
			FileReader fr = new FileReader("./patternset.txt");
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
			
			String[] theTime = new String[y];
						
			for(int i=0; i<y; i++) {
				StringTokenizer st = new StringTokenizer(element.elementAt(i));
				int z=0; 
				while(st.hasMoreElements()) {
					String word1 = st.nextToken();
					theTime[i] = word1;
					z++;
				}
			}
			String allTime[] = new String[y];
			
			for(int i=0; i<y; i++) {
							
				time = theTime[i];					
					
				allTime[i] = "Time ID: " + (i + 1) +
							"\nTime: " + time + "\n\n";
					
				 line2 += allTime[i];
			}
		}
		catch(Exception E) {
			
		}
		return line2;
	}
}