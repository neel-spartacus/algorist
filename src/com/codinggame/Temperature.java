package com.codinggame;

public class Temperature {

        public static int compute(int[] ts){

            int len=ts.length;

            if(len==0){
                return 0;
            }

            int closest=ts[0];
            for(int i=1;i<len;i++){
                int number=ts[i];
                int absNumber=Math.abs(number);
                int absClosest=Math.abs(closest);

                if(absNumber<absClosest){
                    closest=number;
                }
                else if( absNumber==absClosest && closest<0){
                    closest=absNumber;
                }
            }

            return closest;
        }

    public static void main(String[] args) {
        int[] A={7,-10, 13, 8, 4, -7,-12,-3,3,-9, 6,-1, -6,7};
        System.out.println(compute(A));
    }
}
