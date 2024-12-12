package org.ticketing_system_package;

import java.io.Serializable;

public class Vendor extends StakeHolder implements Serializable {

    private static int vendor_total_tickets = 0;
    private TicketPool tickets = new TicketPool();
    Real_Time_Ticketing_System ticketing_system = new Real_Time_Ticketing_System("overloaded constructor called");
    public Vendor (){

    }

    @Override
    public void run(){
        super.run();

        if (vendor_total_tickets != ticketing_system.getTotalTickets()){
            vendor_total_tickets += 1;
            tickets.addTickets(Thread.currentThread().getId());
        }
    }
}
