package com.imooc.javacodetest;

import org.junit.Test;

/**
 * TestArray 测试数组赋值只是复制了引用
 * <p>
 * author:张冠之<br>
 * time: 2017/01/12 15:35 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class TestArray {
    @Test
    public void main() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        //下面的for方法可以通过引用改变进行数组的同时改变
        for (int i = 0; i < a2.length; i++)
            a2[i] += 1;
        for (int i = 0;i<a1.length;i++)
            System.out.println("a1["+i+"] = "+ a1[i]);
        //foreach语句是先把数组内成员的值赋给新建的变量i，不会对存储空间内的引用数据值造成变化
        for (int i:
             a2) {
            i = i+1;
        }
        for (int i : a2)
            System.out.println(i);
        for (int j:
             a1) {
            System.out.println(j);
        }
    }
}
