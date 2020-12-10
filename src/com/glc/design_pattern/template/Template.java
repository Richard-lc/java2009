package com.glc.design_pattern.template;

//模板方法模式：
//例如测试代码，定义一个模板方法
public abstract class Template {
    public void template() {
        System.out.println("开始：");
        long start = System.currentTimeMillis();

       /* List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(0, 1);
        }*/
        code();

        long end = System.currentTimeMillis();
        System.out.println("结束 ：" + (end - start));
    }

    public abstract void code();
}
