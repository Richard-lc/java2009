package com.glc.design_pattern.decorator;

//测试类：装饰器模式
public class Test {
    public static void main(String[] args) {
        Beverage b = new Decaf();
        Beverage b2 = new Milk(b);
        Beverage b3 = new Mocha(b2);
        Beverage b4 = new Milk(b3);
        Beverage b5 = new Mocha(b4);
        System.out.println(b5.getDescription() + ": " + b5.cost());
    }
}
//Java中，java.io就是用了装饰器模式进行API设计