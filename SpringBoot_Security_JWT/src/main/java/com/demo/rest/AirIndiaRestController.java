package com.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.request.PassengerInfo;
import com.demo.response.TicketInfo;

@RestController
public class AirIndiaRestController {

	@PostMapping("/bookFlightTicket")
	public ResponseEntity<TicketInfo> bookTicket(PassengerInfo pinfo){
		
		TicketInfo ticket=new TicketInfo();
		ticket.setName(pinfo.getFname()+" "+pinfo.getLname());
		ticket.setFrom(pinfo.getFrom());
		ticket.setTo(pinfo.getTo());
		ticket.setTicketStatus("CONFIRMED");
		ticket.setTicketPrice("8888.00 INR");
		ticket.setJourneyDate(pinfo.getJourneyDate());
		
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
}
