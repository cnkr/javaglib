package org.lwjglb.engine;

abstract public class Timer {

    private double lastLoopTime;
    abstract public void init();
    abstract public double getTime();
    abstract public float getElapasedTime();
    public double getLastLoopTime();
}
