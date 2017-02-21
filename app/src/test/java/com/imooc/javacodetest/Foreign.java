package com.imooc.javacodetest;

import com.imooc.javacodetest2.PackagedClass;

import org.junit.Test;

/**
 * Foreign 测试包访问权限
 * <p>
 * author:张冠之<br>
 * time: 2017/01/12 20:01 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class Foreign {
    @Test
    public void main(){
        PackagedClass pc = new PackagedClass();
    }
}
