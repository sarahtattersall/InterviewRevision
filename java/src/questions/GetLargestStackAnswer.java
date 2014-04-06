package questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class GetLargestStackAnswer<T extends Comparable<T>> {
    Deque<T> stack = new ArrayDeque<T>();
    Deque<T> largestStack = new ArrayDeque<T>();

    public void push(T item) {
        stack.push(item);
        if (largestStack.isEmpty()) {
            largestStack.push(item);
        } else if (item.compareTo(largestStack.peek()) > 0) {
            largestStack.push(item);
        }
    }

    public T getLargest() {
        return largestStack.peek();
    }

    public T pop() {
        T item = stack.pop();
        if (item.equals(largestStack.peek())) {
            largestStack.pop();
        }
        return item;
    }
}
