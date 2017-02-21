package com.imooc.javacodetest2;

import java.util.LinkedHashMap;

/**
 * Created by xiaozhizhi on 2017/02/07.
 */

class CClass {

    public void g() {
        System.out.println("g is run");
    }

    void u() {
        System.out.println("u is run");
    }
}

public class HiddenC {
    public static CClass makeA() {
        return new CClass();
    }
    public CClass ads(){
        return new Bbclass();
    }
    public Bbclass ads(int a){
       return (Bbclass) new CClass();
    }
}
interface Ad{
       int a = 1;
    int[] a1 = new int[1];
    LinkedHashMap<Integer,String> map = new LinkedHashMap<>(15,0.75f,true);
}

class Bbclass extends CClass{

}