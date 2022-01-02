import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

import java.text.NumberFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class TheStaffPage extends JFrame implements ActionListener,Printable{
	
	private Container contentPane;
	
	private JPanel panel1,panel2,panel3; 
	private JLabel[] label = new JLabel[20];
	private JTextField noticket, depdate, retdate, rnoticket, laluan, tstatus, tdatego, tdateback, ttimego, ttimeback, tmoney, tdatepay;
	private JTextArea tarea;
	private JButton search,bGoDate,bturnDate, btnLogout;
	private JButton confirm, back,print,done;
	private JRadioButton oneWay, twoWay;
	private JComboBox<String> destinationDpt, timeDpt, timeRtn;
	
	private String oneWayStr = "One Way";
	private String twoWayStr = "Two Way";
	private String[] timeset = new String[12]; 
	private String[] placeset = new String[12];
	
	public int print(Graphics grap, PageFormat format, int pages) throws PrinterException {
		if (pages > 0){
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2d = (Graphics2D)grap;
		g2d.translate(format.getImageableX(),format.getImageableY()-55);
		
		tarea.print(grap);
		return 0;
	} 
	
	public void readfile() {
	
		File file = new File("patternset.txt");
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
			for(int i=0; i<element.size(); i++) {
				timeset[i] = element.elementAt(i);
			}
			
			br.close();
			fr.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readfile1() {
		
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
				placeset[i] = myRoute[i][0] + " - " + myRoute[i][1];
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public TheStaffPage(){
		
		//set frame
		setSize(810,600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Booking Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    
		contentPane = getContentPane();
		contentPane.setLayout(null);
		OrderBooking();
	}
	
	public void OrderBooking() {
		
		panel1 = new JPanel(null);
		oneWay = new JRadioButton(oneWayStr);
		oneWay.setMnemonic(KeyEvent.VK_O);
		oneWay.setActionCommand(oneWayStr);
		twoWay = new JRadioButton(twoWayStr);
		twoWay.setMnemonic(KeyEvent.VK_R);
		twoWay.setActionCommand(twoWayStr);
		ButtonGroup group = new ButtonGroup();
		group.add(oneWay);
		group.add(twoWay);
		
		Random rng = new Random();
		Font font = new Font("monospaced",Font.PLAIN,15);
		label[1] = new JLabel("Ticket Number ");
		noticket = new JTextField();
		noticket.setText(""+rng.nextInt(100000));
		
		readfile1();
		label[2] = new JLabel("Route");
		destinationDpt = new JComboBox<String>(placeset);
		label[4] = new JLabel("Departure Date");
		depdate = new JTextField(10);
		bGoDate = new JButton("Go");
		label[5] = new JLabel ("Return Date");
		retdate = new JTextField(10);
		bturnDate = new JButton("Go");

		readfile();
		label[6] = new JLabel("Departure Time");
		timeDpt = new JComboBox<String>(timeset);
		label[7] = new JLabel("Return Time");
		timeRtn = new JComboBox<String>(timeset);
	
		search = new JButton ("Search");
		btnLogout = new JButton("Back");
		
		label[1].setFont(font);
		noticket.setFont(font);
		label[2].setFont(font);
		destinationDpt.setFont(font);
		label[4].setFont(font);
		depdate.setFont(font);
		label[5].setFont(font);
		retdate.setFont(font);
		label[6].setFont(font);
		timeDpt.setFont(font);
		label[7].setFont(font);
		timeRtn.setFont(font);
		
		label[1].setVisible(false);
		noticket.setEditable(false);
		noticket.setVisible(false);
		depdate.setEditable(false);
		retdate.setEditable(false);
		timeDpt.setEnabled(false);
		timeRtn.setEnabled(false);
		
		contentPane.add(panel1);
		panel1.add(oneWay);
		panel1.add(twoWay);
		panel1.add(label[1]);
		panel1.add(noticket);
		panel1.add(label[2]);
		panel1.add(destinationDpt);
		panel1.add(label[4]);
		panel1.add(depdate);
		panel1.add(bGoDate);
		panel1.add(retdate);
		panel1.add(label[5]);
		panel1.add(bturnDate);
		panel1.add(label[6]);
		panel1.add(timeDpt);
		panel1.add(label[7]);
		panel1.add(timeRtn);
		panel1.add(search);
		panel1.add(btnLogout);
		
		panel1.setBounds(0, 0, 843, 740);
		oneWay.setBounds(300,40,85,25);
		twoWay.setBounds(450,40,85,25);
	    label[1].setBounds(20,100,200,25);
		noticket.setBounds(400,100,200,25);
		label[2].setBounds(230,150,150,25);
		destinationDpt.setBounds(400,150,250,25);
		label[4].setBounds(230,200,200,25);
		depdate.setBounds(400,200,150,25);
		bGoDate.setBounds(550,200,45,25);
		retdate.setBounds(400,250,150,25);
		label[5].setBounds(230,250,200,25);
		bturnDate.setBounds(550,250,45,25);
		label[6].setBounds(230,300,200,25);
		timeDpt.setBounds(400,300,200,25);
		label[7].setBounds(230,350,200,25);
		timeRtn.setBounds(400,350,200,25);
		search.setBounds(450,500,85,40);
		search.setForeground(Color.white);
		search.setBackground(Color.black);
		btnLogout.setBounds(300,500,85,40);
		btnLogout.setForeground(Color.white);
		btnLogout.setBackground(Color.orange);
		
		depdate.addActionListener(this);
		bGoDate.addActionListener(this);
		retdate.addActionListener(this);
		bturnDate.addActionListener(this);
		timeDpt.addActionListener(this);
		search.addActionListener(this);
		btnLogout.addActionListener(this);
		oneWay.addActionListener(this);
		twoWay.addActionListener(this);
		destinationDpt.addActionListener(this);
		
	}
	public void confimationBooking() {
		
		GregorianCalendar calen = new GregorianCalendar(); 
        int day = calen.get(GregorianCalendar.DAY_OF_MONTH);
        int month = calen.get(GregorianCalendar.MONTH);
        int year = calen.get(GregorianCalendar.YEAR);
        setTitle("Confirmation Ticket Page");

		panel2 = new JPanel(null);
		
		label[8] = new JLabel("Ticket Number");
		rnoticket = new JTextField();
		label[9] = new JLabel("Route");
		laluan = new JTextField(10);
		label[10] = new JLabel("Status  ");
		tstatus = new JTextField(10);
		label[11] = new JLabel("Date");
		tdatego = new JTextField(10);
		label[12] = new JLabel("Date Return");
		tdateback = new JTextField(10);
		label[13] = new JLabel("Time");
		ttimego = new JTextField(10);
		label[14] = new JLabel("Time Return");
		ttimeback = new JTextField(10);
		label[15] = new JLabel("Amount: RM");
		tmoney = new JTextField(10);
		label[16] = new JLabel("Date Payment");
		tdatepay = new JTextField();
		tdatepay.setText(""+day+"/"+month+"/"+year);
		back = new JButton ("Back");
		confirm = new JButton ("Confirm");
		
		label[8].setVisible(false);
		rnoticket.setEditable(false);
		rnoticket.setVisible(false);
		laluan.setEditable(false);
		tstatus.setEditable(false);
		tdatego.setEditable(false);
		tdateback.setEditable(false);
		ttimego.setEditable(false);
		ttimeback.setEditable(false);
		tdatepay.setEditable(false);
		tmoney.setEditable(false);
		
		Font font = new Font("monospaced",Font.PLAIN,15);
		label[8].setFont(font);
		rnoticket.setFont(font);
		label[9].setFont(font);
		laluan.setFont(font);
		label[10].setFont(font);
		tstatus.setFont(font);
		label[11].setFont(font);
		tdatego.setFont(font);
		label[12].setFont(font);
		tdateback.setFont(font);
		label[13].setFont(font);
		ttimego.setFont(font);
		label[14].setFont(font);
		ttimeback.setFont(font);
		label[15].setFont(font);
		tmoney.setFont(font);
		label[16].setFont(font);
		tdatepay.setFont(font);
		
		contentPane.add(panel2);
		panel2.add(label[8]);
		panel2.add(rnoticket);
		panel2.add(label[9]);
		panel2.add(laluan);
		panel2.add(label[10]);
		panel2.add(tstatus);
		panel2.add(label[11]);
		panel2.add(tdatego);
		panel2.add(label[12]);
		panel2.add(tdateback);
		panel2.add(label[13]);
		panel2.add(ttimego);
		panel2.add(label[15]);
		panel2.add(tmoney);
		panel2.add(label[16]);
		panel2.add(tdatepay);
		panel2.add(label[14]);
		panel2.add(ttimeback);
		panel2.add(confirm);
		panel2.add(back);
		
		panel2.setBounds(0, 0, 843, 740);
		label[8].setBounds(20,50,200,25);
		rnoticket.setBounds(200,50,200,25);
		label[9].setBounds(250,50,150,25);
		laluan.setBounds(400,50,250,25);
		label[10].setBounds(250,100,200,25);
		tstatus.setBounds(400,100,250,25);
		label[11].setBounds(250,150,200,25);
		tdatego.setBounds(400,150,250,25);
		label[12].setBounds(250,200,200,25);
		tdateback.setBounds(400,200,250,25);
		label[13].setBounds(250,250,200,25);
		ttimego.setBounds(400,250,250,25);
		label[14].setBounds(250,300,200,25);
		ttimeback.setBounds(400,300,250,25);
		label[15].setBounds(250,350,200,25);
		tmoney.setBounds(400,350,250,25);
		label[16].setBounds(250,400,200,25);
		tdatepay.setBounds(400,400,250,25);
		back.setBounds(300,500,100,25);
		back.setForeground(Color.white);
		back.setBackground(Color.orange);
		confirm.setBounds(450,500,100,25);
		confirm.setForeground(Color.white);
		confirm.setBackground(Color.black);
	
		back.addActionListener(this);
		confirm.addActionListener(this);
		laluan.addActionListener(this);
		
	}
	public void ticketPrint(){//double check
		
		setTitle("Ticket information");
		Font font = new Font("monospaced",Font.PLAIN,15);
		panel3 = new JPanel(null);
		
		tarea = new JTextArea ();
		tarea.setFont(font);
		print = new JButton("Print");
		print.setFont(font);
		done = new JButton("Done");
		done.setFont(font);
		
		contentPane.add(panel3);
		
		panel3.add(tarea);
		panel3.add(print);
		panel3.add(done);
	
		panel3.setBounds(0, 0, 843, 740);
		tarea.setBounds(250,50,350,350);
		done.setBounds(450,450,100,25);
		done.setForeground(Color.white);
		done.setBackground(Color.black);
		print.setBounds(300,450,100,25);
		print.setForeground(Color.black);
		print.setBackground(Color.white);
		
		done.addActionListener(this);
		print.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a) {
		String route = null;
		String dateDpt = null;
		String dateRtn = null;
		String ggtime;
		String rrtime;
		int noTicket = 0;
		double price = 0;
		Calculation calculate = new Calculation();
		Manipulate max = new Manipulate();
		noTicket = Integer.parseInt(noticket.getText());
		route = String.valueOf(destinationDpt.getSelectedItem());
		ggtime = String.valueOf(timeDpt.getSelectedItem());
		rrtime = String.valueOf(timeRtn.getSelectedItem());
		dateDpt = String.valueOf(depdate.getText());
		dateRtn = String.valueOf(retdate.getText());
		max.createFolder(dateDpt,ggtime);
		max.createFolder(dateRtn,rrtime);
		int createdepart = max.countFile(dateDpt,ggtime);
		int createreturn = max.countFile(dateRtn,rrtime);
		 
		if(a.getSource() == btnLogout) {
				JOptionPane.showMessageDialog(TheStaffPage.this,
	                    "Back to Staff Home Page",
	                    "Returning",
	                    JOptionPane.PLAIN_MESSAGE);
				dispose();
			}  
		if(a.getSource()==oneWay) {
					bGoDate.setEnabled(true);
					bturnDate.setEnabled(false);
			 		retdate.setEnabled(false);
					timeDpt.setEnabled(true);
					timeRtn.setEnabled(false);
			} 
		if(a.getSource()==twoWay) {
					bGoDate.setEnabled(true);
					bturnDate.setEnabled(true);
					timeDpt.setEnabled(true);
					timeRtn.setEnabled(true);
			}  
		if (a.getSource()==bGoDate){
			final JFrame f = new JFrame();
			depdate.setText(new DatePicker(f).setPickedDate());
		} 
		if (a.getSource()==bturnDate){
			final JFrame f = new JFrame();
			retdate.setText(new DatePicker(f).setPickedDate());
		} 
		if(a.getSource()==back){
			remove(panel2);
			OrderBooking();
		} 
		if (a.getSource()== done){
			remove(panel3);
			OrderBooking();
		} 
		if (a.getSource()==print){
			 PrinterJob job = PrinterJob.getPrinterJob();
			 job.setPrintable(this);
			 boolean ok = job.printDialog();
			 if (ok){
				 try{
					 job.print();
				 }catch(PrinterException ex){ 
				 }
			 }
		} 
		try{
			if (a.getSource()==search){
				
				if (oneWay.isSelected()){
					if(dateDpt.trim().isEmpty()){
						JOptionPane.showMessageDialog(this, "Select Date","ERROR",JOptionPane.WARNING_MESSAGE);
					}
					else{
						if (createdepart<=30){
							remove(panel1);
							confimationBooking();
							price = 1 * calculate.getPrice(route);
							tstatus.setText("One Way");
							laluan.setText(route);
							ttimego.setText(""+ggtime);
							tmoney.setText(""+price);
							tdatego.setText(dateDpt);
							tdateback.setText(dateRtn);
							rnoticket.setText(""+noTicket);	
						}else{
							JOptionPane.showMessageDialog(this, "No Vacancy","ERROR",JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				else if(twoWay.isSelected()){
					if(dateDpt.trim().isEmpty()){
						JOptionPane.showMessageDialog(this, "Select Departure Date","ERROR",JOptionPane.WARNING_MESSAGE);
					}
					else if (dateRtn.trim().isEmpty()){
						JOptionPane.showMessageDialog(this, "Select Return Date","ERROR",JOptionPane.WARNING_MESSAGE);
					}
					else {
						remove(panel1);
						confimationBooking();
						if (createdepart <=30 && createreturn <30){
							price = 2 * calculate.getPrice(route);
							tstatus.setText("Return");
							laluan.setText(route);
							ttimego.setText(""+ggtime);
							tmoney.setText(""+price);
							ttimeback.setText(""+rrtime);
							tdatego.setText(dateDpt);
							tdateback.setText(dateRtn);
							rnoticket.setText(""+noTicket);		
							}
					}
				}else
					JOptionPane.showMessageDialog(this, "Select Depature","ERROR",JOptionPane.WARNING_MESSAGE);
			
			} 
		 
			if (a.getSource()==confirm){
				ggtime = String.valueOf(ttimego.getText());
				rrtime = String.valueOf(ttimeback.getText());
				route = String.valueOf(laluan.getText());
				dateDpt = String.valueOf(tdatego.getText());
				dateRtn = String.valueOf(tdateback.getText());
				noTicket = Integer.parseInt(rnoticket.getText());
				price = Double.parseDouble(tmoney.getText());
				 
				Information get = new Information();
				get.setDestination(route);
				get.setDateGo(dateDpt);
				get.setDateReturn(dateRtn);
				get.setTimeGo(""+ggtime);
				get.setTimeReturn(""+rrtime);
				get.setTicketNo(noTicket);
				get.setPrice(price);
			
				remove(panel2);
				ticketPrint();
			
				tarea.setText(get.ticketDisplayReturn());
				//writes to database
				Manipulate write = new Manipulate();
				write.createFolder(dateDpt,ggtime);
				write.file(""+noTicket,tarea.getText());
				write.createFolder(dateRtn,rrtime);
				write.file(""+noTicket,tarea.getText());
			
			} 
			validate();
			repaint();
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "error","ERROR",JOptionPane.WARNING_MESSAGE);
			}catch( Exception e){
				JOptionPane.showMessageDialog(null, "system error","ERROR",JOptionPane.WARNING_MESSAGE);
			}
	} 
}
