package org.ticketing_system_package;

public class StakeHolder implements Runnable {
    private static float ticket_release_rate = 0;
    private static float customer_retrieval_rate = 0;
    private static int total_tickets = 0;

    @Override
    public void run() {

    }

    public StakeHolder(){
        Real_Time_Ticketing_System ticketing_system = new Real_Time_Ticketing_System("initial");
        this.ticket_release_rate = ticketing_system.getTicketReleaseRate();
        this.customer_retrieval_rate = ticketing_system.getCustomerRetrievalRate();
        this.total_tickets = ticketing_system.getTotalTickets();

    }

}
