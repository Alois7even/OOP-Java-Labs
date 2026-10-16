import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private final List<T> items = new ArrayList<>();

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
}

public class GenericStack {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a"); s.push("b"); s.push("c");
        System.out.println("peek = " + s.peek());
        System.out.println("pop  = " + s.pop());
        System.out.println("pop  = " + s.pop());
        System.out.println("empty? " + s.isEmpty());

        Stack<Integer> n = new Stack<>();
        n.push(10);
        int top = n.pop();                              // no cast needed
        System.out.println("int stack popped " + top);

        try {
            n.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}