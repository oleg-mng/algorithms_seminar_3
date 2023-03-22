public class myDList {
    Node head;
    Node tail;

    private class Node {
        int value;
        Node next;
        Node prev;
    }

    public Node push(int pos, int value) {
        Node node = new Node();
        node.value = value;

        if (pos == 0) {
            if (head != null) {
                node.next = head;
                head.prev = node;
            } else {
                tail = node;
            }
            head = node;
            return node;
        }

        Node current = head;
        int index = 0;
        if (current == null) {
            head = node;
        } else {
            while (current != null && index < pos - 1) {
                current = current.next;
                index++;
            }
            Node next = current.next;
            if (next != null)
                next.prev = node;
            else
                tail = node;
            current.next = node;
            node.next = next;
            node.prev = current;
        }
        return node;
    }

    public void pop(int pos) {
        if (pos == 0) {
            if (head != null) {
                Node next = head.next;
                next.prev = null;
                head = next;
            }
            return;
        }
        Node current = head;
        int index = 0;
        while (current.next != null && index < pos - 1) {
            current = current.next;
            index++;
        }
        if (current.next.next == null) {
            current.next = null;
            tail = current;
            return;
        }

        Node next = current.next.next;
        current.next = next;
        next.prev = current;
    }

    public void sort() {
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            Node current = head;
            while (current != null) {
                if (current.next != null) {
                    if (current.value > current.next.value) {
                        Node prev = current.prev;
                        Node next = current.next.next;
                        Node node = current.next;

                        if (prev != null) {
                            prev.next = node;
                        }
                        else
                            head = node;
                        if (next != null){
                            next.prev = current;
                        }
                        else
                            tail = current;
                        current.next = next;
                        current.prev = node;
                        node.next = current;
                        node.prev = prev;

                        sorted = true;
                    }
                }
                current = current.next;
            }
        }
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    public void revertPrintList() {
        Node current = tail;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.prev;
        }
        System.out.println();
    }
}
