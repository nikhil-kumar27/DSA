import java.util.*;

public class BinaryTreePart2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(rh, lh) + 1;
    }

    public static int diameter1(Node root) { // O(n^2)
        if (root == null)
            return 0;

        int ld = diameter1(root.left);
        int rd = diameter1(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int gd = Math.max(ld, rd);
        return Math.max(gd, lh + rh + 1);
    }

    static class info {
        int dia;
        int ht;

        info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static info diameter2(Node root) { // O(n)
        if (root == null)
            return new info(0, 0);

        info leftinfo = diameter2(root.left);
        info rightinfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.ht + rightinfo.ht + 1);

        int ht = Math.max(leftinfo.ht, rightinfo.ht) + 1;

        return new info(dia, ht);

    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null)
            return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            // Store only the first node at each horizontal distance
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }

            if (curr.node.left != null) {
                q.offer(new Pair(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.offer(new Pair(curr.node.right, curr.hd + 1));
            }
        }

        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);

        root.left.right.right = new Node(9);
        root.left.right.right.right = new Node(10);

        // int d = diameter1(root);

        // System.out.println(d);
        // System.out.println(diameter2(root).dia);

        // Node subroot = new Node(3);
        // subroot.left = new Node(6);
        // subroot.right = new Node(7);

        // System.out.println(isSubtree(root, subroot));`

        topView(root);
    }

}
