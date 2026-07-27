public class DoublyLinkedList {
    public static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int data;

    public void addFirst(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail =newNode;
            return;
        }

        newNode.next = head;
        head.prev= newNode;
        head = newNode;
    }

    public static void main(String[] args){
        DoublyLinkedList dd1 = new DoublyLinkedList();
        dd1.addFirst(3);
        dd1.addFirst(4);
        dd1.addFirst(5);

        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");

    }
}
