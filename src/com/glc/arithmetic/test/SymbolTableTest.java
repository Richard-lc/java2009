package com.glc.arithmetic.test;

import com.glc.arithmetic.symbol.SymbolTable;

/**
 * 符号表测试
 *
 * @author Richard
 * 2020/12/9 19:45
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<String, String> st = new SymbolTable<>();

        //测试插入
        st.put("张三", "JAVA");
        st.put("李四", "HTML");
        st.put("王五", "PHP");
        st.put("赵六", "C#");

        System.out.println("插入完毕后，元素个数为：" + st.size());

        st.put("张三", "C++");
        System.out.println("替换完毕后，元素个数为：" + st.size());

        //测试get方法
        String s = st.get("张三");
        System.out.println("替换完毕后，键张三对应的值为：" + s);

        //测试删除方法
        st.delete("赵六");
        System.out.println("删除完毕后，元素个数为：" + st.size());
    }
}
