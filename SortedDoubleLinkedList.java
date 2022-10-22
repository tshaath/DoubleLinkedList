import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList {
    private Comparator comparator;

    SortedDoubleLinkedList(Comparator ComparableObject) {
        comparator = ComparableObject;
    }

    public void add(T dataEntry) {
        Node newNode = new Node(dataEntry);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            numOfEntries++;
            return;
        }

        Node current = head;

        // we stop when next data > current

        while(current!= null && comparator.compare(dataEntry, current.getData()) > 0) {
            current = current.next;
        }
        if (current == head){
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        } else if (current == null) {
            // we are at the tail (add new node to tail)
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        numOfEntries++;

    }

    public void addToEnd(Object dataEntry) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void addToFront(Object dataEntry) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public ListIterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public Node remove(Object targetData, Comparator comparator) {
        return super.remove(targetData, comparator);
    }
}
