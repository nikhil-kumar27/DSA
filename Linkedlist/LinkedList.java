public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }

        tail.next = newNode;
        tail = newNode;
        size++;

    }

    public void add(int indx, int data) {
        if (indx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        int i = 0;
        while (i < indx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void print() { // need to see in video
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.err.println("null");
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty!!");
        }

        if (size == 1) {
            int val = head.data;
            head = tail = head.next;
            size--;
            System.out.println("removed" + val);
            return;
        }

        int val = head.data;
        head = head.next;
        System.out.println("removed " + val);
        size--;
    }

    public void removeLast() { // need to think && incomplete
        if (size == 0) {
            System.out.println("LL is empty!!");
            size--;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = head.next;
            System.out.println("removed " + val);
            size--;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // int val = temp.data;
        // temp.prev.next = null;
    }

    public int itSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;

    }

    public int recSearchHelper(Node head, int key) {
        if (head == null)
            return -1;

        if (head.data == key)
            return 0;

        int idx = recSearchHelper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {

        return recSearchHelper(head, key);
    }

    public void reverse() {

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public Node findMid() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPallindrome() {

        Node mid = findMid();

        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while (right != null) {

            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle() {

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle)
            return;

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;

    }

    public static Node merge(Node leftHead, Node rightHead) {

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHead != null && rightHead != null) {

            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }

        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public static Node mergeSort(Node head) {

        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);

    }

    public static void zigzag(Node head) {

        if (head == null || head.next == null)
            return;

        // Step 1: Find middle
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Break the list
        Node curr = slow.next;
        slow.next = null;

        // Step 3: Reverse second half
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4: Alternate merge
        Node left = head;
        Node right = prev;

        while (left != null && right != null) {

            Node nextL = left.next;
            Node nextR = right.next;

            left.next = right;

            if (nextL == null)
                break;

            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(); // need to see in video
        l1.addFirst(10);
        l1.addFirst(5);
        l1.addFirst(2);
        l1.addLast(11);
        l1.addLast(10);
        l1.addLast(5);
        l1.addLast(2);
        l1.addLast(12);

        Node sortedLL = mergeSort(head);

        Node temp = sortedLL;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");

        zigzag(head);

        Node temp1 = head;
        while (temp1 != null) {
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }

        System.out.println("null");

    }
}
