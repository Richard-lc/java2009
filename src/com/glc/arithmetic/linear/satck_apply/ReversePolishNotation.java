package com.glc.arithmetic.linear.satck_apply;

import com.glc.arithmetic.linear.Stack;

//使用栈计算逆波兰表达式
public class ReversePolishNotation {
    public static void main(String[] args) {
        //中缀表达式 3*(17-15)+18/6 的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * 使用栈计算逆波兰表达式
     *
     * @param notation 逆波兰表达式数组
     * @return 计算结果
     */
    private static int calculate(String[] notation) {
        //1.定义一个栈，用来存储操作数
        Stack<Integer> stack = new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notation.length; i++) {
            String s = notation[i];
            Integer o1;
            Integer o2;
            Integer result;
            //3.判断当前元素是操作数还是运算符
            switch (s) {
                //4.如果是运算符，从栈中弹出两个操作数，进行运算，再将运算完的结果压入栈中
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 + o1;
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 / o1;
                    stack.push(result);
                    break;
                default:
                    //5.如果是操作数，把该操作数压入栈中
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        //6.栈中最后一个元素就是逆波兰表达式的结果
        return stack.pop();
    }
}
