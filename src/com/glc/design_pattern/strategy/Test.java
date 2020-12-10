package com.glc.design_pattern.strategy;

public class Test {
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        //策略模式
        d.performFly();
        d.performQuack();
        //运行时可以改变策略
        d.setFb(new FlyWithRocket());
        d.setQb(new Squeak());
        d.performFly();
        d.performQuack();
        d.swim();
        d.display();
    }
}
