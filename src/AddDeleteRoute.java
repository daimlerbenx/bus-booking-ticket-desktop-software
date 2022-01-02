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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class AddDeleteRoute extends JFrame implements ActionListener{

	private JLabel lblEnterRouteToAdd = new JLabel("Enter Route");
	private JLabel lblEnterRouteToDel = new JLabel("Enter Route ID");
	private JLabel lblEnterDepartFrom = new JLabel("Depart From");
	private JLabel lblEnterDepartTo = new JLabel("Depart To");
	private JLabel lblRoutePrice = new JLabel("Price(RM)");
	private JLabel lblRouteAvailable = new JLabel("Routes Available");

	private JTextField tfRouteIDToDel = new JTextField(20);
	private JTextField tfDepartFrom = new JTextField(10);
	private JTextField tfDepartTo = new JTextField(10);
	private JTextField tfRoutePrice = new JTextField(10);
	
	private JButton btnDel = new JButton("Delete Route");
	private JButton btnAdd = new JButton("Add Route");
	private JButton btnPrevious = new JButton("Back to Admin Page");
	private JButton btnConfirm = new JButton("Add Route");
	private JButton btnCancel = new JButton("Back");
	private JButton btnDeleteRoute = new JButton("Delete Route");
	private JButton btnBack = new JButton("Back");
	
	private JPanel mainPanel = new JPanel();
	private JPanel mainPanel1 = new JPanel();
	private JPanel mainPanel2 = new JPanel();
	private JPanel buttonPanel1 = new JPanel();
	private JPanel buttonPanel2 = new JPanel();
	private JPanel buttonPanel3 = new JPanel();
	
	private JTextArea taRoutesAvailable = new JTextArea(20,40);
	
	private JScrollPane spScroll = new JScrollPane(taRoutesAvailable);
	
	File file = new File("./patternplace.txt");
	
	public AddDeleteRoute() {
		setSize(810,600);
	    setLocationRelativeTo(null);
	    setTitle("Route Homepage");
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    setMyFont();
	    createGUI();
	}
	public void setMyFont() {
		Font myFont = new Font("monospaced" , Font.CENTER_BASELINE , 15);
		Font myFont1 = new Font("tahoma" , Font.PLAIN , 17);
		
		btnDel.setFont(myFont);
		btnDel.setForeground(Color.black);
		btnDel.setBackground(Color.white);
		btnAdd.setFont(myFont);
		btnAdd.setForeground(Color.black);
		btnAdd.setBackground(Color.white);
		btnPrevious.setFont(myFont);
		btnPrevious.setForeground(Color.black);
		btnPrevious.setBackground(Color.orange);
		btnConfirm.setFont(myFont);
		btnConfirm.setForeground(Color.black);
		btnConfirm.setBackground(Color.white);
		btnCancel.setFont(myFont);
		btnCancel.setForeground(Color.black);
		btnCancel.setBackground(Color.orange);
		btnDeleteRoute.setFont(myFont);
		btnBack.setFont(myFont);
		lblEnterRouteToDel.setFont(myFont);
		lblEnterRouteToAdd.setFont(myFont1);
		lblEnterDepartFrom.setFont(myFont);
		lblEnterDepartTo.setFont(myFont);
		lblRoutePrice.setFont(myFont);
		lblRouteAvailable.setFont(myFont1);
	}
	private void createGUI() {
		
		mainPanel.setLayout(null);
		mainPanel1.setLayout(null);
		mainPanel2.setLayout(null);
		
		mainPanel.add(btnAdd);
		mainPanel.add(btnDel);
		mainPanel.add(btnPrevious);
		btnAdd.setBounds(280,140,250,50);
		btnDel.setBounds(280,220,250,50);
		btnPrevious.setBounds(280,300,250,50);
		
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
				
				setTitle("Add Route Page");
				
				mainPanel1.add(lblEnterRouteToAdd);
				
				mainPanel1.add(lblEnterDepartFrom);
				mainPanel1.add(tfDepartFrom);
				
				mainPanel1.add(lblEnterDepartTo);
				mainPanel1.add(tfDepartTo);
				
				mainPanel1.add(lblRoutePrice);
				mainPanel1.add(tfRoutePrice);
				
				mainPanel1.add(btnConfirm);
				mainPanel1.add(btnCancel);
			
				lblEnterRouteToAdd.setBounds(375,60,150,30);
				
				lblEnterDepartFrom.setBounds(290,150,150,30); //depart from text
				tfDepartFrom.setBounds(420,150,130,30); //depart box
				
				lblEnterDepartTo.setBounds(290,200,150,30); //depart to text
				tfDepartTo.setBounds(420,200,130,30); //depart to box
				
				lblRoutePrice.setBounds(290,250,150,30); //route price text
				tfRoutePrice.setBounds(420,250,130,30); //route price box
				
				btnConfirm.setBounds(430,340,120,30); //add route button
				btnCancel.setBounds(290,340,130,30); //back button
			
				btnConfirm.addActionListener(this);
				btnCancel.addActionListener(this);
						
				add(mainPanel1);
	
			}catch(Exception E) {
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == btnDel) {
			try {
				mainPanel.setVisible(false);
				mainPanel2.setVisible(true);
				
				setTitle("Delete Route Page");
				Admin myAdmin = new Admin();
				spScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				
				if(taRoutesAvailable!=null) {
					taRoutesAvailable.setText(null);
					taRoutesAvailable.append(myAdmin.displayRoutesAvailable());
	    		}
				
				mainPanel2.add(lblRouteAvailable);
				mainPanel2.add(spScroll);
				mainPanel2.add(lblEnterRouteToDel);
				mainPanel2.add(tfRouteIDToDel);
				mainPanel2.add(btnDeleteRoute);
				mainPanel2.add(btnBack);
				
				taRoutesAvailable.setEditable(false);
				
				lblRouteAvailable.setBounds(350,60,150,30); //route available text
				spScroll.setBounds(280,100,280,280); //information/ scroll interface
				lblEnterRouteToDel.setBounds(300,400,170,30); //route ID text
				tfRouteIDToDel.setBounds(440,400,90,30); //route ID box 
				btnDeleteRoute.setBounds(410,460,150,30); //confirm delete route button
				btnDeleteRoute.setForeground(Color.black);
				btnDeleteRoute.setBackground(Color.white);
				btnBack.setBounds(280,460,100,30); //back button in delete route page
				btnBack.setForeground(Color.black);
				btnBack.setBackground(Color.orange);
				
				btnBack.addActionListener(this);
				btnDeleteRoute.addActionListener(this);
				
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
			setTitle("Route Homepage");
		}
		if(e.getSource()==btnDeleteRoute) {
			
			try {
				Admin myAdmin = new Admin();
				int routeID = Integer.parseInt(tfRouteIDToDel.getText()); 
				
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
				String routeToDel = "";
				DeleteLine dl = new DeleteLine();
				for(int i=0; i<y; i++) {
					if(routeID == (i + 1)) {
						routeToDel = routeInfo[i][0] + " " + routeInfo[i][1]+ " " + routeInfo[i][2];
						dl.deleteRoute("./patternplace.txt", routeToDel);
					}	
				}
				JOptionPane.showMessageDialog(null, "Route Deleted", "Deletion Successful", JOptionPane.PLAIN_MESSAGE);
				tfRouteIDToDel.setText(null);
				if(taRoutesAvailable!=null) {
					taRoutesAvailable.setText(null);
					taRoutesAvailable.append(myAdmin.displayRoutesAvailable());
	    		}
			}
			catch(Exception E) {
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==btnConfirm){
			
			String departFrom = tfDepartFrom.getText();
			String departTo = tfDepartTo.getText();
			String routePrice = tfRoutePrice.getText();
			try {
				FileWriter writer = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(writer);
				
				FileReader reader = new FileReader("./patternplace.txt");
				BufferedReader br = new BufferedReader(reader);
				Vector<String>element = new Vector<String>();
				
				String line;
				int totalRouteAvailable = 0;
				String patternPlaceInfo = departFrom + " " + departTo + " " + routePrice;
				boolean proceed = true;
				
				while((line = br.readLine()) != null) {
					element.addElement(line);
					if(line.equals(patternPlaceInfo)) {
						proceed = false;
					}
					totalRouteAvailable++;
				}
				if(totalRouteAvailable < 12) {
					if(!proceed) {
						JOptionPane.showMessageDialog(null, departFrom + " - " + departTo + " has already existed", "ERROR",JOptionPane.ERROR_MESSAGE);
						tfDepartFrom.setText(null);
						tfDepartTo.setText(null);
						tfRoutePrice.setText(null);
						
					}
					else {
						writer.write(patternPlaceInfo + "\n");
						JOptionPane.showMessageDialog(null, departFrom + " - " + departTo + " has been added", "ROUTE UPDATE SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
						tfDepartFrom.setText(null);
						tfDepartTo.setText(null);
						tfRoutePrice.setText(null);
					}
				}
				else {
					System.out.println("error");
					JOptionPane.showMessageDialog(null, "Total Time Added has reached its limit", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				writer.flush();
				writer.close();
				br.close();
				bw.close();
				reader.close();
			}
			catch(Exception E) {
				JOptionPane.showMessageDialog(null, "Cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==btnCancel) {
			mainPanel1.setVisible(false);
			mainPanel.setVisible(true);
			setTitle("Time Homepage");
		}
	}
}