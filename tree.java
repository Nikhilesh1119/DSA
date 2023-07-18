import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.*;

public class tree {

    static Scanner sc = null;

    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        // Node root = createTree();
        Node root = new Node(2);

        root.left = new Node(4);
        root.right = new Node(1);

        root.left.left = new Node(7);
        root.left.right = new Node(14);
        root.right.left = new Node(8);
        root.right.right = new Node(3);

        root.left.left.right = new Node(15);
        root.left.right.left = new Node(10);
        root.right.left.right = new Node(6);
        root.right.right.right = new Node(5);

        root.left.left.right.right = new Node(19);

        // inorder(root);
        // System.out.println();
        // preorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();
        // levelorder(root);
        // System.out.println();

        // System.out.println(hight(root));
        // System.out.println(size(root));
        // System.out.println(maximum(root));
        // System.out.println(minimum(root));
        // System.out.println(diameter(root));
        // System.out.println(burntree(root,14));

        // Node ans=lowestCommonAncestor(root, 19,10);
        // System.out.println(ans.data);

        // printleftview(root);
        // printrightview(root);
        // topview(root);
        // bottomview(root);
    }

    static Node createTree() {
        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        root = new Node(data);
        System.out.println("Enter left for " + data);
        root.left = createTree();
        System.out.println("Enter right for " + data);
        root.right = createTree();
        // inorder(root);
        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelorder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    static int hight(Node root) {
        if (root == null)
            return 0;
        return Math.max(hight(root.left), hight(root.right) + 1);
    }

    static int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    static int maximum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    static int minimum(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    static void printleftview(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        leftview(root, list, 0);
        for (Node cur : list) {
            System.out.print(cur.data + " ");
        }
    }

    static void leftview(Node root, ArrayList<Node> list, int level) {
        if (root == null)
            return;
        if (level == list.size())
            list.add(root);
        leftview(root.left, list, level + 1);
        leftview(root.right, list, level + 1);
    }

    static void printrightview(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        rightview(root, list, 0);
        for (Node cur : list) {
            System.out.print(cur.data + " ");
        }
    }

    static void rightview(Node root, ArrayList<Node> list, int level) {
        if (root == null)
            return;
        if (level == list.size())
            list.add(root);
        rightview(root.right, list, level + 1);
        rightview(root.left, list, level + 1);
    }

    static void topview(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!map.containsKey(cur.hd)) {
                map.put(cur.hd, cur.node.data);
            }
            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }
        // ArrayList<Integer> ans=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // ans.add(entry.getValue());
            System.out.print(entry.getValue() + " ");
        }
    }

    static void bottomview(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            map.put(cur.hd, cur.node.data);
            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }
        // ArrayList<Integer> ans=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // ans.add(entry.getValue());
            System.out.print(entry.getValue() + " ");
        }
    }

    static int diameter(Node root) {
        if (root == null)
            return 0;
        int dl = diameter(root.left);
        int dr = diameter(root.right);
        int cur = height(root.left) + height(root.right) + 1;
        return Math.max(cur, Math.max(dl, dr));
    }

    static int answer = 0;

    static int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        answer = Math.max(answer, lh + rh + 1);
        return 1 + Math.max(lh, rh);
    }

    static Node lowestCommonAncestor(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node leftNode = lowestCommonAncestor(root.left, n1, n2);
        Node rightNode = lowestCommonAncestor(root.right, n1, n2);
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }

    // static int maxtime;
    // static int burntree(Node root,int target){
    // maxtime=0;
    // burntime(root,target,0);
    // return maxtime;
    // }
    // static int burntime(Node root,int target,int depth){
    // if(root==null)return 0;if(root.data==target)

    // {
    // maxtime = Math.max(maxtime, depth);
    // return 1;
    // }
    // int l = burntime(root.left, target, depth + 1);
    // int r = burntime(root.right, target, depth + 1);if(l>0||r>0)
    // {
    // maxtime = Math.max(maxtime, Math.max(l, r) + depth);
    // return Math.max(l, r) + 1;
    // }return 0;
    // }

}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}