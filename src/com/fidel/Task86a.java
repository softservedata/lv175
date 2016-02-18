package com.fidel;

public class Task86a {

    private static long number = 12398877899090L;
    private static int digitsQuantity = 0;
    //private static String stringNumber;

    public static void main(String[] args) {

        //stringNumber = Long.toString(number);

        System.out.print("Quantity of digits in number "+number);

        do {
            number /= 10;
            digitsQuantity++;
        }
        while( number > 0);

        System.out.println(" is "+digitsQuantity);

        //System.out.println(" is "+stringNumber.length());

    }
}
