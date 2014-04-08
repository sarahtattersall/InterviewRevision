package questions;

import com.st809.interview.questions.TwoStackQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class TwoStackQueueTest {
    TwoStackQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new TwoStackQueue<Integer>();
    }

    @Test
    public void singleItem() {
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.dequeue());
    }

    @Test
    public void FIFO() {
        for (int i = 0; i < 4; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 4; i++) {
            assertEquals(new Integer(i), queue.dequeue());
        }
    }

    @Test
    public void dequeEmptyReturnsNull() {
        assertNull(queue.dequeue());
    }

    @Test
    public void randomPushPop() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        queue.enqueue(5);
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());


    }
}
