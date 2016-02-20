import java.util.*;

/**
 * Created by krunch on 13.02.2016.
 */
public class SplitNumberBruteForce {

    public static int[] execute(int n) {
        int[] result = new int[4];

        int t = (int) Math.sqrt(n);
        search:
        for (int i = 0; i <= t; i++) {
            for (int j = 0; j <= t; j++) {
                for (int k = 0; k <= t; k++) {
                    for (int p = 0; p <= t; p++) {
                        if (i * i + j * j + k * k + p * p == n) {
                            result[0] = i;
                            result[1] = j;
                            result[2] = k;
                            result[3] = p;
                            break search;
                        }
                    }
                }
            }
        }

        return result;

    }

}
