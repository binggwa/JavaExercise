package com.devtech.training.transportation;

public class Train {
    public Train(String Name) {
        setName(name);
        setWheelSize(60);
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRPM() { return rpms; }
    public void setRPM(int rpms) { this.rpms = rpms; }
    public int getWheelSize() { return wheel_size; }
    private void setWheelSize(int sz) { wheel_size = sz; }
}