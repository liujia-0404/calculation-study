package com.study.最长回文子串;

/**
 * @author liujia
 * @date 2020年12月23日 19:20:09
 */

/**
 * 题目：
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class LongestPalindrome {

    /**
     * 解析：
     * 1、根据字符串的反串是否相等,获取最大的字符串输出
     *
     *
     * */

    public static void main(String[] args) {
        String s = "bcabcbaad";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 中心扩展算法：
     * 我们枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
     * 我们对所有的长度求出最大值，即可得到最终的答案。
     *
     * 时间复杂度：O(n^2)
     *  )，其中 nn 是字符串的长度。长度为 1 和 2 的回文中心分别有 n 和 n-1个，每个回文中心最多会向外扩展 O(n) 次。
     *
     * 空间复杂度：O(1)。
     *
     * */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    /**
     *   动态规划：
     *   对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
     *   例如对于字符串 “ababa”，如果我们已经知道 “bab” 是回文串，
     *   那么 ababa 一定是回文串，这是因为它的首尾两个字母都是 a。
     *
     *
     * 复杂度分析：
     * 时间复杂度：O(n^2)
     *  )，其中 nn 是字符串的长度。动态规划的状态总数为 O(n^2)
     *  )，对于每个状态，我们需要转移的时间为 O(1)
     *
     * 空间复杂度：O(n^2)
     *  )，即存储动态规划状态需要的空间。
     * */
    public static String longestPalindrome2(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }


}
