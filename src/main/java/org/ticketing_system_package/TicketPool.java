package org.ticketing_system_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketPool {
   private final static List<Integer> ticket_details_list = new ArrayList<Integer>();
   private final static List<Integer> ticket_details_thread_safe = Collections.synchronizedList(ticket_details_list);

   private final String[] ticket_details = new String[5];
   private String ticket_ID;
   private static int ticketCount = 0;
   private static int ticket_ID_number = 1;
   private static int totalTickets_count_for_ticketPool;
   private static int maxTicketsCapacity_for_ticketPool;
   boolean suspended;
   boolean stopped;
   private final Object thread_lock = new Object();

    public TicketPool(){
        suspended = false;
        stopped = false;
        Real_Time_Ticketing_System ticketing_system = new Real_Time_Ticketing_System("Overloaded constructor called");
        totalTickets_count_for_ticketPool = ticketing_system.getTotalTickets();
        maxTicketsCapacity_for_ticketPool = ticketing_system.getMaxTicketCapacity();

    }
    public TicketPool(String overloaded){

    }
    public List<Integer> get_ticketPool_for_booking(){
        return ticket_details_thread_safe;
    }
    public void get_tickets_details_list_print (){
        for (int i = 0; i < ticket_details_thread_safe.size(); i++) {
            System.out.println("sync_list_element: 20221603_" + ticket_details_thread_safe.get(i));
        }
    }

    public void addTickets(long t1){
        synchronized (thread_lock) {
            try {
                while (ticketCount >= totalTickets_count_for_ticketPool) {
                    System.out.println("waiting in the 58th line in TicketPool.....");
                    thread_lock.wait();
                }
                if (ticket_details_thread_safe.size() >= maxTicketsCapacity_for_ticketPool) {
                    System.out.println("totalTicket_count reached waiting (in TicketPool).....");
                    return;
                }
                ticket_details_thread_safe.add(ticketCount);
                ticketCount += 1;
                thread_lock.notifyAll();
            } catch (InterruptedException e1) {
                System.out.println(".....Ticket Adding Interrupted.....");
            }
        }
    }
    public void removeTicket(int ticket_ID_toRemove){
        synchronized (thread_lock) {
            try {
                while (ticket_details_thread_safe.isEmpty()) {
                    System.out.println(".....Tickets are Out of Stock.....");
                    thread_lock.wait();
                }
                if (ticket_details_thread_safe.remove(Integer.valueOf(ticket_ID_toRemove))) {
                    System.out.println("Ticket" + ticket_ID + " booked successfully");
                }
                else{
                    System.out.println("Ticket" + ticket_ID +"was not found");
                }
                thread_lock.notifyAll();
            } catch (InterruptedException e1) {
                System.out.println(".....Ticket Selling Interrupted.....");
                Thread.currentThread().interrupt();
            }
        }
            suspended = true;
            notifyAll();
    }
}
