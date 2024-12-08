package org.ticketing_system_package;

public class Vendor extends StakeHolder {

    private static int vendor_total_tickets = 0;
    public Vendor () throws InterruptedException{

    }

    public static int getVendor_total_tickets() {
        return vendor_total_tickets;
    }
}
