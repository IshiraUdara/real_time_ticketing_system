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
    boolean suspended;
    boolean stopped;
    TicketPool ticketPool = new TicketPool("overloaded constructor called");
    int current_ticket_count = 0;
    // Initial value assignment
    public Real_Time_Ticketing_System() throws Exception{

        suspended = false;
        stopped = false;

        System.out.println(inputFromUser());
        Thread main_customer_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    selling_process();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread main_vendor_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ticket_adding_process();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });
        main_vendor_thread.start();
        main_customer_thread.start();
        try {
            // serializable object calls which saving these user entered data (configuration data)
            configuration_system config_sys = new configuration_system();

            // creating a file to save that data
            File configuration_data_file = new File("configuration_data_file.txt");

            // Saving the data in byte format
            FileOutputStream configuration_data = new FileOutputStream(configuration_data_file,true);

            // serialization object
            ObjectOutputStream configuration_data_object = new ObjectOutputStream(configuration_data);

            // serializing the data
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
            System.out.print("\nEnter customer retrieval rate (per second): ");
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

    synchronized public void selling_process() throws InterruptedException{

        while (current_ticket_count < totalTickets) {

            for (int count = 0; count < customerRetrievalRate; count++) {
                Customer customer_object = new Customer(ticketPool);
                Thread thread_customer = new Thread(customer_object);
                thread_customer.start();
                suspended = true;
            }
            if (ticketPool.get_ticketPool_for_booking().isEmpty()) {
                break;
            }
            current_ticket_count -= customerRetrievalRate;
            Thread.sleep(1000);
            while (suspended) {
                wait();
            }
            suspended = true;
            notifyAll();

        }



    }
    public synchronized void ticket_adding_process() throws InterruptedException{
        while (current_ticket_count < totalTickets) {
            for (int i = 1; i <= 5; i++) {
                Vendor vendor_object = new Vendor();
                Thread thread_vendor = new Thread(vendor_object);
                thread_vendor.start();
                suspended = false;
            }
            current_ticket_count += customerRetrievalRate;
            Thread.sleep(1000);
        }
        while (!suspended) {
            wait();
        }
        suspended = false;
        notifyAll();
    }

}
