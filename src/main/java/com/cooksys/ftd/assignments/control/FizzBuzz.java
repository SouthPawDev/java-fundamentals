package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * FizzBuzz is an old programming exercise.
 * The goal is to iterate over a range of numbers and print a message about each number's divisibility.
 * <p>
 * The message is generated the following way:
 * *) if the number is divisible by three, the message is `Fizz`
 * *) if the number is divisible by five, the message is `Buzz`
 * *) if the number is divisible by both three and five, the message is `FizzBuzz`
 * *) otherwise, no message is produced
 * <p>
 * The exact message format for this assignment is specified in the `message(n)` method.
 */
public class FizzBuzz {

    /**
     * Checks whether a given int `a` is evenly divisible by a given int `b` or not.
     * For example, `divides(4, 2)` returns `true` and `divides(4, 3)` returns `false`.
     *
     * @param a the number to be divided
     * @param b the number to divide by
     * @return `true` if a is evenly divisible by b, `false` otherwise
     * @throws IllegalArgumentException if b is zero
     */
    public static boolean divides(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
        	throw new IllegalArgumentException();
        }else if (a % b == 0) {
        	return true;
        }else {
        	return false;
        }
    }

    /**
     * Generates a divisibility message for a given number. Returns null if the given number is not divisible by 3 or 5.
     * Message formatting examples:
     * 1 -> null // not divisible by 3 or 5
     * 3 -> "3: Fizz" // divisible by only 3
     * 5 -> "5: Buzz" // divisible by only 5
     * 15 -> "15: FizzBuzz" // divisible by both three and five
     *
     * @param n the number to generate a message for
     * @return a message according to the format above, or null if n is not divisible by either 3 or 5
     */
    public static String message(int n) {
        //throw new NotImplementedException();
        String msg = null;
        if((n % 3 == 0 ) ^ (n % 5 == 0)) {
        	if (n % 3 == 0) {
        		msg = n + ": Fizz";
        	}else {
        		msg = n + ": Buzz";
        	}
        }else if ((n % 3 == 0) && (n % 5 == 0) && (n != 0)){
        	msg = n + ": FizzBuzz";
        }
        
        return msg;
    }

    /**
     * Generates an array of messages to print for a given range of numbers.
     * If there is no message for an individual number (i.e., `message(n)` returns null),
     * it should be excluded from the resulting array.
     *
     * @param start the number to start with (inclusive)
     * @param end the number to end with (exclusive)
     * @return an array of divisibility messages
     * @throws IllegalArgumentException if the given end is less than the given start
     */
    public static String[] messages(int start, int end) throws IllegalArgumentException {
    	if ( start > end) {
        	throw new IllegalArgumentException();
        }
    	
    	int c = 0;
    	int count = 0;
    	//String[] msgs = new String[end - start];
        for (int q = start; q < end; q++) {
        	if (message(q) != null) {
        		//msgs[c] = message(i);
        		count++;
        	}
        }
        	
        String[] msgs = new String[count];
        for (int i = start; i < end; i++) {
        	if (message(i) != null) {
        		msgs[c] = message(i);
        		c++;
        	}
        	
        }
        
        return msgs;
    }

    /**
     * For this main method, iterate over the numbers 1 through 115 and print
     * the relevant messages to sysout
     */
    public static void main(String[] args) {
        //throw new NotImplementedException();
    	for (String i : messages(1, 116)) {
    		System.out.println(i);
    	}
    }

}
