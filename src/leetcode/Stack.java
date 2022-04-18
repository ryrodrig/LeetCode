package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if(items.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return items.remove(items.size()-1);
    }

    public  boolean isEmpty() {
        return items.isEmpty();
    }
}
