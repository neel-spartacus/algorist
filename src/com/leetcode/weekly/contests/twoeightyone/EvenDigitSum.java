package com.leetcode.weekly.contests.twoeightyone;
//https://leetcode.com/problems/count-integers-with-even-digit-sum/
public class EvenDigitSum {

    public static int evenSum(int num){
        int temp = num, sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0 ? temp / 2 : (temp - 1) / 2;
    }

    public int countEven(int num)
    {
        int count = 0;
        for(int i = 1; i <= num; i++)
            if(sumDig(i))
                count++;
        return count;
    }
    private boolean sumDig(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return (sum&1) == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(evenSum(19));
    }
}
