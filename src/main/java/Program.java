public class Program {
    public static void main(String[] args) {
        myDList l = new myDList();
        l.push(0, 1);
        l.push(1,2);
        l.push(0, 3);
        l.push(1, 4);
        l.push(4,5);

        l.sort();
        l.printList();
        l.revertPrintList();
    }
}
