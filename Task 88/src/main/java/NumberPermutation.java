/**
 * This class implements permutation of first and last digit of a natural number
 */
public class NumberPermutation {

    /**
     * Executes permutation of first and last digit of a given number
     *
     * @param n natural number for which requires permutation
     * @return permutated number
     * @throws IllegalArgumentException if n is less than zero
     */
    public static int execute(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than zero");
        }

        // no need to calculation
        if (n < 10) {
            return n;
        }

        // get last and first digit
        int lastDigit = n % 10;

        int number = n / 10;

        int firstDigit = 0;
        int digitsCount = 1; // this is 10 * order of magnitude of n

        while (number > 0) {
            firstDigit = number % 10;
            number /= 10;
            digitsCount *= 10;
        }

        // shift digits
        int result = lastDigit*digitsCount + n%digitsCount - lastDigit + firstDigit;

        return result;
    }
}
