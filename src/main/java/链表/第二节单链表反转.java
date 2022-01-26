package 链表;

public class 第二节单链表反转 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    static ListNode initializeListNode() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i <= 10; i++) {
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = temp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode oldNode = initializeListNode();

        ListNode pre = null;
        ListNode nextNode = new ListNode(0);

        while (oldNode != null) {
            nextNode = oldNode.next;
            oldNode.next = pre;
            pre = oldNode;
            oldNode = nextNode;
        }
        ListNode reversedListNode = pre;
        while (reversedListNode != null ){
            System.out.println(reversedListNode.val);
            reversedListNode = reversedListNode.next;
        }
    }

}
