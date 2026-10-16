import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    // STATIC NESTED: a node needs no reference to the list
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) head = tail = node;
        else { tail.next = node; tail = node; }
        size++;
    }

    public int size() { return size; }

    // INNER CLASS: reads the outer list's 'head' directly
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override public boolean hasNext() { return current != null; }

        @Override public T next() {
            if (current == null) throw new NoSuchElementException();
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }
}

public class MyListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Ada"); list.add("Ben"); list.add("Cara");

        for (String s : list) {                        // works because of Iterable
            System.out.println(s);
        }
        System.out.println("Size: " + list.size());
    }
}