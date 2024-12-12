package org.ticketing_system_package;

import java.io.Serializable;
import java.util.Random;

public class Customer extends StakeHolder implements Serializable {

    private TicketPool tickets = new TicketPool();
    private int randomly_selected_ticket;
    public boolean canProceed = true;
    public Customer(TicketPool tickets) {
        this.tickets = tickets;
    }
    public Customer(String overload){
        Random random_ticket = new Random();
        randomly_selected_ticket = (tickets.get_ticketPool_for_booking().get(random_ticket.nextInt(tickets.get_ticketPool_for_booking().size())));
    }
    @Override
    public void run() {
        synchronized (tickets) {
            if (!tickets.get_ticketPool_for_booking().isEmpty()) {
                try{
                super.run();
                Customer customer_object = new Customer("Overloaded constructor called");
                System.out.println("Selected ticket for customer: " + customer_object.randomly_selected_ticket);
                tickets.removeTicket(customer_object.randomly_selected_ticket);
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("Error selecting ticket");
                }
            } else {
                System.out.println("Out of ticket, try again later");
            }
        }
    }
}
