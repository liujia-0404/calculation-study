package com.study.整数反转;

/**
 * @author liujia
 * @date 2021年01月11日 15:32:46
 */

/**
 * 题目：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * 本题如果不考虑溢出问题，是非常简单的。解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。
 * */
public class Reverse {

    public static void main(String[] args) {
        int a  = 12345;
        System.out.println(reverse(a));
    }

    /***
     * 思路：
     * 为了便于解释，我们假设 rev 是正数。
     *
     * 如果 temp = rev⋅10+pop 导致溢出，那么一定有rev≥ INTMAX/10
     * 如果 rev== INTMAX/10，那么只要pop>7，temp=rev⋅10+pop 就会溢出。
     * */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
