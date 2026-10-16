import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> items = new ArrayList<>();   // HAS-A list, hidden from callers

    public void push(T item) { items.add(item); }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public int size()        { return items.size(); }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3);
        System.out.println("peek = " + s.peek());
        System.out.println("pop  = " + s.pop());
        System.out.println("pop  = " + s.pop());
        System.out.println("size = " + s.size());
        // s.add(0, 99);   // COMPILE ERROR: no such method
    }
}