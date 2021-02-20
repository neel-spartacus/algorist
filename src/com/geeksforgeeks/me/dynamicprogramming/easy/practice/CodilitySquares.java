package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class CodilitySquares {

    private static int squareLength(int[] A) {
        int maxLen = 1;
        try {
            int len = A.length;


            if (len < 0 || len > 100000) {
                throw new RuntimeException();
            }
            for (int k : A) {
                if (k < 0 || k > len) {
                    throw new RuntimeException();
                }
            }


            for (int i = 0; i < len; i++) {
                int count = 1;
                for (int j = i + 1; j < len; j++) {
                    count += 1;
                    if (count <= Math.min(A[i], A[j])) {
                        int p = i;
                        int q = j;
                        boolean bool = true;
                        while (q - p >= 1) {
                            if (count <= A[p]) {
                                p += 1;
                                continue;
                            } else {
                                bool = false;
                                break;
                            }

                        }
                        if (bool) {
                            maxLen = Math.max(maxLen, count);
                        }


                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("Invalid input" + ex.getMessage());
        }

        return maxLen;
    }

    public static void main(String[] args) {
        //int[] arr={1,2,5,3,1,3};
        int[] arr = {6, 5, 5, 6, 2, 2};
        System.out.println(squareLength(arr));
    }
}
