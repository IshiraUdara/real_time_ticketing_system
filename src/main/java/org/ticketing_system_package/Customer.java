package org.ticketing_system_package;

public class Customer extends StakeHolder {

    public Customer(){
        System.out.println("Subclass system is working... (Now in the child class)");
        System.out.println("requesting superclass variables " + getTotal_tickets() + " " + getCustomer_retrieval_rate() + " " + getTicket_release_rate());
    }
}
