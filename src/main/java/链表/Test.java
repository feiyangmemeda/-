package 链表;

public class Test {


    public static void main(String[] args) {
        long result = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <2000){
            result++;
        }
        System.out.println(result);
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
