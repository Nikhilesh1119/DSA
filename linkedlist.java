
public class linkedlist {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = insert(3, head, 0);
        head = insert(2, head, 0);
        head = insert(1, head, 0);
        head = insert(4, head, 0);
        head = insert(1, head, 0);
        head = insert(2, head, 0);
        head = insert(3, head, 0);

        traverse(head);

        // Node rev=reverse(head);
        // traverse(rev);

        // System.out.println(ispalindrome(head));

        
    }

    static void traverse(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    static Node insert(int data, Node head, int pos) {
        Node toAdd = new Node(data);
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return head;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
        return head;
    }

    static Node delete(Node head, int pos) {
        if (pos == 0) {
            return head.next;
        }
        Node cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    static boolean ispalindrome(Node head) {
        Node mid = middle(head);
        Node last = reverse(mid);
        Node cur = head;
        while (last != null) {
            if (cur.data != last.data) {
                return false;
            }
            cur=cur.next;
            last=last.next;
        }
        return true;
    }

    static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
}
