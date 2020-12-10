package com.glc.arithmetic.test;

import com.glc.arithmetic.symbol.OrderSymbolTable;

/**
 * 有序符号表测试
 *
 * @author Richard
 * 2020/12/9 19:45
 */
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        //创建有序Order符号表对象
        OrderSymbolTable<Integer, String> st = new OrderSymbolTable<>();

        //测试插入
        st.put(1, "JAVA");
        st.put(3, "HTML");
        st.put(4, "PHP");
        st.put(2, "C#");

        //1,2,3,4
        System.out.println("插入完毕后，元素个数为：" + st.size());


    }
}
