package com.glc.design_pattern.seven_design_philosophy._3_interface_segregation.negtive;

//反例：动物接口中并不是所有动物都需要的。
interface Animal {
    void eat();

    void fiy(); //泥鳅：你来飞？

    void swim(); // 大雕：你来游？
}

class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("用嘴巴吃");
    }

    @Override
    public void fiy() {
        System.out.println("用翅膀飞");
    }

    @Override
    public void swim() {
        //我是大雕不会游泳
    }
}

public class AppTest {

}


/*
    接口中的 swim()方法在实际开发中，并不适用于该类。
*/