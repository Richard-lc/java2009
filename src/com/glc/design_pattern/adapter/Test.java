package com.glc.design_pattern.adapter;

//适配器
class FilterAdapter implements Processor {

    //关联Filter
    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}


public class Test {
    public static void main(String[] args) {
        String s = "How are you!";

        Apply.process(new UpCase(), s);
        Apply.process(new DownCase(), s);
        Apply.process(new Splitter(), s);

        Waveform wf = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(8)), wf);
    }
}
