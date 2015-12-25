package com.company;

/**
 * Created by try on 25/12/15.
 */
public class Link {

    public long dData;
    public Link next;
    public Link(long dData) {
        this.dData = dData;
    }

    @Override
    public String toString() {
        return "" + dData;
    }

}
