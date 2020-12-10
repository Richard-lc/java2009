package com.glc.design_pattern.seven_design_philosophy._5_demeter.negtive;


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
}

class Person {
    private Computer computer;

    public void offComputer() {
        computer.closeFile();
        computer.closeScreen();
        computer.powerOff();
    }
}

public class AppTest {
}

/*
    这时候，Person 知道了 Computer的很多细节，对于用户来说不够友好，
    而且，用户还可能会调用错误，先断电，再保存文件，
    显然不符合逻辑，会导致文件出现未保存的错误。

    其实对于用户来说，知道进行关机就行了。
 */