package 链表;

public class 第一节把数组转为链表 {
    private static int[] array = {1, 2, 3, 4, 5, 6};

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode convert2ListNode(int[] array) {
        // 一般都会建一个头指针
        ListNode pre = new ListNode(0);
        // 这个cur会在循环中无限被替换
        ListNode cur = pre;
        for (int i = 0; i < array.length; i++) {
            // 新建一个指针
            ListNode temp = new ListNode(array[i]);
            // 把上一步创建出来的指针赋值到cur.next中
            cur.next = temp;
            // 此时
            cur = temp;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = convert2ListNode(array);
        while (listNode != null ){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }



}
