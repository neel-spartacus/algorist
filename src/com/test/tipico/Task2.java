package com.test.tipico;

public class Task2 {

    public static int solution(int A, int B) {

        int mod= (int) 1e9;
        if(A<4 && B<4 && A+B >= 4){
            return 1;
        }
        long nofPiecesFromFirstStick=A/4;
        long nofPiecesFromSecondStick=B/4;
        long total=(nofPiecesFromFirstStick+nofPiecesFromSecondStick)%mod;

        if(nofPiecesFromFirstStick>1&& nofPiecesFromSecondStick>1){
            return (int) total;
        }
        else{
            return 0;
        }
    }

    public static int solve(int A,int B) {
        int mod = (int) 1e9;
        long l = 0;
        long r = ((A + B) % mod / 4);

        long res = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;

            if ((A / mid) + (B / mid) >= 4) {
                res=mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return (int) res;
    }
    public static void main(String[] args) {

        System.out.println(solve(4,8));
    }
}
