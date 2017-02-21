package com.imooc.javacodetest;

import org.junit.Test;

/**
 * OverloadingVarargs2 测试混淆可变参数
 * <p>
 * author:张冠之<br>
 * time: 2017/01/12 16:34 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class OverloadingVarargs2 {
    static void f(char i ,Character... args){
        for (Character c : args)
            System.out.println(c);
    }
    static void f(Character... args){
        System.out.println("second");

    }
    @Test
    public void main(){
        f();
    }
}
