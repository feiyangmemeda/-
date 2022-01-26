package 链表;

public class 第五节两数相加 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = head;
        int num = 0;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = num + value1 + value2;
            if (head == null) {
                head = new ListNode(sum % 10);
                pre = head;
            } else {
                pre.next = new ListNode(sum % 10);
                pre = pre.next;
            }
            num = sum/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(num > 0){
            pre.next = new ListNode(num);
        }
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
