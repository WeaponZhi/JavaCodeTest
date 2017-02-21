package com.imooc.javacodetest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * TestClass 线性表代码练习测试
 * <p>
 * author:张冠之<br>
 * time: 2017/01/04 15:42 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class TestLinearClass {
    @Test
    public void main() {
//        init();//初始化
//        codeOfBracketsMatch();//括号匹配
//        getEvalPost();
//        systemConvert(2, 1348);
//        testIterator();
//        trainStack(10);
        findVampireNumber();
    }

    private void init() {
        Queue<String> queue = new LinkedList<>();//链表形式
        Queue<String> queue1 = new ArrayDeque<>();//数组形式
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
    }

    private void getEvalPost() {
        char[] e = new char[]{'1', '+', '2', '*', '3', '+', '(', '1', '+', '2', ')'};
        evalPost(e);
    }

    private void codeOfBracketsMatch() {
        char[] chars1 = new char[]{'{', '[', '(', ')', ']', '}'};
        char[] chars2 = new char[]{'{', '[', '(', ']', ']', '}'};
        char[] chars3 = new char[]{'{', '[', '[', '(', ')', ']', ']', '}', '['};
        char[] chars4 = new char[]{'{', '[', '[', '(', ')', ']', ']', '}', ']'};
        char[] chars5 = new char[]{'{', '[', '[', '(', ')', ']', ']', '}', '[', ']'};
        bracketsIsTrue(chars1);
        bracketsIsTrue(chars2);
        bracketsIsTrue(chars3);
        bracketsIsTrue(chars4);
        bracketsIsTrue(chars5);
    }

    /**
     * 运用栈的特点进行插入操作，避免用add,remove这样的随机存取方法
     *
     * @param position 指定需要插入的位置
     * @param stack    堆栈对象
     * @param string   插入的数据
     */
    public Stack<String> stackInsert(int position, String string, Stack<String> stack) {
        Stack<String> otherStack = new Stack<>();
        if (stack.empty())
            stack.push(string);
        else if (position > stack.size() || position < 0) {
            System.out.println("The position is error!!");
        } else {
            for (int i = 0; i <= position; i++)
                otherStack.push(stack.pop());
            stack.push(string);
            while (!otherStack.empty()) {
                stack.push(otherStack.pop());
            }
        }
        return stack;
    }

    /**
     * 运用栈的特点进行删除操作
     *
     * @param position 指定需要删除的位置
     * @param stack    堆栈对象
     */
    public void stackDelete(int position, Stack<String> stack) {
        Stack<String> otherStack = new Stack<>();
        if (stack.empty())
            System.out.println("stack is empty!!");
        else if (position > stack.size() || position < 0) {
            System.out.println("The position is error!!");
        } else {
            for (int i = 0; i < position; i++)
                otherStack.push(stack.pop());
            stack.pop();
            while (!otherStack.empty()) {
                stack.push(otherStack.pop());
            }
        }
    }

    /**
     * 利用栈进行括号匹配
     *
     * @param chars 括号字符数组
     * @return 匹配返回True, 否则返回false
     */
    public boolean bracketsIsTrue(char[] chars) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        if (chars.length == 0) {
            System.out.println("字符数组为空");
            return false;
        } else {
            while (i < chars.length) {
                switch (chars[i]) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(chars[i]);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek().equals('('))
                            stack.pop();
                        else {
                            System.out.println("括号不匹配!");
                            return false;
                        }
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek().equals('{'))
                            stack.pop();
                        else {
                            System.out.println("括号不匹配!");
                            return false;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek().equals('['))
                            stack.pop();
                        else {
                            System.out.println("括号不匹配!");
                            return false;
                        }
                        break;
                }
                i++;
            }
        }
        if (stack.isEmpty()) {
            System.out.println("括号匹配!");
            return true;
        } else {
            System.out.println("括号不匹配!");
            return false;
        }
    }

    /**
     * 算术表达式求值(整型求值)，先转化为后缀然后进行后缀求值
     *
     * @param e 前缀算术表达式字符数组
     * @return 返回值
     */
    public float evalPost(char[] e) {
        char[] f = postFix(e).toCharArray();
        Stack<Float> stack = new Stack<>();//操作数栈
        int i = 0;
        float x;
        while (i < f.length) {
            if (f[i] >= '0' && f[i] <= '9') {
                stack.push(readNumber(f, i)[1]);
                i = (int) readNumber(f, i)[0];
            } else if (' ' == f[i])//空格
                i++;
            else if (f[i] == '+') {//加
                x = stack.pop();
                stack.push(stack.pop() + x);
                i++;
            } else if (f[i] == '-') {//减
                x = stack.pop();
                stack.push(stack.pop() - x);
                i++;
            } else if (f[i] == '*') {//乘
                x = stack.pop();
                stack.push(stack.pop() * x);
                i++;
            } else if (f[i] == '/') {//除
                x = stack.pop();
                stack.push(stack.pop() / x);
                i++;
            }
        }
        System.out.println(stack.peek());
        return stack.pop();//栈顶元素即为表达式的值
    }

    /**
     * 读取一个实数
     *
     * @param f 后缀表达式
     * @param i 当前读取到第一个数字时的位置
     * @return
     */
    public float[] readNumber(char[] f, int i) {
        float[] index = new float[2];
        float x = 0.0f;
        int k = 0;

        while (f[i] >= '0' && f[i] <= '9') {
            x = x * 10 + (f[i] - '0');
            i++;
        }
        if (f[i] == '.') {
            i++;
            while (f[i] >= '0' && f[i] <= '9') {
                x = x * 10 + (f[i] - '0');
                i++;
                k++;
            }
        }
        while (k != 0) {
            x = x / 10.0f;
            k = k - 1;
        }
        index[0] = i;
        index[1] = x;
        return index;
    }


    /**
     * 将中缀算数表达式转换为后缀算数表达式
     *
     * @param e 中缀算数表达式的字符串
     * @return 返回后缀算术表达式字符数组
     */
    public String postFix(char[] e) {
        Stack<Character> stack = new Stack<>();
        StringBuilder f = new StringBuilder();
        int i = 0;
        while (i < e.length) {
            if ((e[i] >= '0' && e[i] <= '9') || e[i] == '.')
                f.append(e[i]);  //数字
            else if (e[i] == '(') //左括号
                stack.push(e[i]);
            else if (e[i] == ')') {//右括号
                while (stack.peek() != '(')
                    f.append(stack.pop());
                stack.pop();
            } else if (isOp(e[i])) {
                f.append(' ');//用空格分开
                if (stack.empty())
                    stack.push(e[i]);
                else {
                    while (!stack.empty() && priority(stack.peek()) >= priority(e[i])) {
                        f.append(stack.pop());
                    }
                    stack.push(e[i]);//当前元进栈
                }
            }
            i++;
        }
        while (!stack.empty())
            f.append(stack.pop());
        return f.toString();
    }

    private boolean isOp(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private int priority(char op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    /**
     * 十进制转换为任意进制的方法，根据一个简单原理：
     * n=(n div d)*d + n mod d
     *
     * @param system
     * @param numberOfTen
     */
    public void systemConvert(int system, int numberOfTen) {
        int orialNumber = numberOfTen;
        Stack<Integer> stack = new Stack<>();
        if (numberOfTen / system != 0) {
            while (numberOfTen != 0) {
                stack.push(numberOfTen % system);
                numberOfTen = numberOfTen / system;
            }
        }
        if (!stack.empty()) {
            StringBuffer systemNumber = new StringBuffer();
            while (!stack.empty())
                systemNumber.append(stack.pop());
            if (!systemNumber.toString().isEmpty())
                System.out.println(orialNumber + "转化为" + system + "进制为:" + systemNumber.toString());
        }
    }

    /**
     * 编号为1234的火车进入栈式的列车调度站，可能得到的调度结果有那些？如果有n列火车通过调度站，设计算法，输出可能的调度结果
     *
     * @param sum 火车数量
     */
    public void trainStack(int sum) {
        int sumNumber = 1;
        //获取阶乘数
        for (int i = 1; i <= sum; i++)
            sumNumber = sumNumber * i;

        List<Character> list = new ArrayList<>();//放置1-sum字符列的list
        List<String> stringList = new ArrayList<>();//放置排列组合数组的list

        //初始化顺序字符数组
        for (int i = 1; i <= sum; i++)
            list.add((char) (i + 48));

        //将sum的阶乘的所有情况列出来
        for (int i = 0; i < sumNumber; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            Collections.shuffle(list);//打乱顺序
            //形成一个排列组合
            for (Iterator iterator = list.iterator(); iterator.hasNext(); )
                stringBuilder.append(iterator.next());
            //如果这种排列组合list队列没有，则将该排列组合放入list中
            if (!stringList.contains(stringBuilder.toString()))
                stringList.add(stringBuilder.toString());
        }

        stringList = filterList(stringList);
        for (Iterator iterator = stringList.iterator(); iterator.hasNext(); )
            System.out.println(iterator.next());
        System.out.println("总共有" + stringList.size() + "种火车调度结果");
    }

    private List<String> filterList(List<String> stringList) {
        for (Iterator iterator = stringList.iterator(); iterator.hasNext(); )
            if (!filterString((String) iterator.next()))
                iterator.remove();
        return stringList;
    }

    private boolean filterString(String string) {
        int a = string.charAt(0) - 48;
        for (int i = 1; i < a - 1; i++)
            if (string.indexOf(i + 48) < string.indexOf(i + 49))
                return false;
        if (string.isEmpty())
            return true;
        else return filterString(string.substring(0));
    }

    public void testIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); )
            if (iterator.next().equals(5) || iterator.next().equals(7))
                iterator.remove();
        for (Iterator ite = list.iterator(); ite.hasNext(); )
            System.out.println(ite.next());
    }

    public void findVampireNumber() {
        String[] a, b;
        int sum = 0;
        label:
        for (int i = 10; i > 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                int result = i * j;
                if (result < 1000 || result > 9999)
                    continue;
                a = String.valueOf(result).split("");
                b = (String.valueOf(i) + String.valueOf(j)).split("");
                java.util.Arrays.sort(a);
                java.util.Arrays.sort(b);
                if (java.util.Arrays.equals(a,b)){
                    sum++;
                    System.out.println("第"+sum+"组："+i+"*"+j+"="+result);
                }
            }
        }
        System.out.println("共找到:"+sum+"组吸血鬼数");
    }

}