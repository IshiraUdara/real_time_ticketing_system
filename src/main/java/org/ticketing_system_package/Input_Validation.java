package org.ticketing_system_package;

public class Input_Validation extends Exception{
    @Override
    public String getMessage() {
        return "\nUnexpected Error occurred\n\n\n ";
    }
    public static String totTickets_Validate(){
        return "Invalid value for setup the total number of tickets!!!";
    }
    public static String releaseRate_Validate(){
        return "Invalid value for setup the ticket release rate!!!";
    }
    public static String retrievalRate_Validate(){
        return "Invalid value for setup the customer retrieval rate!!!";
    }
    public static String ticketCapacity_Validate(){
        return "Invalid value for setup the maximum ticket capacity!!!";
    }
}
