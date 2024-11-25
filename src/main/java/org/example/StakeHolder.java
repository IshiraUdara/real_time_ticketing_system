package org.example;

public class StakeHolder {
    private static float ticket_release_rate = 0;
    private static float customer_retrieval_rate = 0;
    private static int total_tickets = 0;

    public StakeHolder() throws InterruptedException{
        Real_Time_Ticketing_System ticketing_system = new Real_Time_Ticketing_System("initial");
        this.ticket_release_rate = ticketing_system.getTicketReleaseRate();
        this.customer_retrieval_rate = ticketing_system.getCustomerRetrievalRate();
        this.total_tickets = ticketing_system.getTotalTickets();

        System.out.println("Subclass system is working... (Now in the parent class)");
    }
}
