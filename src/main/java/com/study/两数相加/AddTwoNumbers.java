package com.study.两数相加;

/**
 * @author liujia
 * @date 2020年12月21日 16:57:34
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * */
public class AddTwoNumbers {

    /**
     * 思路
     * 设计
     * 标签：链表
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
     * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     *
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
     *
     * */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(6);
        l1.next = new ListNode(4);
        l2.next = new ListNode(6);
        ListNode end = addTwoNumbers(l1,l2);
        System.out.println(print(end));
    }
    public static String print(ListNode l){
        StringBuilder sb = new StringBuilder();
        while(l != null){
            sb.append(l.val);
            l=l.next;
        }
        return sb.toString();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;
        while (l1 !=null||l2!=null|| addOne != 0) {
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            int sum = val1+val2 +addOne;
            //java小知识：head和dummy的变化可以看它们的hash地址变化，得知节点在推移
            head.next = new ListNode(sum%10);
            head = head.next;
            addOne = sum/10;
            if (l1 !=null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

}
