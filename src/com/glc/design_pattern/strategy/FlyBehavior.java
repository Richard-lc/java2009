package com.glc.design_pattern.strategy;

//策略模式
public interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞...");
    }
}

class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("背上邦个穿天猴...");
    }
}

class FlyWithKick implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("被人一脚踢飞...");
    }
}

class FlyNoway implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞不起来...");
    }
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<Slience>>");
    }
}