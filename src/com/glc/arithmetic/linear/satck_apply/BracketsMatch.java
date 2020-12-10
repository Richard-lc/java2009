package com.glc.arithmetic.linear.satck_apply;

import com.glc.arithmetic.linear.Stack;

//使用栈解决括号匹配问题
public class BracketsMatch {
    public static void main(String[] args) {
        String str = "(上海(长安)())";
        //判断括号是否匹配
        boolean match = isMatch(str);
        System.out.println(str + "中的括号是否匹配：" + match);
    }

    /**
     * 使用栈判断str中括号是否匹配
     *
     * @param str 括号组成的字符串
     * @return 如果匹配，返回true，否则返回false
     */
    private static boolean isMatch(String str) {
        //1.创建栈对象，用来存储左括号
        Stack<String> stack = new Stack<>();
        //2.从左往右遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            if (c.equals("(")) {
                //3.判断当前字符是否为左括号，如果是，则把字符放入栈中
                stack.push(c);
            } else if (c.equals(")")) {
                //4.继续判断当前字符是否是右括号，如果是，则从栈中弹出一个左括号，并判断弹出的结果是否为null，为null则不匹配
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        //5.判断栈中是否还有剩余的左括号，如果有则不匹配
        if (stack.size() != 0) {
            return false;
        } else {
            return true;
        }
    }
}
