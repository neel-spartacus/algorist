package io.algoexpert.easy;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoNumbersSumWithHashTable {

    public static void main(String args[]) throws Exception {

        int[] arrayOfNumbers = new int[]{3, 5, -4, 8, 1, 11, -1, 6};
        int sum = 10;
        int[] sortedArray = twoNumberSum(arrayOfNumbers, sum);
        System.out.println(sortedArray.toString());

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Hashtable<Integer, Boolean> numbersTable = new Hashtable<>();
        int[] twoNumbers = {};
        for (int i = 0; i < array.length; i++) {
            int x = targetSum - array[i];
            if (numbersTable.keySet().contains(new Integer(x))) {
                twoNumbers = (new int[]{x, array[i]});
                Arrays.sort(twoNumbers);
                break;
            } else {
                numbersTable.put(new Integer(array[i]), Boolean.TRUE);
            }
        }
        return twoNumbers;
    }


}
