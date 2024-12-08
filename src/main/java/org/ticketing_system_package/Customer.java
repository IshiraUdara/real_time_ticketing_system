package org.ticketing_system_package;

public class Customer extends StakeHolder {

    private TicketPool tickets = new TicketPool();
    public Customer(){
        System.out.println("Subclass system is working... (Now in the Customer child class)");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Now in the Run function in customer child class");
        for (int i = 0; i<2;i++){
            tickets.removeTicket();
        }
    }
}
