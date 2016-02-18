package com.fidel;

public class Task330 {

    private static long number = 10000;

    public static void main(String[] args) {

        System.out.println("Perfect numbers between 0 and "+number);
        for (long i = 1; i < number; i++){

            if( isPerfect(i) ){

                System.out.println(i);
            }
        }
    }

    private static boolean isPerfect(long number) {

        long divider = number - 1;
        long sum = 0;
        while (divider > 0) {

            if ((number % divider) == 0) {
                sum += divider;

                if (sum > number)
                    return false;
            }

            divider--;
        }

        return sum == number;
    }
}