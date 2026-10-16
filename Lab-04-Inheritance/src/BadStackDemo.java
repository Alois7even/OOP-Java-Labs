import java.util.ArrayList;

class BadStack<T> extends ArrayList<T> {
    void push(T item) { add(item); }
    T pop()           { return remove(size() - 1); }
}

public class BadStackDemo {
    public static void main(String[] args) {
        BadStack<Integer> s = new BadStack<>();
        s.push(1); s.push(2); s.push(3);

        s.add(0, 99);            // inserts at the BOTTOM of a stack
        s.remove(1);             // removes from the MIDDLE
        System.out.println(s);   // [99, 2, 3]
    }
}