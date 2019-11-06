package com.mi.zhang.algorithm;

import com.mi.zhang.algorithm.data.ListNode;

/***
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Algorithm2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);

        perform(l1, l2, l3);

        return l3;
    }

    private void perform(ListNode l1, ListNode l2, ListNode l3) {
        int num1 = 0;
        ListNode next1 = null;
        if (l1 != null) {
            num1 = l1.val;
            next1 = l1.next;
        }

        int num2 = 0;
        ListNode next2 = null;
        if (l2 != null) {
            num2 = l2.val;
            next2 = l2.next;
        }

        int num = num1 + num2 + l3.val;

        ListNode l4 = new ListNode(0);
        l3.next = l4;

        if (num >= 10) {
            l3.val = num % 10;
            l4.val = 1;
        } else {
            l3.val = num;
        }

        if (next1 == null && next2 == null && l4.val == 0) {
            l3.next = null;
            return;
        }

        perform(next1, next2, l4);
    }
}
