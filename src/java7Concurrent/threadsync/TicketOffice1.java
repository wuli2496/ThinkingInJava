package java7Concurrent.threadsync;

public class TicketOffice1 implements Runnable {
	
	private Cinema cinema;
	
	public TicketOffice1(Cinema cinema) {
		// TODO Auto-generated constructor stub
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets2(2);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
	}

}
