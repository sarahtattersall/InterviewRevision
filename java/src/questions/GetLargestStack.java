package questions;

import com.st809.interview.datastructures.node.Node;

/**
 * An extended stack class that has a function getLargest() for returning the largest element in the stack.
 *
 * Gotchas:
 * What if we push several items in increasing numeric order (e.g. 1,2,3,4...), so that there is a new largest after
 * each push()? What if we then pop() each of these items off, so that there is a new largest after each pop()?
 * The algorithm shouldn't pay a steep cost in these edge cases.
 */
public class GetLargestStack<T extends Comparable<T>> {
    Node<T> head;
    T largest;

    public void push(T item) {
        if (head == null) {
            largest = item;
            head = new Node<T>(item);
        } else {
            if (item.compareTo(largest) > 0) {
                largest = item;
            }
            head = new Node<T>(item, head);
        }
    }

    public T getLargest() {
        return largest;
    }

    public T pop() {
        if (head == null) {
            return null;
        }

        T returnValue = head.getItem();
        head = head.getNext();

        if (returnValue.equals(largest)) {
            largest = findLargest();
        }
        return returnValue;
    }

    private T findLargest() {
        if (head == null) {
            return null;
        }

        T newLargest = head.getItem();
        Node<T> compareNode = head.getNext();
        while (compareNode != null) {
            if (compareNode.getItem().compareTo(newLargest) > 0) {
                newLargest = compareNode.getItem();
            }
            compareNode = compareNode.getNext();
        }
        return newLargest;
    }
}
