package com.imooc.javacodetest;

import org.junit.Test;

/**
 * A 构造方法测试类
 * <p>
 * author:张冠之<br>
 * time: 2017/01/13 09:24 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */
class A {
    public A(){
        System.out.println("A is constructed");
    }
}
class B{
    public B(){
        System.out.println("B is constructed");
    }
    static class C{
        static int a;
        int b;
    }
}
class C extends A{
    public B b = new B();
}
public class test {
    @Test
    public void main(){
         C c = new C();
    }
}
