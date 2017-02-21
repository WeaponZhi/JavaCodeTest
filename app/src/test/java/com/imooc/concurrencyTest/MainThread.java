package com.imooc.concurrencyTest;

import org.junit.Test;

/**
 * MainThread 主线程
 * <p>
 * author: 张冠之 <br>
 * time:   2017/02/21 12:48 <br>
 * e-mail: 584098488@qq.com <br>
 * </p>
 */
public class MainThread {
    @Test
    public void main(){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
