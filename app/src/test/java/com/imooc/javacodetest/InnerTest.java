package com.imooc.javacodetest;

import org.junit.Test;

/**
 * InnerTest 匿名内部类
 * <p>
 * author:张冠之<br>
 * time: 2017/01/16 16:06 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class InnerTest {
    @Test
    public void main() {
        OuterClass outerClass = new OuterClass(6);
        OuterClass2 mOuterClass2 = outerClass.sOuterClass2;
        OuterClass2 mOuterClass22 = outerClass.sOuterClass2;
        mOuterClass2.a = 1;
        System.out.println("mOuterClass2"+mOuterClass22.a);
    }
    static class a{
        static class b{

        }
    }



}
class OuterClass {
    public static OuterClass2 sOuterClass2 = new OuterClass2();
    OuterClass(int i) {
        System.out.println(i);
    }
    public void print(){
        System.out.println("1 is construct");
    }
}

class OuterClass2 {
    public int a;
    public OuterClass getOutClass() {
        return new OuterClass3(1);
    }

    class OuterClass3 extends OuterClass {
        public OuterClass3(int i) {
            super(i);
        }


    }
}

