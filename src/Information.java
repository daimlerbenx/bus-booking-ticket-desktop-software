
public class Information {
	private String timeGo, timeReturn,returnDate,dateGoing,place;
	
	private int ticketNo;
	private double fare;

	public void setTicketNo(int noTicket){ //ticket object (ticket number, date, date go, date return, time go, time return)
		ticketNo = noTicket;
	}
	public int getTicketNo(){
		return ticketNo;
	}
	public void setDateGo(String date){
		dateGoing = date;
	}
	public String getDateGo(){
		return dateGoing;
	}
	public void setDateReturn(String date){
		returnDate = date;
	}
	public String getDateReturn(){
		return returnDate;
	}
	public void setTimeGo(String time){
		timeGo = time;
	}
	public String getTimeGo(){
		return timeGo;
	}
	public void setTimeReturn(String time){
		timeReturn = time;
	}
	public String getTimeReturn(){
		return timeReturn;
	}
	public void setDestination(String destination){
		place = destination;
	}
	public String getPlace(){
		return place;
	}
	public void setPrice(double price){
		fare = price;
	}
	public double getFare(){
		return fare;
	}
	public String ticketDisplayOneWay(){
		String ticket =
				"\tBus Reservation Express"
				 +"\r\n"
				 +"\r\nTicket Number: "+getTicketNo()
				 +"\r\nDestination:\t "+getPlace()
				 +"\r\nStatus:\t  One-Way"
				 +"\r\nDate:\t "+getDateGo()
				 +"\r\nTime:\t "+getTimeGo()
				 +"\r\nPrice:\t RM"+getFare()
				 +"\r\n";
		
		return ticket;
	}
	public String ticketDisplayReturn(){
		String ticket =
				"\tBus Reservation Express"
						 +"\r\n"
						 +"\r\nTicket Number:\t "+getTicketNo()
						 +"\r\nDestination:\t "+getPlace()
						 +"\r\nStatus:\t  Return"
						 +"\r\nDate:\t "+getDateGo()
						 +"\r\nTime:\t "+getTimeGo()
						 +"\r\nDate Return:\t "+getDateReturn()
						 +"\r\nTime Return:\t "+getTimeReturn()
						 +"\r\nPrice:\t RM"+getFare()	
						 +"\r\n";
		return ticket;
	}
}