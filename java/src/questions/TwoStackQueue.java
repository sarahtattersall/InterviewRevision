package questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement a queue with 2 stacks
 * Your queue should have an enqueue and a dequeue funciton and it should be "first in first out" (FIFO)
 * Optimize for the time cost of m function calls on your queue. These can be any mix of enque and dequeue calls
 * Assume you have a stack implementation and it gives O(1) time push and pop
 *
 * Complexity:
 * O(1) enqueue
 * O(1) dequeue if items in popStack
 * O(m) dequeue if no items in popStack
 * We work this out with the accounting method. It simply lookat at the time cost incurred by each item passing
 * through the system instead of the time cost of each operation. This then works out the complexity for things like
 * "the cost of m operations on this data structure" Thus:
 * For a single item the worst case is it enqueued and then later dequeued. In this case the item enters pushStack
 * (cost = 1 push), then later moves to popStack (cost = 1 pop + 1 push), then later comes out of outStack to get
 * returned (cost = 1 pop). Each of these is O(1) so total cost per item is O(1). Our m enqueue and dequeue operations
 * put m or fewer items into the system giving a total running time of O(m)!
 *
 */

public class TwoStackQueue<T> {

    Deque<T> pushStack = new ArrayDeque<T>();
    Deque<T> popStack = new ArrayDeque<T>();

    public void enqueue(T item) {
        pushStack.push(item);

    }

    public T dequeue() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            return null;
        }

        if (!popStack.isEmpty()) {
            return popStack.pop();
        }

        while(!pushStack.isEmpty()) {
            T item = pushStack.pop();
            popStack.push(item);
        }

        return popStack.pop();
    }

}
