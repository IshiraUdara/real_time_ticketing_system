package org.ticketing_system_package;

public class Vendor extends StakeHolder {

    private static int vendor_total_tickets = 0;
    private TicketPool tickets = new TicketPool();
    public Vendor (){
        System.out.println("Subclass system is working... (Now in the Vendor child class)");

    }

    @Override
    public void run() {
        super.run();
        System.out.println("Now in the Run function in vendor child class");
        for (int i = 0; i < 5; i++){
            tickets.addTickets();
        }
    }
}
