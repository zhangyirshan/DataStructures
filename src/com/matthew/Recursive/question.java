package com.matthew.Recursive;

/**
 * @Description TODO
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author Matthew
 * @Date 2019/9/3 16:57
 * @Version 1.0
 */

public class question {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 0; i < 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode result = MyAnswer.removeElements(head, 1);
        while (result != null) {
            System.out.print(result.val + "  ");
            result = result.next;
        }

    }
}
