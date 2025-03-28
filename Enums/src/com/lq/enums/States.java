package com.lq.enums;

public enum States {
    NY("New York", "Albany"),
    PA("Pennsylvania", "Harrisburg"),
    FL("Florida", "Tallahassee");

    private String name;
    private String capitol;

    private States(String name, String capitol) {
        this.name = name;
        this.capitol = capitol;
    }

    public String getName() {
        return name;
    }

    public String getCapitol() {
        return capitol;
    }

}
