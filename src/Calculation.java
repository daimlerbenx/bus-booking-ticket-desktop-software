import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Calculation {
	
	
	public double getPrice(String place) {
		double myPrice = 0.0;
		
		File file = new File("patternplace.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			Vector<String>element = new Vector<String>();
			
			String line;
			
			int y=0;
			
			while((line = br.readLine()) != null) {
				element.addElement(line);
				y++;
			}
			br.close();
			String[][] myRoute = new String[y][3];
			
			for(int i=0; i<y; i++) {
				StringTokenizer st = new StringTokenizer(element.elementAt(i));
				int z=0; 
				while(st.hasMoreElements()) {
					String word1 = st.nextToken();
					myRoute[i][z] = word1;
					z++;
				}
			}
			
			for(int i=0; i<y; i++) {
				
				if(place.equalsIgnoreCase(myRoute[i][0] + " - " + myRoute[i][1]))
					myPrice = Double.parseDouble(myRoute[i][2]);
				
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return myPrice;
	}
}