import java.util.ArrayList;

public class BST_Part1 {

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

    public static Node BuildBST(Node root, int val) {

        if (root == null)
            return root = new Node(val);

        if (val > root.data)
            root.right = BuildBST(root.right, val);

        if (val < root.data)
            root.left = BuildBST(root.left, val);

        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);

    }

    public static Node InorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int key) { // --isko fir se dekhna hai, nhi smjh aaya--
        if (root == null)
            return null;
        if (root.data > key)
            root.left = delete(root.left, key);
        else if (root.data < key)
            root.right = delete(root.right, key);

        else {
            if (root.left == null && root.right == null)
                return null;

            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;

    }

    public static void printInRange(Node root, int k1, int k2) { // dekhna padega fir se
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data);
            printInRange(root.right, k1, k2);

        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                System.out.println(path.get(i));
            } else {
                System.out.print(path.get(i) + "->");
            }
        }
    }

    public static void root2leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){ // dekhna hai isko
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }else if (max!= null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void mirror(Node root){ //
        if(root == null) return;

        Node temp= root.left;
        root.left = root.right;
        root.right= temp;

        mirror(root.left);
        mirror(root.right);

        return;
    }



    public static void main(String[] args) {
        Node root = null; // --how does this work and why we didnt use normal node creation method--

        int arr[] = { 1, 2, 3, 9, 5, 6, 7 };

        for (int i = 0; i < arr.length; i++) {
            root = BuildBST(root, arr[i]);
        }

        // inorder(root);

        // System.out.println(search(root,10));

        // delete(root, 9);

        // inorder(root);

        // printInRange(root, 0, 8);

        // root2leaf(root, new ArrayList<>());

        // Node root2 = new Node(5);
        // root2.left = new Node(7);
        // root2.right = new Node(4);
        // System.out.println(isValidBST(root, null, null));

        inorder(root);
        mirror(root);
        inorder(root);



    }

}


// for any code if using recursion, first write recursive part then think about base case.
// always draw tree if possible and first dry run then write code. always think what question asks and what can i do in recursion. 