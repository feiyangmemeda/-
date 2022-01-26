package 链表;

public class 第四节删除链表倒数第n节点 {

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
        ListNode listNode = removeNthFromEnd(l1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead;
        newHead = head;
        int length = 0;

        while (newHead != null) {
            newHead = newHead.next;
            length = length + 1;
        }

        if (length == 0) return head;
        if (length <= n) return head;

        int index = length - n;
        ListNode l2 = head;
        ListNode pre = new ListNode(0);
        for (int i = 0; i < index; i++) {
            pre = l2;
            l2 = l2.next;
        }
        pre.next = l2.next;
        return head;

    }


    public static class ListNode {
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
