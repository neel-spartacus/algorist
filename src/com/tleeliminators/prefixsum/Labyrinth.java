package com.tleeliminators.prefixsum;

import java.io.*;
import java.util.ArrayList;

public class Labyrinth {


    public static void main(String[] args) throws IOException {

        File file = new File(
                "C:\\Users\\Piya\\Neel\\TomTom\\Labyrinth.txt");

        BufferedReader br = new BufferedReader(
                new BufferedReader(new FileReader(file)));

        String st;
        // Consition holds true till
        // there is character in a string
        //676+1296+100
        int size=2100;
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[size];
        while ((st = br.readLine()) != null){

            String[] s1 = st.split(" ");

        }
    }


}
