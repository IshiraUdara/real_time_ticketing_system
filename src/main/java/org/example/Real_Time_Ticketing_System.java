package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Real_Time_Ticketing_System {
    private static int totalTickets = 0;
    private static float ticketReleaseRate = 0.0f;
    private static float customerRetrievalRate = 0.0f;
    private static int maxTicketCapacity = 0;

    // Initial value assignment
    public Real_Time_Ticketing_System(){
        System.out.println(inputFromUser());
    }
    public void setTotalTickets (int ticket_count)
    {
        totalTickets = ticket_count;
    }
    public void setTicketReleaseRate (float releaseRate)
    {
        ticketReleaseRate = releaseRate;
    }
    public void setCustomerRetrievalRate (float retrievalRate)
    {
        customerRetrievalRate = retrievalRate;
    }
    public void setMaxTicketCapacity (int ticketCapacity)
    {
        maxTicketCapacity = ticketCapacity;
    }
    public String getTotalTickets ()
    {
        return "Total ticket count is: "+ totalTickets;
    }
    public String getTicketReleaseRate ()
    {
        return "Ticket release rate is: "+ ticketReleaseRate;
    }
    public String getCustomerRetrievalRate ()
    {
        return "Customer retrieval rate is: "+ customerRetrievalRate;
    }
    public String getMaxTicketCapacity ()
    {
        return "Max ticket capacity is: "+ maxTicketCapacity;
    }

    public String inputFromUser()
    {

        try {
            Scanner scanner_variable_totTickets = new Scanner(System.in);
            System.out.print("\nEnter total tickets count: ");
            totalTickets = scanner_variable_totTickets.nextInt();

            // String[] inputFromUser_array = inputFromUser_variable.split(" ");

            // throwing an error for testing purpose
//            throw new Input_Validation();
//        }
//        catch (Input_Validation testError){
//            System.out.println(testError.getMessage());
//        }
        }
        catch (InputMismatchException e1){
            System.out.println(Input_Validation.totTickets_Validate());
        }

        try {
            Scanner scanner_variable_releaseRate = new Scanner(System.in);
            System.out.print("\nEnter ticket release rate as a float value: ");
            ticketReleaseRate = scanner_variable_releaseRate.nextFloat();
        }
        catch (InputMismatchException e2){
            System.out.println(Input_Validation.releaseRate_Validate());
        }

        try {
            Scanner scanner_variable_retrievalRate = new Scanner(System.in);
            System.out.print("\nEnter customer release rate as a float value: ");
            customerRetrievalRate = scanner_variable_retrievalRate.nextFloat();
        }
        catch (InputMismatchException e3){
            System.out.println(Input_Validation.retrievalRate_Validate());
        }
        try {
            Scanner scanner_variable_ticketCapacity = new Scanner(System.in);
            System.out.print("\nEnter maximum ticket capacity: ");
            maxTicketCapacity = scanner_variable_ticketCapacity.nextInt();
        }
        catch (InputMismatchException e4){
            System.out.println(Input_Validation.ticketCapacity_Validate());
        }
        return "\nUser input function called...";
    }

}
