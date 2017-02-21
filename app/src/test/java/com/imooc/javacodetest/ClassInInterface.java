package com.imooc.javacodetest;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaozhizhi on 2017/01/16.
 */

public class ClassInInterface {
    static void ss() {
        a.ss();
    }

    void bb() {

    }

    class Test {
        {
            a.ss();
        }
    }

//     abstract static void ss();
}

class a extends ClassInInterface {

    @Override
    void bb() {
        super.bb();
        List<String > list = Arrays.asList("1","2");
        list.add("1");
        a();
        list.set(1,"23");//修改某个位置上的元素
    }
    public int a(){
        return 1;
    }
    interface d {
    }
}

interface x{
    void k();
}
class WithInner{
    class Inner{}
    }
class InheritInner extends WithInner.Inner{
    InheritInner(){
        new WithInner().super();
    }
}
