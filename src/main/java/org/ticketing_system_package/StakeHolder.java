package org.ticketing_system_package;

public class StakeHolder {
    private static float ticket_release_rate = 0;
    private static float customer_retrieval_rate = 0;
    private static int total_tickets = 0;

    public StakeHolder(){
        Real_Time_Ticketing_System ticketing_system = new Real_Time_Ticketing_System("initial");
        ticket_release_rate = ticketing_system.getTicketReleaseRate();
        customer_retrieval_rate = ticketing_system.getCustomerRetrievalRate();
        total_tickets = ticketing_system.getTotalTickets();

        System.out.println("Subclass system is working... (Now in the parent class)");
    }

    public static int getTotal_tickets() {
        return total_tickets;
    }

    public static float getCustomer_retrieval_rate() {
        return customer_retrieval_rate;
    }

    public static float getTicket_release_rate() {
        return ticket_release_rate;
    }
}
