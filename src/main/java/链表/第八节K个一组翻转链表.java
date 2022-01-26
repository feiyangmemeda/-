package 链表;

public class 第八节K个一组翻转链表 {

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
        System.out.print("输入:");
        ListNode shuru = l1;
        while (shuru != null) {
            System.out.print(shuru.val);
            shuru = shuru.next;
        }
        ListNode result = reverseKGroup(l1, 2);
        System.out.println();
        System.out.print("输出:");
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }


    static int num = 1;

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        // 先计算链表长度
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode != null) {
            ++length;
            lengthNode = lengthNode.next;
        }
        // 递归,剩余节点数小于k弹出
        if (length - k * num < 0) {
            return head;
        }
        // 反转k之前的
        ListNode pre = null;
        ListNode next;
        int index = 0;
        ListNode dummy = head;
        while (index < k * num) {
            if (num == 1) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                index++;
            } else if (index >= k * (num - 1)) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                index++;
            } else {
                //pre = head;
                head = head.next;
                index++;
            }
        }
        // dummy为反转切割前切断的链表,去掉尾巴,接上pre
        if (dummy.next != null) {
            ListNode q = dummy;
            while (q.next.next != null) {
                q = q.next;
            }
            q.next = pre;
        } else {
            dummy = pre;
        }
        // 接上head
        ListNode reversed = dummy;
        ListNode lastOne = null;
        while (reversed != null) {
            lastOne = reversed;
            reversed = reversed.next;
        }
        lastOne.next = head;
        num++;
        return reverseKGroup(dummy, k);


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
