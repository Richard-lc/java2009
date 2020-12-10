package com.glc.design_pattern.factory.simple_factory;

//创建产品接口，需要产品时，利用工厂进行创建即可。
//=============服务端===================
interface Food {
    void eat();
}

class Noodles implements Food {
    @Override
    public void eat() {
        System.out.println("吃面条。。。。。");
    }
}

//================客户端======================
public class Negative {
    public static void main(String[] args) {
        Food food = new Noodles();
        food.eat();
    }
}

/*
    这时候，产品来改需求来了，“哥，你先把刀放下。咱们现在这 Noodles改名了，
    得改个特牛逼的名字Spaghetti，让用户记住咱们这是西餐意大利面。”

    这时候，因为你原有设计是上面的反例，你得能从修改服务端的源代码开始，再修改客户端源代码。
    以后再有改名这类事，你还要把刀拿出来放桌上给产品看。

    这种设计过于脆弱，因为这样服务端源代码和客户端源代码是耦合的，改变会牵一发而动全身
 */