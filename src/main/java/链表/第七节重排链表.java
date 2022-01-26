package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * 比如A1,A2,A3,A4,A5,A6...,An
 * 排列后A1,An,A2,An-1,A3,An-2
 */
public class 第七节重排链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        //reorderList(l1);
        guanFangFangFa(l1);
        System.out.println(l1);
    }

    /**
     * 自己思路,先反转链表,然后交替插入,这种时间复杂度是O(n),空间复杂度是O(1)
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode oldHead = head;
        // 计算链表长度
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode != null) {
            ++length;
            lengthNode = lengthNode.next;
        }
        // 存一份初始链表
        ListNode copyNode = head;
        ListNode preOldList = new ListNode(0);
        ListNode cur = preOldList;
        while (copyNode != null) {
            ListNode next = new ListNode(copyNode.val);
            cur.next = next;
            cur = next;
            copyNode = copyNode.next;
        }
        ListNode oldList = preOldList.next;
        // 反转链表,获得反向链表
        ListNode newList = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newList;
            newList = head;
            head = temp;
        }
        // 1/2交错
        boolean flag = length % 2 == 0;
        ListNode newHead = new ListNode(0, null);
        ListNode pre = newHead;
        for (int i = 0; i < length / 2; i++) {
            ListNode new1 = new ListNode(oldList.val);
            ListNode new2 = new ListNode(newList.val);
            pre.next = new1;
            pre.next.next = new2;
            pre = new2;
            oldList = oldList.next;
            newList = newList.next;
        }
        if (!flag) {
            pre.next = new ListNode(oldList.val);
        }
        head = newHead.next;
        oldHead.val = head.val;
        head = head.next;
        ListNode temp = oldHead;
        while (head != null) {
            ListNode next = new ListNode(head.val);
            temp.next = next;
            temp = temp.next;
            head = head.next;
        }
        head = oldHead;

    }

    /**
     * 官方方法
     * 方法一：线性表
     * 因为链表不支持下标访问，所以我们无法随机访问链表中任意位置的元素。
     * 因此比较容易想到的一个方法是，我们利用线性表存储该链表，然后利用线性表可以下标访问的特点，直接按顺序访问指定元素，重建该链表即可。
     */
    static void guanFangFangFa(ListNode head) {
        // 先存进list中
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 两头操作
        int i = 0;
        for (int j = list.size() - 1; i <= j; i++, j--) {
            list.get(i).next = list.get(j);
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i + 1);
        }
        list.get(i).next = null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
