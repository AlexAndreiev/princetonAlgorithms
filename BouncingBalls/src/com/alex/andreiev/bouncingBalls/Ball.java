package com.alex.andreiev.bouncingBalls;

public class Ball {

    private double rx, ry;  // position
    private double vx, vy;  // velocity
    private final double radius;    // radius
    private final double mass;  // mass
    private int count; // number of collisions

    public Ball(){
        /* initialize position and velocity */
    }

    public void move(double dt){
        if ((rx + vx*dt < radius) || (rx + vx*dt > 1.0 - radius)) {vx = -vx; } // check for collision with the walls
        if ((ry + vy*dt < radius) || (ry + vy*dt > 1.0 - radius)) {vy = -vy; } // check for collision with the walls
        rx = rx + vx*dt;
        ry = ry + vy*dt;
    }

    public void draw()
    {
        StrDraw.filledCircle(rx,ry, radius);
    }

    // predict collision with particle or wall
    public double timeToHit(Ball that){
        if (this == that) return INFINITY;
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx, dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy * dvy;
        if (dvdr > 0) return INFINITY;  // no collision
        double dvdv = dvx*dvx + dvy*dvy;
        double drdr = dx*dx + dy*dy;
        double sigma = this.radius + that.radius;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);
        if (d<0) return INFINITY;   // no collision
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }

    public double timeToHitVerticalWall(){
    }
    public double timeToHitHorizontalWall(){}

    // resolve collision with particle or wall
    public void bounceOff(Ball that){
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx, dvy = that.vy - this.vy;
        double dbdr = dx*dvx + dy*dvy;
        double dist = this.radius + that.radius;
        double j = 2 * this.mass * that.mass * dbdr / ((this.mass + that.mass) * dist);
        double jx = j*dx/dist;
        double jy = j*dy/dist;
        this.vx += jx / this.mass;
        this.vy += jy / this.mass;
        that.vx += jx / this.mass;
        that.vy += jy / this.mass;
        this.count++; // Important note: this is high-school physics
        that.count++;
    }
    public void bounceOffVerticallWall(){}
    public void bounceOffHorizontalWall(){}
}
