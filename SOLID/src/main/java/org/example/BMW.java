package org.example;

public class BMW implements ICar {

    private String name;

    @Override
    public void drive() {
        System.out.println("is driving");

    }

    @Override
    public String getNames() {
        return name;
    }
}
