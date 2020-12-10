package com.glc.design_pattern.decorator;

/*
    1.业务场景：星巴克卖咖啡，有四种咖啡：Decaf Espresso DarkRoast HouseBlend
    2.新业务：在咖啡中加调料：Milk Soy Mocha Bubble
 */
public abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Decaf extends Beverage {

    public Decaf() {
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

class Espresso extends Beverage {

    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}

class DarkRoast extends Beverage {

    public DarkRoast() {
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        return 1.5;
    }
}

class HouseBlend extends Beverage {

    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 3;
    }
}
