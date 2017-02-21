package com.imooc.javacodetest;
import org.junit.Test;
/**
 * StaticTest 测试静态代码块
 * <p>
 * author:张冠之<br>
 * time: 2017/01/12 15:08 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class StaticTest {
    @Test
    public void main(){
        System.out.println("Inside main()");
//        Cups.cup1.f(99);
    }
//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();
}

 class Cup{
    Cup(int marker){
        System.out.println("Cup"+"("+marker+")");
    }
    void f(int marker){
        System.out.println("f("+marker+")");
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;
    static{
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        System.out.println("Cups");
    }
}
