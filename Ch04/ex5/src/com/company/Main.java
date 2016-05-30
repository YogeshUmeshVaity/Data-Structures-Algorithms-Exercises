package com.company;

import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class StoreController {

    /** Contains checkers */
    private List<Checker> checkersList = new ArrayList<>();
    private Random rnd = new Random();

    public StoreController() {
        Checker checker1 = new Checker(new Queue(15));
        Checker checker2 = new Checker(new Queue(15));
        Checker checker3 = new Checker(new Queue(15));
        checkersList.add(checker1);
        checkersList.add(checker2);
        checkersList.add(checker3);
    }

    /** Instructs costumer to join the smallest queue */
    public void checkInCustomer(long customerId) {
        Checker checker = findSmallestChecker();
        if(!checker.isFull()) {
            checker.checkIn(customerId);
        } else {
            System.out.println("All the checkers are full, please try after sometime.");
        }
    }

    /** Finds the smallest queue by iterating through the List */
    private Checker findSmallestChecker() {
        Checker returnableChecker = checkersList.get(0);
        for(int i = 1; i < checkersList.size(); i++) {
            Checker tempChecker = checkersList.get(i);
            int queueSize = tempChecker.getQueueSize();
            if(queueSize < returnableChecker.getQueueSize()) {
                returnableChecker = tempChecker;
            }
        }
        return returnableChecker;
    }

    /** Checks out a customer at each call, remove him from the list
     *  from a random Checker
     */
    public void checkOutCustomer() {
        int randomChecker = rnd.nextInt(checkersList.size());
        Checker checker = checkersList.get(randomChecker);
        if(!checker.isEmpty()) {
            checker.checkOut();
        } else {
            System.out.println("Checker" + randomChecker + " is empty");
        }
    }

    /**
     * Displays all the queues in all the checkers
     */
    public void showStoreStatus() {
        Iterator<Checker> it = checkersList.iterator();
        int counter = 1;
        for(Checker checker : checkersList) {
            System.out.print("Checker" + counter++ + " ");
            checker.showQueue();
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    StoreController sc = new StoreController();
        while (true) {
            System.out.println("Enter customerId to check in, " +
                    "o for check out, s for status, enter to exit : ");
            String input = getInput();
            // if the entered string is a customerId, checkIn
            if(input.matches("\\d+")) {
                sc.checkInCustomer(Integer.valueOf(input));
            } else if(input.equals("o")) {
                sc.checkOutCustomer();
            } else if(input.equals("s")) {
                sc.showStoreStatus();
            } else if(input.equals("")) {
                System.exit(0);
            }
        }
    }

    public static String getInput() {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String s;
        try {
            s = br.readLine();
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
        return s;
    }
}
