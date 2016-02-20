import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by krunch on 13.02.2016.
 */
public class PrimeDivisorsTest {

    @org.junit.Test
    public void testExecute() throws Exception {
        List<Integer> result = PrimeDivisors.execute(10);
        assertThat(result, contains(2, 5));
        assertThat(result.size(), is(2));

        result = PrimeDivisors.execute(15);
        assertThat(result, contains(3, 5));
        assertThat(result.size(), is(2));


        result = PrimeDivisors.execute(140);
        assertThat(result, contains(2, 5, 7));
        assertThat(result.size(), is(3));

        result = PrimeDivisors.execute(57);
        assertThat(result, contains(3, 19));
        assertThat(result.size(), is(2));
    }


    @org.junit.Test
    public void testExecuteBruteForce() throws Exception {
        int max = 1250;
        int tests = 50;

        Random r = new Random(47);
        for (int i = 0; i < tests; i++) {
            int n = r.nextInt(max) + 2;
            List<Integer> actual = PrimeDivisors.execute(n);
            List<Integer> expected = primeDivisorsBruteForce.execute(n);

            assertEquals("Number " + n, expected, actual);
        }
    }

    static class primeDivisorsBruteForce {
        static List<Integer> execute(int n) {
            List<Integer> result = new ArrayList<Integer>();
            if (n % 2 == 0) {
                result.add(2);
            }
            for (int i = 3; i < n / 2; i = i + 2) {
                if ((isPrime(i)) && (n % i == 0)) {
                    result.add(i);
                }
            }

            return result;
        }

        static boolean isPrime(int n) {
            for (int i = 3; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

}