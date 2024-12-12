# Ticketing System

## Overview

This is a Java-based real-time ticketing system that manages the sale and addition of tickets in a synchronized manner using multiple threads. It supports a multi-threaded environment where vendors add tickets to the pool, and customers request and book tickets. The system validates inputs and maintains proper synchronization to ensure the correct functioning of ticket sales and stock management.

## Key Features

- **Ticket Pool Management**: The system manages a pool of tickets, allowing customers to book tickets and vendors to add tickets dynamically.
- **Real-Time Ticketing**: Simultaneous ticket sales and ticket additions using multithreading.
- **Synchronization**: Uses Java's `synchronized` keyword and `wait`/`notifyAll` to ensure proper synchronization between customer and vendor threads.
- **User Input Validation**: Ensures the user inputs valid values for the total number of tickets, release rate, retrieval rate, and maximum ticket capacity.

## System Components

### 1. **StakeHolder Class**
   - A base class that implements the `Runnable` interface. It contains static variables for ticket release rate, customer retrieval rate, and total tickets.
   - Other classes (`Customer`, `Vendor`) inherit from this class and implement their specific behaviors.

### 2. **Customer Class**
   - Represents a customer who requests and books tickets from the `TicketPool`.
   - Implements the `run()` method to simulate the process of ticket booking by customers in a separate thread.

### 3. **Input_Validation Class**
   - A utility class for input validation, throwing custom error messages when invalid inputs are provided by the user for ticket count, release rate, retrieval rate, and ticket capacity.

### 4. **Real_Time_Ticketing_System Class**
   - The main class that initializes the system and sets configurations (total tickets, release rate, etc.).
   - Manages the interactions between customer and vendor threads and ensures synchronization during the ticket selling and adding processes.
   - Serializes configuration data to a file for future reference.

### 5. **TicketPool Class**
   - Manages the ticket pool, allowing tickets to be added by vendors and removed when booked by customers.
   - Ensures that the ticket pool respects the maximum capacity and total ticket count.

### 6. **Vendor Class**
   - Represents a vendor who adds tickets to the ticket pool.
   - Implements the `run()` method to simulate the process of adding tickets in a separate thread.

## Project Setup

### Prerequisites

- **Java 8 or higher**: Ensure you have Java installed on your system. You can check this by running:
  ```bash
  java -version
