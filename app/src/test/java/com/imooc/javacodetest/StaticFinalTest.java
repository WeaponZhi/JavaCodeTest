package com.imooc.javacodetest;

import org.junit.Test;

/**
 * StaticFinalTest 测试静态类和静态常量的调用初始化
 * <p>
 * author:张冠之<br>
 * time: 2017/02/04 14:00 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class StaticFinalTest {
    @Test
    public void main() throws Exception {
        Class initable = Initable.class;
        Initable initable1 = new Initable();
//        System.out.println(Initable.staticFinal2);
    }

}
  class Initable {
    static final int staticFinal = 47;
    static int staticFinal2 = 48;
    static int staticFinal3 = 49;

    static {
        System.out.println("Initializing Initable");
    }

    public Initable() {
        System.out.println("Initable is constructed");
    }
}

class InitableSon extends Initable {
    public InitableSon() {
        System.out.println("InitableSon is constructed");
    }
}


