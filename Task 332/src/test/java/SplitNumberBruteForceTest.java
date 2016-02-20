import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

/**
 * Created by krunch on 13.02.2016.
 */
public class SplitNumberBruteForceTest {

    @Test
    public void testExecute() throws Exception {
        int max = 10000;
        int tests = 100;
        Random r = new Random(47);

        for (int i = 0; i < tests; i++) {
            int n = r.nextInt(max);
            int[] result = SplitNumberBruteForce.execute(n);
            int sum = 0;
            for (int p : result) {
                sum += p*p;
            }
            assertEquals("Sum should be equal to number " + n, n, sum);
        }
    }
}