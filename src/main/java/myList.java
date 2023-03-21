public class myList {
    Node head;

    private class Node{
        int value;
        Node next;
    }
    public Node push(int pos, int value){
        Node current = head;
        int index =0;
        while (current != null && index < pos -1){
            current = current.next;
            index++;
        }
        Node node = new Node();
        node.value = value;
        if (current == null){
            head = node;
        }
        else {
            Node next = current.next;
            current.next = node;
            node.next = next;
        }
        return node;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }
}
