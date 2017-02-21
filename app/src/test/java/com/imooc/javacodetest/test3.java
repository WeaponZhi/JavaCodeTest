package com.imooc.javacodetest;

import org.junit.Test;

/**
 * Created by xiaozhizhi on 2017/01/13.
 */



  class Insect {
    private int i = 9;
    int j = 9;
    {
        if (j>8)
            System.out.println("j > 8");
        System.out.println("area is construct");
    }

   static {
        System.out.println("static area is construct");
    }

    public Insect(){
        System.out.println("Insect is construct");
    }
     void InsectMethod(){
        int b = new innerClass().a;
     }
     private interface InsectInterface{
         void f();
     }
     public class interTest implements InsectInterface{

         @Override
         public void f() {
            System.out.println("interTest");
         }
     }
     public InsectInterface getFace(){
         return new interTest();
     }
     public void getFace2(InsectInterface insectInterface){
        insectInterface.f();
     }
    public void receiveD(InsectInterface insectInterface){
        insectInterface.f();
    }
    public interface interfaceTest{
        void f();
    }
     class innerClass implements interfaceTest{
        private int a;
        private int c = i;
        {
            System.out.println("奇怪了");
        }
        @Override
        public void f() {

        }
    }
    public Insect outerTest(){
        return new Insect();
    }


}

public class test3 {
    @Test
    public void main() {
        System.out.println("main is run");
        Insect insect = new Insect();
        insect.receiveD(insect.getFace());
    }
}