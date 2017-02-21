package com.imooc.concurrencyTest;

import org.junit.Test;

/**
 * BasicThreads 基础Thread
 * <p>
 * author:张冠之<br>
 * time: 2017/02/21 14:22 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class BasicThreads {
    @Test
    public void main(){
       Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
