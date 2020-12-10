package com.glc.design_pattern.seven_design_philosophy._5_demeter;


class Market {
    private Computer computer;

    public Computer getComputer() {
        return this.computer;
    }
}

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
    private Market market;

    Computer computer = market.getComputer();
    // //此时的 computer 并不是 Person 的朋友，只是 Market 的朋友。
}

public class AppTest2 {
}
