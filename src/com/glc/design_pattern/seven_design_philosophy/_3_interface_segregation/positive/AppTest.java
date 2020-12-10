package com.glc.design_pattern.seven_design_philosophy._3_interface_segregation.positive;

//正例：接口抽象出同一层级的特定意义，提供给需要的类去实现。
interface Fly {
    void fly();
}

interface Eat {
    void eat();
}

interface Swim {
    void swim();
}

class Bird_02 implements Fly, Eat {
    @Override
    public void eat() {
        System.out.println("用嘴巴吃");
    }

    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }

    //我是大雕不会游泳
}

public class AppTest {

}


/*
    客户端依赖的接口中不应该存在他所不需要的方法。
    如果某一接口太大导致这一情况发生，应该分割这一接口，
    使用接口的客户端只需要知道他需要使用的接口及该接口中的方法即可。
*/