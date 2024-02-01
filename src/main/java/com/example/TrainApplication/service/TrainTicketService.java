package com.example.TrainApplication.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.TrainApplication.entity.*;

	@Service
	public class TrainTicketService {

	    private Map<String, TicketRequest> ticketMap = new HashMap<>();


 public TicketRequest purchaseTicket(User user, String from, String to, double pricePaid, String seatSection) {
	        TicketRequest ticket = new TicketRequest();
	        ticket.setFrom(from);
	        ticket.setTo(to);
	        ticket.setUser(user);
	        ticket.setPricePaid(pricePaid);
	        ticket.setSeatSection(seatSection);	        
	        assignSeat(ticket);
	        ticketMap.put(user.getEmail(), ticket);
	        return ticket;
	    }
	    
	    private void assignSeat(TicketRequest ticket) {   
	        ticket.setSeatAssigned(true);
	        System.out.println("Seat assigned for you Successfully!!"); 
	    }

	    public TicketRequest getTicketByUserEmail(String userEmail) {
	        return ticketMap.get(userEmail);
	    }

	    public Map<String, String> getUsersAndSeatsBySection(String section) {
	        Map<String, String> userSeatMap = new HashMap<>();
	        for (Map.Entry<String, TicketRequest> entry : ticketMap.entrySet()) {
	            TicketRequest ticket = entry.getValue();
	            if (ticket.getSeatSection().equalsIgnoreCase(section)) {
	                User user = ticket.getUser();
	                String userName = user.getFirstName() + " " + user.getLastName();
	                userSeatMap.put(userName, ticket.getSeatSection());
	            }
	        }
	        return userSeatMap;
	    }

	    public void removeUser(String userEmail) {
	        ticketMap.remove(userEmail);
	        System.out.println("User Deleted Successfully!!"); 
	    }

	    public void modifyUserSeat(String userEmail, String newSeatSection) {
	        TicketRequest ticket = ticketMap.get(userEmail);
	        if (ticket != null) {
	            ticket.setSeatSection(newSeatSection);
	            ticketMap.put(userEmail, ticket);
	            System.out.println("User Seat Updated Successfully!!"); 
	        }
	    }
	}
	
    