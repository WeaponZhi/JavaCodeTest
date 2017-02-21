package com.imooc.javacodetest;

/**
 * Created by xiaozhizhi on 2017/01/18.
 */

public class ExceptionTest {

}
class ExceptionTest1{
    void test1() throws Exception {
        throw new Exception();
    }
    void test(){
        try {
            test1();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
