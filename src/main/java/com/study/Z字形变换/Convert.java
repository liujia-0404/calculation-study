package com.study.Z字形变换;

/**
 * @author liujia
 * @date 2021年01月11日 14:47:36
 */

import java.util.ArrayList;
import java.util.List;

/**
 *题目：
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 *之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 *
 * */

public class Convert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        //先创建空行字符串
        for (int i = 0; i < numRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            rows.add(stringBuilder);
        }
        int i = 0;
        //反转标识,第一行或最后一行反转
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        rows.stream().forEach(data -> sb.append(data));
        return sb.toString();
    }


}
