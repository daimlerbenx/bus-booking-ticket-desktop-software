import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteLine {
	public void deleteLine(String theFile, String lineToDel) {
		
		try {
			File inFile = new File(theFile);
			if(!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}
			
			File tmpFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader (new FileReader("./StaffList.txt"));
			PrintWriter pw = new PrintWriter (new FileWriter(tmpFile));
			String line;
			
			
			while((line = br.readLine()) != null) {
				if(!line.trim().equals(lineToDel)) {
					pw.println(line);
					
				}
			}
			pw.flush();
			pw.close();
			br.close();
			
			//Delete the original file
			if(!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			if(!tmpFile.renameTo(inFile)) {
				System.out.println("Could not rename file");
				
			}
		}
		catch(IOException e) {
			
		}
	}
	
	public void deleteTime(String theFile, String lineToDel) {
		
		try {
			File inFile = new File(theFile);
			if(!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}
			
			File tmpFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader (new FileReader("./patternset.txt"));
			PrintWriter pw = new PrintWriter (new FileWriter(tmpFile));
			String line;
			
			
			while((line = br.readLine()) != null) {
				if(!line.trim().equals(lineToDel)) {
					pw.println(line);
					
				}
			}
			pw.flush();
			pw.close();
			br.close();
			
			
			if(!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			
			if(!tmpFile.renameTo(inFile)) {
				System.out.println("Could not rename file");
				
			}
			
			
		}
		catch(IOException e) {
			
		}
	}
	
	public void deleteRoute(String theFile, String lineToDel) {
		
		try {
			File inFile = new File(theFile);
			if(!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}
			
			
			File tmpFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader (new FileReader("./patternplace.txt"));
			PrintWriter pw = new PrintWriter (new FileWriter(tmpFile));
			String line;
			
			
			
			while((line = br.readLine()) != null) {
				if(!line.trim().equals(lineToDel)) {
					pw.println(line);
					
				}
			}
			pw.flush();
			pw.close();
			br.close();
			
			
			if(!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			
			if(!tmpFile.renameTo(inFile)) {
				System.out.println("Could not rename file");
				
			}
			
			
		}
		catch(IOException e) {
			
		}
	}
}
