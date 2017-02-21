package com.imooc.concurrencyTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor 这就像一个线程数量为1的FixedThreadPool，并且还提供了并发保证
 * <p>
 * author:张冠之<br>
 * time: 2017/02/21 14:53 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class SingleThreadExecutor {
    @Test
    public void main() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
