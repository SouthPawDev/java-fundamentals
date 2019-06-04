package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
        if (i < 0) {throw new IllegalArgumentException();}
        int answer = 1;
        int n1 = 1, n2 = 1, n3 = 2;
        
        if(i > 0) {
        	for (int c = 1; c < i ; c++) {
        		answer = n3;
        		n1 = n2;
        		n2 = n3;
        		n3 = n1+n2;
        	}
        }
        
        return answer;
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
        if ((start < 0) || (end < 0) || (start > end)) {
        	throw new IllegalArgumentException();
        }
        int [] fib = new int[end];

        if(end > 0) {
        	fib[0] = 1;
        }
        if(end > 1) {
        	fib[1] = 1;
        }

        for(int i = 2; i < end; i++) {
           fib[i] = fib[i-1] + fib[i-2];
        }
        int [] answer = Arrays.copyOfRange(fib, start, end);
        return answer;
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
    	if (count < 0) {throw new IllegalArgumentException();}
    	
    	if((count == 0)) {
    		int[] answer = new int[0];
    		//answer[0] = 1;
    		return answer;
    	}else if ((count == 1)) {
    		int[] answer = new int[1];
    		answer[0] = 1;
    		return answer;
    	}else {
    		int[] answer = new int[count];
    		int n1 = 1, n2 = 1, n3 = 2;
        
            answer[0] = 1;
            answer[1] = 1;
            
            for (int c = 2; c < count; c++) {
                answer[c] = n3;
                n1 = n2;
                n2 = n3;
                n3 = n1 + n2;
            }
            return answer;
    	}
        
    }
}
