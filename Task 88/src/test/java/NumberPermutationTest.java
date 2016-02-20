import static org.junit.Assert.*;


/**
 * Created by krunch on 13.02.2016.
 */
public class NumberPermutationTest {

    @org.junit.Test
    public void testExecute() throws Exception {
        assertEquals(5, NumberPermutation.execute(5));

        assertEquals(321, NumberPermutation.execute(123));

        assertEquals(52341, NumberPermutation.execute(12345));
    }


}