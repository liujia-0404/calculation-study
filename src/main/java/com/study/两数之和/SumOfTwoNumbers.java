package com.study.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujia
 * @date 2020年12月19日 13:56:38
 */

/**
 * 问题：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * Related Topics
 * 数组
 * 哈希表
 * */

public class SumOfTwoNumbers {
     /**
      * 思路：
      *链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
      *
      * HashMap 之所以速度快，因为它使用的是散列表，根据 key 的 hashcode 值生成数组下标（通过内存地址直接查找，没有任何判断），
      * 时间复杂度完美情况下可以达到 n1（和数组相同，但是比数组用着爽多了，但是需要多出很多内存，相当于以空间换时间）。
      *
      *注意到暴力破解的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
      *
      * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
      *
      * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
      *
      * 复杂度分析
      *
      * 时间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1)O(1) 地寻找 target - x。
      *
      * 空间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。
      * */

     public static int[] doMain(int[] nums,int target){
         int length = nums.length;
         //指定map长度为length-1
        Map<Integer,Integer> hashTable = new HashMap<Integer,Integer>(length-1);
        for (int i=0;i<nums.length;i++) {
            if (hashTable.containsKey(target-nums[i])) {
                return new int[]{hashTable.get(target-nums[i]),i};
            } else {
                hashTable.put(nums[i],i);
            }
        }
        return new int[0];
     }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,8,11,15,};
        int target = 9;
        System.out.println(Arrays.toString(doMain(nums,target)));

    }
}
