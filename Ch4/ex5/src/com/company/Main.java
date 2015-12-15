package com.company;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
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
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    Checker checker1 = new Checker(new Queue(15));

        checker1.checkIn(33);
        checker1.checkIn(66);
        checker1.checkIn(99);
        checker1.checkIn(30);
        checker1.checkIn(60);
        checker1.checkIn(90);

        checker1.checkOut();
        checker1.checkOut();
        checker1.checkOut();

        checker1.showQueue();

    }
}
