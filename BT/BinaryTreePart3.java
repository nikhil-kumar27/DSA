public class BinaryTreePart3 {

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

    public static void kthLevel(Node root, int level, int k) {

        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static Node lca(Node root, int n1, int n2) {

        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if (leftLca != null && rightLca != null)
            return root;

        if (leftLca != null)
            return leftLca;

        return rightLca;
    }

    public static int distance(Node root, int n) {

        if (root == null)
            return -1;

        if (root.data == n)
            return 0;

        int left = distance(root.left, n);

        if (left != -1)
            return left + 1;

        int right = distance(root.right, n);

        if (right != -1)
            return right + 1;

        return -1;
    }

    public static int minDistance(Node root, int n1, int n2) {

        Node ancestor = lca(root, n1, n2);

        int d1 = distance(ancestor, n1);
        int d2 = distance(ancestor, n2);

        return d1 + d2;
    }

    public static int kthAncestor(Node root, int node, int k) {

        if (root == null)
            return -1;

        if (root.data == node)
            return 0;

        int leftDist = kthAncestor(root.left, node, k);
        int rightDist = kthAncestor(root.right, node, k);

        if (leftDist == -1 && rightDist == -1)
            return -1;

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println("Kth Ancestor = " + root.data);
        }

        return max + 1;
    }

    public static int transform(Node root) {

        if (root == null)
            return 0;

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldValue = root.data;

        root.data = leftSum + rightSum;

        return oldValue + root.data;
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

        int k = 3;
        kthLevel(root, 1, k);

        int lca = lca(root, 04, 9).data;
        System.out.println(lca);

        System.out.println(minDistance(root, 4, 6));
        System.out.println(minDistance(root, 4, 5));

        kthAncestor(root, 8, 2);

        transform(root);

        inorder(root);

    }

}
