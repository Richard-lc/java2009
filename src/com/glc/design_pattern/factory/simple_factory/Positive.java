package com.glc.design_pattern.factory.simple_factory;

//简单工厂模式
/*===============服务端======================*/
//interface Food{
//    void eat();
//}

class Spaghetti implements Food {
    @Override
    public void eat() {
        System.out.println("吃西餐面条。。。。。");
    }
}

class FoodFactory {
    public Food getFood(int num) {
        Food food = null;
        switch (num) {
            case 1:
                food = new Spaghetti();
        }
        return food;
    }
}

/*=================客户端===================*/
public class Positive {

    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();
        Food food = foodFactory.getFood(1);
        food.eat();
    }
}

/*
    通过这样一个正例，把创建对象的代码全交给服务端处理，将服务端代码和客户端代码进行了解耦。
    以后产品再找你聊天是不是可以暂时把刀收起来了？

    这样做的好处，不只是服务端开发人员受益，当服务端代码修改时，客户端也不知道，也不需要知道。

    这样的设计模式并不是十全十美的，任何一种设计模式都不会是十全十美的。只是根据业务逻辑在各方面进行取舍。

    简单工厂模式的缺点：
        客户必须记住工厂中常量和具体产品的映射关系。
        一旦产品品种体量增大到一定程度，工厂类将变得非常臃肿。
        最致命的缺陷，增加产品时，就要修改工厂类。违反开闭原则。
 */