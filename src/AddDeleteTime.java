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

public class AddDeleteTime extends JFrame implements ActionListener{

	private String[] patternnumber = 
		{"1AM","2AM","3AM","4AM","5AM","6AM",
		"7AM","8AM","9AM","10AM","11AM","12PM",
		"1PM","2PM","3PM","4PM","5PM","6PM",
		"7PM","8PM","9PM","10PM","11PM","12AM"};
	
	private JComboBox<String> number = new JComboBox<String>(patternnumber);

	private JLabel lblTimeAvailable = new JLabel("TIME AVAILABLE");
	private JLabel lblEnterTimeToDel = new JLabel("Enter Time ID ");
	
	private JTextField tfTimeID = new JTextField(3);
	
	private JButton btnDel = new JButton("Delete Time");
	private JButton btnAdd = new JButton("Add Time");
	private JButton btnPrevious = new JButton("Back to Admin Page");
	private JButton btnConfirm = new JButton("Add Time");
	private JButton btnCancel = new JButton("Back");
	private JButton btnDeleteTime = new JButton("Delete Time");
	private JButton btnBack = new JButton("Back");
	
	private JPanel mainPanel = new JPanel();
	private JPanel mainPanel1 = new JPanel();
	private JPanel mainPanel2 = new JPanel();
	private JPanel buttonPanel3 = new JPanel();
	
	private JTextArea taTimeAvailable = new JTextArea(20, 20);
	private JTextArea taTimeAvailable1 = new JTextArea(20, 20);
	private JScrollPane spScroll = new JScrollPane(taTimeAvailable1);
	
	File file = new File("./patternset.txt");
	
	public AddDeleteTime() {
		setSize(810,600);
	    setLocationRelativeTo(null);
	    setTitle("Time Homepage");
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    setMyFont();
	    createGUI();
	}
	
	public void setMyFont() {
		Font myFont = new Font("tahoma", Font.PLAIN, 15);
		Font myFont1 = new Font("monospaced", Font.CENTER_BASELINE, 15);
		Font myFont2 = new Font("monospaced", Font.PLAIN, 12);
		
		btnDel.setFont(myFont1);
		btnAdd.setFont(myFont1);
		btnPrevious.setFont(myFont1);
		btnConfirm.setFont(myFont1);
		btnCancel.setFont(myFont1);
		btnDeleteTime.setFont(myFont1);
		btnBack.setFont(myFont1);
		lblTimeAvailable.setFont(myFont1);
		lblEnterTimeToDel.setFont(myFont);
		
	}
	
	private void createGUI() {
		
		mainPanel.setLayout(null);
		mainPanel1.setLayout(null);
		mainPanel2.setLayout(null);
		
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
		
		add(mainPanel);
		
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnPrevious.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAdd) {
			try {
				Admin myAdmin = new Admin();
				mainPanel.setVisible(false);
				mainPanel1.setVisible(true);
				
				setTitle("Add Time Page");
				
				if(taTimeAvailable1!=null) {
					taTimeAvailable1.setText(null);
					taTimeAvailable1.append(myAdmin.displayTimeAvailable());
	    		}
				mainPanel1.add(number);
				
				mainPanel1.add(btnConfirm);
				mainPanel1.add(btnCancel);
				mainPanel1.add(lblTimeAvailable);
				mainPanel1.add(spScroll);
				
				lblTimeAvailable.setBounds(380,40,150,30); //time available text
				spScroll.setBounds(330,140,230,300); //time available information
				number.setBounds(330,90,230,30);
				btnConfirm.setBounds(430,470,150,30);
				btnConfirm.setForeground(Color.black);
				btnConfirm.setBackground(Color.white);
				btnCancel.setBounds(300,470,100,30);
				btnCancel.setForeground(Color.black);
				btnCancel.setBackground(Color.orange);
				
				taTimeAvailable1.setEditable(false);
				
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
				
				setTitle("Delete Time Page");
				Admin myAdmin = new Admin();
				spScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				
				if(taTimeAvailable1!=null) {
					taTimeAvailable1.setText(null);
					taTimeAvailable1.append(myAdmin.displayTimeAvailable());
	    		}
				taTimeAvailable1.setEditable(false);
				mainPanel2.add(lblTimeAvailable);
				mainPanel2.add(spScroll);
				mainPanel2.add(lblEnterTimeToDel);
				mainPanel2.add(tfTimeID);
				mainPanel2.add(btnDeleteTime);
				mainPanel2.add(btnBack);
				
				taTimeAvailable1.setEditable(false);
				
				lblTimeAvailable.setBounds(390,40,150,30); //time available text
				spScroll.setBounds(310,100,280,280); //information available time 
				lblEnterTimeToDel.setBounds(330,400,150,30); //enter time ID text
				tfTimeID.setBounds(460,400,100,30); //time ID box
				btnDeleteTime.setBounds(440,460,150,30); //confirm delete button
				btnDeleteTime.setForeground(Color.black);
				btnDeleteTime.setBackground(Color.white);
				btnBack.setBounds(310,460,100,30); //back button in delete time page
				btnBack.setForeground(Color.black);
				btnBack.setBackground(Color.orange);
			
				btnBack.addActionListener(this);
				btnDeleteTime.addActionListener(this);
				
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
			setTitle("Time Homepage");
		}
		
		if(e.getSource()==btnDeleteTime) {
			try {
				Admin myAdmin = new Admin();
				int timeID = Integer.parseInt(tfTimeID.getText()); 
				
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
				String[] timeInfo = new String[y];
							
				for(int i=0; i<y; i++) {
					StringTokenizer st = new StringTokenizer(element.elementAt(i));
					int z=0; 
					while(st.hasMoreElements()) {
						String word1 = st.nextToken();
						timeInfo[i] = word1;
						z++;
					}
				}
				
				String timeToDel = "";
				DeleteLine dl = new DeleteLine();
				for(int i=0; i<y; i++) {
					if(timeID == (i + 1)) {
						timeToDel = timeInfo[i];
						dl.deleteTime("./patternset.txt", timeToDel);
					}	
				}
				
				JOptionPane.showMessageDialog(null,
                        timeToDel + " Deleted",
                        "Deletion Successful",
                        JOptionPane.PLAIN_MESSAGE);
				
				tfTimeID.setText(null);
				if(taTimeAvailable1!=null) {
					taTimeAvailable1.setText(null);
					taTimeAvailable1.append(myAdmin.displayTimeAvailable());
	    		}
			}
			catch(Exception E) {
				JOptionPane.showMessageDialog(null, "You have entered the wrong data", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		
		}
		
		if(e.getSource()==btnConfirm){
			String time;
			try {
				Admin myAdmin = new Admin();
				FileWriter writer = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(writer);
				
				FileReader reader = new FileReader("./patternset.txt");
				BufferedReader br = new BufferedReader(reader);
				Vector<String>element = new Vector<String>();
				time = String.valueOf(number.getSelectedItem());
				
				String line;
				int totalTimeAvailable = 0;
				boolean proceed = true;
				while((line = br.readLine()) != null) {
					element.addElement(line);
					if(line.equals(time)) {
						proceed = false;
					}
					totalTimeAvailable++;
				}
				
				if(totalTimeAvailable < 12) {
					if(!proceed) {
						JOptionPane.showMessageDialog(null, time + " has already existed", "ERROR",JOptionPane.ERROR_MESSAGE);
						
					}else {
						
						writer.write(time + "\n");
						
						JOptionPane.showMessageDialog(null, time + " Added", "ADDED", JOptionPane.INFORMATION_MESSAGE);
						
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
				
				if(taTimeAvailable1!=null) {
					taTimeAvailable1.setText(null);
					taTimeAvailable1.append(myAdmin.displayTimeAvailable());
	    		}
				 
			}catch(Exception E) {
				JOptionPane.showMessageDialog(null, "Cannot be empty", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
	
		}
		else if(e.getSource()==btnCancel) {
			mainPanel1.setVisible(false);
			mainPanel.setVisible(true);
			setTitle("Add/Delete Time");
		}
		
	}
}
