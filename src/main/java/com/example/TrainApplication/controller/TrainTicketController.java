package com.example.TrainApplication.controller;

 
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.TrainApplication.entity.*;
import com.example.TrainApplication.service.TrainTicketService;


@RestController
@RequestMapping("/api/train-tickets")
public class TrainTicketController {

    @Autowired
    private TrainTicketService trainTicketService;

    @PostMapping("/purchase")
    public ResponseEntity<TicketRequest> purchaseTicket(@RequestBody TicketRequest ticketRequest) {
        User user = new User();
        user.setEmail(ticketRequest.getUser().getEmail());
        user.setFirstName(ticketRequest.getUser().getFirstName());
        user.setLastName(ticketRequest.getUser().getLastName());

        TicketRequest purchasedTicket = trainTicketService.purchaseTicket(
                user,
                ticketRequest.getFrom(),
                ticketRequest.getTo(),
                ticketRequest.getPricePaid(),
                ticketRequest.getSeatSection()
        );
        return ResponseEntity.ok(purchasedTicket);
    }

    @GetMapping("/receipt/{userEmail}")
    public ResponseEntity<TicketRequest> getReceipt(@PathVariable String userEmail) {
        TicketRequest receipt = trainTicketService.getTicketByUserEmail(userEmail);
        if (receipt != null) {
            return ResponseEntity.ok(receipt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{section}")
    public ResponseEntity<Map<String, String>> getUsersAndSeats(@PathVariable String section) {
        Map<String, String> userSeatMap = trainTicketService.getUsersAndSeatsBySection(section);
        return ResponseEntity.ok(userSeatMap);
    }

    @DeleteMapping("/remove/{userEmail}")
    public ResponseEntity<Void> removeUser(@PathVariable String userEmail) {
        trainTicketService.removeUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modify-seat/{userEmail}")
    public ResponseEntity<Void> modifyUserSeat(@PathVariable String userEmail, @RequestParam String newSeatSection) {
        trainTicketService.modifyUserSeat(userEmail, newSeatSection);
        return ResponseEntity.noContent().build();
    }
}

