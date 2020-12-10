package com.glc.arithmetic.linear;

import java.util.Iterator;

//顺序表
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中元素的个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        for (int i = 0; i < eles.length; i++) {
            eles[i] = null;
        }
        this.N = 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    //向线性表中添加元素t
    public void insert(T t) {

        if (N == eles.length) {
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i, T t) {

        if (N == eles.length) {
            resize(2 * eles.length);
        }
        //先把i索引处的元素及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //再把t元素放到i索引处即可
        eles[i] = t;
        //元素个数加一
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        //记录索引i处的值
        T current = eles[i];
        //索引i后面的元素依次向前移动一位即可
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        //元素个数减一
        N--;

        if (N < eles.length / 4) {
            resize(eles.length / 2);
        }

        return current;
    }

    //返回线性表中首次出现该元素的序号，不存在则返回-1
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (t.equals(eles[i])) {
                return i;
            }
        }
        return -1;
    }

    //根据参数newsize重置eles数组的大小
    public void resize(int newsize) {
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[]) new Object[newsize];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Siterator();
    }

    private class Siterator implements Iterator {
        private int cusor;

        public Siterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
