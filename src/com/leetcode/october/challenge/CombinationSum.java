package com.leetcode.october.challenge;

import java.util.List;

public class CombinationSum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
              int MAX = Integer.MAX_VALUE;

            try{
                if(candidates.length<1 || candidates.length>30){
                    throw new RuntimeException("Candidates length is invalid");
                }
                for(int c:candidates){
                    if(c<1 || c>200){
                        throw new RuntimeException("Candidate value is invalid");
                    }
                }
                if(target<1 || target>500){
                    throw new RuntimeException("Target value is invalid");
                }

                //Code starts here
                int[] uniqueCombinations= new int[target+1];
                int start=0;
                uniqueCombinations[0]=0;

                for(int i =1;i<target+1;i++){
                    uniqueCombinations[i]=MAX;
                    for(int value:candidates){
                        if(i>=value){
                            start=uniqueCombinations[i-value]+1;
                        }
                    }
                }


            }catch (Exception e){

            }
  return null;
        }
    }
}
