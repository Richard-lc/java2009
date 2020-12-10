package com.glc.design_pattern.builder.b;

import com.glc.design_pattern.builder.a.Computer;

/*=============服务端==========================*/
class HighComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("9700k");
        computer.setGpu("gtx2080ti");
        computer.setHd("SSD--1T");
        computer.setRAM("32G");
        return computer;
    }
}

class High_02ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("9600k");
        computer.setGpu("gtx1080ti");
        computer.setHd("SSD--500G");
        computer.setRAM("16G");
        return computer;
    }
}

/*=====================客户端===============================*/
public class B {

    public static void main(String[] args) {
        HighComputerBuilder builder_01 = new HighComputerBuilder();
        Computer computer_01 = builder_01.build();

        High_02ComputerBuilder builder_02 = new High_02ComputerBuilder();
        Computer computer_02 = builder_02.build();

        System.out.println(computer_01);
        System.out.println(computer_02);
    }
}
//创造了建造者类，用于创建复杂对象。

/*
    缺陷：建造者遗漏部分建造步骤编译也会通过，会造成建造出来的对象不符合要求。
    比如，漏执行某一步骤时，使得部分值为null，后续对象属性被调用时，
    可能会抛出空指针NullPointerException异常，会造成程序崩溃。
 */