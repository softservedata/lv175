package com.fidel;

public class Task182 {

    private static long[] numbers = {10, 35, 8, 70, 34, 25, 55};
    private static int quantity = 0;
    private static long sum = 0;

    public static void main(String[] args) {

        for(long number : numbers){

            if((number % 5 == 0) && (number % 7) != 0){

                sum += number;
                quantity++;

            }
        }

        System.out.println("Quantity of numbers which are divisible by 5 and aren't divisible by 7 by integer = "+quantity);
        System.out.println("And the sum of this elements = "+sum);

    }
}