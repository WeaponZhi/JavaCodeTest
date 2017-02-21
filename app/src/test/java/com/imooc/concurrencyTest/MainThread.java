package com.imooc.concurrencyTest;

import org.junit.Test;

/**
 * Created by xiaozhizhi on 2017/02/20.
 */

public class MainThread {
    @Test
    public void main(){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
