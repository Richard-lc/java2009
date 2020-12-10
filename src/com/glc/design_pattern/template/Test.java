package com.glc.design_pattern.template;

import java.util.LinkedList;
import java.util.List;

//需要使用模板时，只需继承Template类重写相应方法即可
public class Test extends Template {
    @Override
    public void code() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(0, 1);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.template();
    }
}
