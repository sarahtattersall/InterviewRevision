package questions;

import com.st809.interview.questions.GetLargestStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetLargestStackTest {
    GetLargestStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new GetLargestStack<Integer>();
    }

    @Test
    public void singleItem() {
        stack.push(1);
        assertEquals(new Integer(1), stack.getLargest());
    }

    @Test
    public void ascendingOrderItems() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals(new Integer(i), stack.getLargest());
        }
    }


    @Test
    public void descendingOrderItems() {
        for (int i = 4; i >= 0; i--) {
            stack.push(i);
            assertEquals(new Integer(4), stack.getLargest());
        }
    }

    @Test
    public void removeLargest() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        stack.pop();
        assertEquals(new Integer(3), stack.getLargest());
    }

}
