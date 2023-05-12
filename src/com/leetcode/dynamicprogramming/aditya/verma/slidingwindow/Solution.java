package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.Clock;
        import java.time.Instant;
        import java.time.ZoneId;
        import java.time.ZoneOffset;

        import java.util.*;
        import java.math.*;
// insert additional imports here if needed

public class Solution {

    private int caclulationIntervalMillis;
    private Clock utcClock;
    private int price;
    private int size;
    private long timestampMillis;

    private List<Double> publicVolumes;
    private List<Double> privateVolumes;
    private long quantity;

    Map<Long,Trade> privateTradeMap= new HashMap<>();
    Map<Long,Trade> publicTradeMap= new HashMap<>();

    class Trade{

        private int price;
        private int size;

        public Trade(int price, int size) {
            this.price = price;
            this.size = size;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }



    public Solution(int caclulationIntervalMillis, Clock utcClock) {
        this.caclulationIntervalMillis=caclulationIntervalMillis;
        this.utcClock=utcClock;
    }


    public void onPrivateTrade(int price, int size, long timestampMillis) {

        Trade privateTrade=new Trade(price, size);
        privateTradeMap.put(timestampMillis, privateTrade);

    }

    public void onPublicTrade(int price, int size, long timestampMillis) {
        Trade publicTrade=new Trade(price, size);
        publicTradeMap.put(timestampMillis, publicTrade);
    }

    public double calculateMissedVolumeFraction() {
        double opportunity_fraction;
        DecimalFormat df = new DecimalFormat("#.#####");

        privateTradeMap.forEach((timestampMillis,trade)->{
                  if(publicTradeMap.get(timestampMillis)!=null && publicTradeMap.get(timestampMillis).getPrice()
                          ==privateTradeMap.get(timestampMillis).getPrice() && ((publicTradeMap.get(timestampMillis).getSize()==
                          privateTradeMap.get(timestampMillis).getSize()) || (publicTradeMap.get(timestampMillis).getSize()>
                          privateTradeMap.get(timestampMillis).getSize())) ){
                        privateVolumes.add((double)(privateTradeMap.get(timestampMillis).getPrice()*privateTradeMap.get(timestampMillis).getSize()));
                        publicVolumes.add((double)(publicTradeMap.get(timestampMillis).getPrice()*publicTradeMap.get(timestampMillis).getSize()));
                  }

                }
                );
        if(!privateVolumes.isEmpty() && !publicVolumes.isEmpty()){
            Double privateVolumesSum = privateVolumes.stream()
                    .reduce(0.0, Double::sum);

            Double publicVolumesSum = publicVolumes.stream()
                    .reduce(0.0, Double::sum);

            opportunity_fraction=1-(privateVolumesSum/publicVolumesSum);

            return Double.valueOf(df.format(opportunity_fraction));


        }
        else{
            return Double.NaN;
        }

    }

    // The rest of the class is the harness code. Please ignore it.

    private static final String FINISH_COMMAND = "finish";
}