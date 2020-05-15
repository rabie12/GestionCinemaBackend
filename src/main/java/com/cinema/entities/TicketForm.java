package com.cinema.entities;



import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TicketForm{
	private String nomClient;
	private Long codePayment;
	private List<Long> tickets= new ArrayList<>();
	
}