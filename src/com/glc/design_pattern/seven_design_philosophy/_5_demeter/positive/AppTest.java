package com.glc.design_pattern.seven_design_philosophy._5_demeter.positive;

//封装细节
class Computer {
    public void closeFile() {
        System.out.println("关闭文件");
    }

    public void closeScreen() {
        System.out.println("关闭屏幕");
    }

    public void powerOff() {
        System.out.println("断电");
    }

    public void turnOff() {  //封装细节
        this.closeFile();
        this.closeScreen();
        this.powerOff();
    }
}

class Person {
    private Computer computer;

    public void offComputer() {
        computer.turnOff();
    }
}


public class AppTest {
}

/*
    封装细节
    对于用户来说，知道进行关机就行了。
 */