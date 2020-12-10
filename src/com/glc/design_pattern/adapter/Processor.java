package com.glc.design_pattern.adapter;

import java.util.Arrays;

//自己写的代码
public interface Processor {
    public String name();

    Object process(Object input);
}

abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}

class UpCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

//以接口作为参数优于类作为参数Processor p
class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor:" + p.name());
        System.out.println(p.process(s));
    }
}