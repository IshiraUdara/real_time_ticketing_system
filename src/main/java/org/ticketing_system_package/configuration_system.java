package org.ticketing_system_package;

import java.io.*;

public class configuration_system implements Serializable {
    public configuration_system(){
        Real_Time_Ticketing_System ticketing_system_config = new Real_Time_Ticketing_System("Overloaded constructor called");
        int maxTicketCapacity_saved = ticketing_system_config.getMaxTicketCapacity();
        int ticketReleaseRate_saved = ticketing_system_config.getTicketReleaseRate();
        int customerRetrievalRate_saved = ticketing_system_config.getCustomerRetrievalRate();
        int totalTickets_saved = ticketing_system_config.getTotalTickets();
    }





}
