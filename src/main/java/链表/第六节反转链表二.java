package 链表;

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，
 * 返回反转后的链表。
 * left<=right<=链表节点数
 */
public class 第六节反转链表二 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        /*ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;*/

        ListNode head = l1;
        System.out.print("输入:");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
        ListNode reversed = reversed(l1, 1, 2);
        System.out.print("输出:");
        while (reversed != null) {
            System.out.print(reversed.val);
            reversed = reversed.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }

    static ListNode reversed(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode oldHead = head;
        ListNode newHead = null;
        ListNode current = null;
        ListNode rightNode = null;

        // 截取链表left到right部分
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                current = new ListNode(oldHead.val);
                newHead = current;
                oldHead = oldHead.next;
            } else if (i > left) {
                current.next = new ListNode(oldHead.val);
                current = current.next;
                oldHead = oldHead.next;
                if (i == right) {
                    rightNode = oldHead;
                    break;
                }
            } else {
                oldHead = oldHead.next;
            }
        }
        // 反转newHead链表
        ListNode newHead2 = null;
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = newHead2;
            newHead2 = newHead;
            newHead = next;
        }

        ListNode newHead3 = head;
        if (left == 1) {
            newHead3 = newHead2;
        } else {
            int num = 0;
            while (head != null) {
                ++num;
                if (num == left - 1) {
                    head.next = newHead2;
                    break;
                }
                head = head.next;
            }
        }

        ListNode result = newHead3;
        ListNode lastNode = null;
        while (newHead3 != null) {
            lastNode = newHead3;
            newHead3 = newHead3.next;
        }
        lastNode.next = rightNode;
        return result;
    }
}
