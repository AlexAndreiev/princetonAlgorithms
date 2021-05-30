package com.alex.andreiev.bouncingBalls;

// conventions
// neither ball null -> ball-ball collision
// one ball null -> ball-wall collision
// both balls null -> redraw event

public class Event implements Comparable<Event>{

    public double time;    // time of event
    public Ball a, b;      // particles involved in event
    private int countA, countB; // collision counts for a and b

    public Event(double t, Ball a, Ball b){
        // create event
    }

    public int compareTo(Event that){   // ordered by time
        return (int) (this.time - that.time);
    }

    public boolean isValid(){
        // invalid if intervening collision
    }
}
