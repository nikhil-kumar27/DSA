import java.util.*;

public class BinaryTreePart1 {
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

    static class BuildBinaryTree {
        static int idx = -1;

        public static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;

        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null); // Marks the end of the current level

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();

                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        
        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh= height(root.right);

            return Math.max(lh, rh) +1;
        }

        public static int countNode(Node root){
            if(root == null){
                return 0;
            }

            int lc = countNode(root.left);
            int rc = countNode(root.right);

            return lc+rc+1;
        }

        public static int countSum(Node root){
            if(root == null){
                return 0;
            }

            int lc = countSum(root.left);
            int rc = countSum(root.right);

            return lc+rc+root.data;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BuildBinaryTree tree = new BuildBinaryTree();
        // Node root = tree.buildTree(nodes);

        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // System.out.println();

        // tree.levelOrder(root);

        // int height = tree.height(root);
        // System.out.println(height);

        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);

        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);

        // System.out.println(BuildBinaryTree.countNode(newNode) );

        System.out.println(BuildBinaryTree.countSum(newNode) );
    }
}
