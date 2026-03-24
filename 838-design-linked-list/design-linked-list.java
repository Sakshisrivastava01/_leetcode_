class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head, tail;
    int x;

    public MyLinkedList() {
        head = tail = null;
        x = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= x) return -1;

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.val;
    }

    public void addAtHead(int val) {
        Node nextnode = new Node(val);
        if (head == null) {
            head = tail = nextnode;
        } else {
            nextnode.next = head;
            head = nextnode;
        }
        x++;
    }

    public void addAtTail(int val) {
        Node nextnode = new Node(val);
        if (head == null) {
            head = tail = nextnode;
        } else {
            tail.next = nextnode;
            tail = nextnode;
        }
        x++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > x) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == x) {
            addAtTail(val);
            return;
        }

        Node nextnode = new Node(val);
        Node temp = head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        nextnode.next = temp.next;
        temp.next = nextnode;

        x++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= x) return;

        if (index == 0) {
            head = head.next;
            x--;
            if (x == 0) tail = null;
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        temp.next = temp.next.next;

        if (temp.next == null)
            tail = temp;

        x--;
    }
}