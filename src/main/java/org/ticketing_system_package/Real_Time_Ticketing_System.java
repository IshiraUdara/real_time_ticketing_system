package org.ticketing_system_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Real_Time_Ticketing_System {
    private static int totalTickets = 0;
    private static int ticketReleaseRate = 0;
    private static int customerRetrievalRate = 0;
    private static int maxTicketCapacity = 0;

    // Initial value assignment
    public Real_Time_Ticketing_System() throws Exception{
        System.out.println(inputFromUser());
        selling_process();
        Customer c1 = new Customer();

        try {
            // serializable object calls which saving these user entered data (configuration data)
            configuration_system config_sys = new configuration_system();

            // creating a file to save that data
            File configuration_data_file = new File("configuration_data_file.txt");

            // Saving the data in byte format
            FileOutputStream configuration_data = new FileOutputStream(configuration_data_file,true);

            // serialization object
            ObjectOutputStream configuration_data_object = new ObjectOutputStream(configuration_data);

            // data serializing the data
            configuration_data_object.writeObject(config_sys);

            configuration_data.close();
        }
        catch (FileNotFoundException e1){
            System.out.println("File not found.......");
        }
    }
    public Real_Time_Ticketing_System(String constructor_overload){

    }
    public void setTotalTickets (int ticket_count)
    {
        totalTickets = ticket_count;
    }
    public void setTicketReleaseRate (int releaseRate)
    {
        ticketReleaseRate = releaseRate;
    }
    public void setCustomerRetrievalRate (int retrievalRate)
    {
        customerRetrievalRate = retrievalRate;
    }
    public void setMaxTicketCapacity (int ticketCapacity)
    {
        maxTicketCapacity = ticketCapacity;
    }
    public Integer getTotalTickets ()
    {
        return totalTickets;
    }
    public Integer getTicketReleaseRate ()
    {
        return ticketReleaseRate;
    }
    public Integer getCustomerRetrievalRate ()
    {
        return customerRetrievalRate;
    }
    public Integer getMaxTicketCapacity ()
    {
        return maxTicketCapacity;
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
            System.out.print("\nEnter ticket release rate (per second): ");
            ticketReleaseRate = scanner_variable_releaseRate.nextInt();
        }
        catch (InputMismatchException e2){
            System.out.println(Input_Validation.releaseRate_Validate());
        }

        try {
            Scanner scanner_variable_retrievalRate = new Scanner(System.in);
            System.out.print("\nEnter customer release rate (per second): ");
            customerRetrievalRate = scanner_variable_retrievalRate.nextInt();
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

    public void selling_process() throws InterruptedException{
        System.out.println("Testing timer delay");
        for (int x = 0 ; x <= 10; x++){
            System.out.println("Counting time "+ x);
            Thread.sleep(1000);
        }
    }

}
