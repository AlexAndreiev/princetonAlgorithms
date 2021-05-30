package com.alex.andreiev.bouncingBalls;

public class CollisionSystem {

    private MinPQ<Event> pq; //priority queue
    private double t = 0; // simulation clock time
    private Ball[] balls;   // the array of particles

    public CollisionSystem(Ball[] balls){}

    //add to PQ all ball-wall and ball-ball collisions involving this ball
    private void predict(Ball a){
        if (a == null) return;
        for (int i = 0; i < N; i++) {
            double dt = a.timeToHit(balls[i]);
            pq.insert(new Event(t + dt, a, balls[i]));
        }
        pq.insert(new Event(t + a.timeToHitVerticalWall(), a, null));
        pq.insert(new Event(t + a.timeToHitHorizontalWall(), null, a));
    }

    private void redraw(){}

    public void simulate(){
        // initialize PQ with collision events and redraw event
        pq = new MinPQ<Event>();
        for (int i = 0; i < N; i++)
            predict(balls[i]);
        pq.insert(new Event(0, null, null));

        while(!pq.isEmpty()){
            // get next event
            Event event = pq.delMin();
            if (!event.isValid())   continue;
            Ball a = event.a;
            Ball b = event.b;
            // update positions and time
            for (int i = 0; i < N; i++)
                balls[i].move(event.time - t);
            t = event.time;
            // process event
            if (a != null && b != null) a.bounceOff(b);
            else if (a != null && b == null) a.bounceOffVerticallWall();
            else if (a == null && b != null) a.bounceOffHorizontalWall();
            else if (a == null && b == null) redraw();
            // predict new events based on changes
            predict(a);
            predict(b);
        }
    }
}
