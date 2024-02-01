package com.example.TrainApplication.entity;

public class TicketRequest {

	private String from;
    private String to;
    private User user;
    private double pricePaid;
    private String seatSection;
    private boolean seatAssigned;
     
	public TicketRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	public String getSeatSection() {
		return seatSection;
	}
	public void setSeatSection(String seatSection) {
		this.seatSection = seatSection;
	}
	public boolean isSeatAssigned() {
		return seatAssigned;
	}
	public void setSeatAssigned(boolean seatAssigned) {
		this.seatAssigned = seatAssigned;
	}

	public TicketRequest(String from, String to, User user, double pricePaid, String seatSection,
			boolean seatAssigned) {
		super();
		this.from = from;
		this.to = to;
		this.user = user;
		this.pricePaid = pricePaid;
		this.seatSection = seatSection;
		this.seatAssigned = false;
	}
	
}
