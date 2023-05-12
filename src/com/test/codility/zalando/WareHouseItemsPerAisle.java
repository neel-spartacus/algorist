package com.test.codility.zalando;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WareHouseItemsPerAisle {

    public static void main(String[] args) {

        List<Integer> itemsPerAisle= Arrays.asList(0,1,0,2,2,0,0,2,1,3,0);
        List<Integer> optimalItemsPerAisle=optimalItemPerAisle(5,itemsPerAisle);

        Integer minAisle=optimalItemsPerAisle.get(0);
        Integer maxAisle=optimalItemsPerAisle.get(1);

        System.out.println("Min Aisle : " + minAisle);
        System.out.println("Max Aisle : " + maxAisle);
        System.out.println("Aisle span : " + (maxAisle-minAisle));
        int total=IntStream.range(minAisle,maxAisle+1).map(p->itemsPerAisle.get(p)).reduce(0,Integer::sum);
        System.out.println("Total number of items :" + total);
    }

    private static List<Integer> optimalItemPerAisle(int minimumItemsTOCollect, List<Integer> itemsPerAisle) {

        int len=itemsPerAisle.size();
        int aisleStart=0;
        int aisleEnd=0;
        int maxAisle=0;
        int minAisle=0;
        int minAisleSpan=Integer.MAX_VALUE;

        int totalItems=0;

        while (aisleEnd<len){
            totalItems+=itemsPerAisle.get(aisleEnd);
            if(totalItems<minimumItemsTOCollect){
                aisleEnd++;
            }
            else if(totalItems>=minimumItemsTOCollect){
                while (totalItems>=minimumItemsTOCollect && aisleStart<aisleEnd){
                    minAisle=aisleStart;
                    maxAisle=aisleEnd;
                    minAisleSpan=Math.min(minAisleSpan,(aisleEnd-aisleStart));
                    totalItems-=itemsPerAisle.get(aisleStart);
                    aisleStart++;
                }
                aisleEnd++;
            }
        }

        return Arrays.asList(minAisle,maxAisle);

    }
}
