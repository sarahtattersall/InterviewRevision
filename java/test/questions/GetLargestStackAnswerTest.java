package questions;

import com.st809.interview.questions.GetLargestStackAnswer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetLargestStackAnswerTest {

    @Test
    public void doesThisBreakIt() {
        GetLargestStackAnswer<Integer> stack = new GetLargestStackAnswer<Integer>();
        stack.push(1);
        assertEquals(new Integer(1), stack.getLargest());
        stack.push(6);
        assertEquals(new Integer(6), stack.getLargest());
        stack.push(10);
        assertEquals(new Integer(10), stack.getLargest());
        stack.push(8);
        assertEquals(new Integer(10), stack.getLargest());
        stack.pop();
        assertEquals(new Integer(8), stack.getLargest());
    }
}
