package com.company;

/**
 * Created by try on 24/12/15.
 */

public class Link
{
    public long dData;                 // data item
    public Link next;                  // next link in list
    public Link previous;              // previous link in list
    // -------------------------------------------------------------
    public Link(long d)                // constructor
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()          // display this link
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}  // end class Link
