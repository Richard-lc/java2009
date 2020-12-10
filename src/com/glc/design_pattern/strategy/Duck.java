package com.glc.design_pattern.strategy;

//策略模式
public abstract class Duck {

    //关联策略
    protected FlyBehavior fb;
    protected QuackBehavior qb;

    public void performFly() {
        fb.fly();
    }

    public void performQuack() {
        qb.quack();
    }

    public void swim() {
        System.out.println("游泳...");
    }

    public abstract void display();

    public FlyBehavior getFb() {
        return fb;
    }

    public void setFb(FlyBehavior fb) {
        this.fb = fb;
    }

    public QuackBehavior getQb() {
        return qb;
    }

    public void setQb(QuackBehavior qb) {
        this.qb = qb;
    }
}

class MallardDuck extends Duck {

    public MallardDuck() {
        fb = new FlyWithWings();
        qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是野鸭！！");
    }
}

class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        fb = new FlyWithWings();
        qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是红头鸭！！");
    }
}