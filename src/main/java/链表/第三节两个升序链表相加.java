package 链表;


public class 第三节两个升序链表相加 {


    private static ListNode gen1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        return l1;
    }

    private static ListNode gen2() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = gen1();
        ListNode l2 = gen2();
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }

        ListNode newNode = head.next;

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
