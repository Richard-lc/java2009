package com.glc.design_pattern.seven_design_philosophy._7_composite_reuse_principle.b;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求：制作一个组合，该集合能够记录下曾经添加过多少元素。（不只是统计某一时刻）
 */

class MySet extends HashSet {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean modified = false;
        for (Object e : c)
            if (add(e))
                modified = true;
        return modified;
    }
}

public class negtive_1 {
    public static void main(String[] args) {
        MySet mySet = new MySet();
        mySet.add("111111");
        mySet.add("22222222222222");
        mySet.add("2333");


        Set hashSet = new HashSet();
        hashSet.add("集合+11111");
        hashSet.add("集合+22222222");
        hashSet.add("集合+233333");
        mySet.addAll(hashSet);

        System.out.println(mySet.getCount());
    }
}

/*
    亲自再重写addAll方法，确保addAll方法一定能调用到add方法，也就能够对 count进行增加操作。

    但是，问题还是有的：
    缺陷：
        如果未来，HashSet新增了一个addSome方法进行元素的添加，那就白给了。
        重写了addAll、add这两个方法，如果JDK中其他类的某些方法依赖于HashMap中的这两个方法，
        那么JDK中其他类依赖于HashMap中的这两个方法的某些方法就会有出错、崩溃等风险。

        这时候，可以得出一些结论：
            当我们不属于继承父类的开发团队时，是没办法保证父类代码不会被修改，
            或者修改时一定被通知到，这时候，就可能会出现需求满足有缺陷的情况。
            所以，但我们去复用父类的代码时，避免去重写或者新建方法，
            这样可以防止源代码结构发生改变带来的打击。
            也就是说，我们在重用代码时，应该是组合优于继承。
*/