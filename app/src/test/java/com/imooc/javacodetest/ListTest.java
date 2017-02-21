package com.imooc.javacodetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * ListTest 测试List的各种方法
 * <p>
 * author:张冠之<br>
 * time: 2017/01/17 19:21 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class ListTest {
    @Test
    public void main() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.addAll(list);
        List<Integer> subList = list.subList(1, 3);
        Queue queue = new LinkedList();
        Collections.shuffle(subList);
        System.out.println(list);
        System.out.println(subList);

        Collections.sort(subList);
        System.out.println(list);
        System.out.println(subList);

        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(subList);
        Map<String ,String > map = new HashMap<>();



        for (int i : list)
            System.out.println(i);
    }

}



