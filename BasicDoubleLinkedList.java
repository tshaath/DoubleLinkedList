import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> {
    protected Node head = null;
    protected Node tail = null;
    protected int numOfEntries = 0;


    public boolean isEmpty() {
        if (head == null && tail == null) return true;
        else return false;
    }

    public void addToFront(T dataEntry) {
        Node newObject = new Node(dataEntry);
        if (isEmpty()) {
            tail = newObject;
            head = newObject;
            numOfEntries++;
        } else {
            head.prev = newObject;
            newObject.next = head;
            head = newObject;
            numOfEntries++;
        }

    }

    public void addToEnd(T dataEntry) {
        Node newObject = new Node(dataEntry);
        if (isEmpty()) {
            tail = newObject;
            head = newObject;
            numOfEntries++;
        } else {
            newObject.prev = tail;
            tail.next = newObject;
            tail = newObject;
            numOfEntries++;
        }

    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.data;
    }

    public int getSize() {
        return numOfEntries;
    }

    //Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators
    public T retrieveFirstElement() {
        if (isEmpty())
            return null;
        else {
            Node tempNode = head;
            head = head.next;
            numOfEntries--;
            return tempNode.getData();

        }
    }

    public T retrieveLastElement() {
        if (isEmpty())
            return null;
        else {
        Node tempNode = tail;
        tail = tail.prev;
        numOfEntries--;
        return tempNode.getData();}
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public Node remove(T targetData, Comparator comparator) {
        Node tempNode= head;
        while (tempNode!=null)
        {
            if (comparator.compare(tempNode.getData(), targetData)==0)
            {
                if(tempNode==head)
                {
                    head=head.next;
                } else if (tempNode==tail) {
                    tail=tail.prev;

                }
             else
             {
                 tempNode.prev.next=tempNode.next;
                 tempNode.next.prev=tempNode.next;

             }
                numOfEntries--;
                return tempNode;
            }
            tempNode=tempNode.next;
        }

        return null;


    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList();
        Node temp = head;
        while (temp != null) {
            arrayList.add(temp.getData());
            temp = temp.next;
        }
        return arrayList;
    }

    //Inner class Iterator
    private class DoubleLinkedListIterator implements ListIterator<T> {
        protected Node nextNode;
        protected Node previousNode;

        public DoubleLinkedListIterator() {
            nextNode = head;
            previousNode = null;
        }

        public T next() throws NoSuchElementException {
            if (hasNext()) {
                Node current = nextNode;
                nextNode = current.next;
                previousNode = current;
                return current.getData();
            } else throw new NoSuchElementException();

        }

        public boolean hasNext() {
            if (nextNode == null) return false;
            else return true;

        }

        public T previous() throws NoSuchElementException {
            if (hasPrevious()) {
                Node current = previousNode;
                nextNode = current;
                previousNode = current.prev;
                return current.getData();
            } else throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            if (previousNode == null) return false;
            else return true;
        }

        public void add(T dataEntry) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();


        }

        public void set(T dataEntry) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }

        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }


        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

    // Inner class Node
    protected class Node {
        protected T data;
        protected Node next;
        protected Node prev;

        protected Node(T dataEntry) {
            this(dataEntry, null, null);
        }

        protected Node(T dataEntry, Node nextNode, Node previousNode) {
            data = dataEntry;
            next = nextNode;
            prev = previousNode;

        }

        protected Node getNextNode() {
            return next;
        }

        protected T getData() {
            return data;
        }

    }
}
