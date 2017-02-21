package com.imooc.concurrencyTest;

import org.junit.Test;

/**
 * MainThread
 * <p>
 * author:张冠之<br>
 * time: 2017/02/21 13:32 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class MainThread {
    @Test
    public void main(){
        LiftOff launch = new LiftOff();
        launch.run();
        LiftOff launch1 = new LiftOff();
    }
}
