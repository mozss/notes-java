package com.mozss.algorithms.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mozss
 * @create 2019-09-06 11:29
 */
/*
 * 575.分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果，你需要
 * 吧这些糖果平均分给一个弟弟和一个妹妹，返回妹妹可以获得的最大糖果种类数。
 *
 * 示例一：
 * 输入：candies = [1,1,2,2,3,3]
 * 输出：3
 * 解析：一共有三种种类的糖果，每一种都有两个
 * 最有的分配方案，妹妹获得[1,2,3]，弟弟也获得[1,2,3],这样妹妹获得糖果的种类最多
 *
 * 示例二：
 * 输入：candies = [1,1,2,3,]
 * 输出：2
 * 解析：妹妹获得[2,3]，弟弟获得[1,1]
 *
 * 注意：
 * 1.数组的长度为[2,10000],并且确定为偶数
 * 2.数组中数字的大小范围在-100000,10000内
 * */
public class No_575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        if (set.size() >= candies.length / 2) {
            return candies.length / 2;
        }
        return set.size();
    }


}
