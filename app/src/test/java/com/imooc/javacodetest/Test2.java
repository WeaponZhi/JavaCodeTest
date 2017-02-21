package com.imooc.javacodetest;

import org.junit.Test;

/**
 * Root 父类中有实例变量
 * <p>
 * author:张冠之<br>
 * time: 2017/01/13 09:39 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class Test2 {
    @Test
    public void main() {
        Stem stem = new Stem();
        System.out.println(stem.mComponent1);
    }
}

class Root {
    public Component1 mComponent1 = new Component1();
    public Component2 mComponent2 = new Component2();
    public Component3 mComponent3 = new Component3();

    Root() {
        System.out.println("Root is constructed");
        System.out.println(mComponent1);
    }
       private void test123(){

    }
}

class Stem extends Root {
    Stem(){
        System.out.println("Stem is constructed");
    }
    void test123(){
        Stem stem = new Stem();
        Root root = new Root();
    }
}

class Component1 {
    Component1() {
        System.out.println("Component1 is constructed");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2 is constructed");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3 is constructed");
    }
}

class testOverride{
    void a(){
    }
    void a(int i){

    }
    void a(float i ){

    }
}
class testOverride2 extends testOverride{
    int a = 1;
    testOverride2 mTestOverride2 = new testOverride2();

    void a(char c) {

    }

    public void test(){
        testOverride testOverride = new testOverride2();
        mTestOverride2.a(a);
        mTestOverride2.a(1.0f);
        mTestOverride2.a();
        mTestOverride2.a('a');
    }
}
