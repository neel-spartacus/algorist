package com.codeforces;

import java.util.Scanner;

public class Team {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();

            if (x + y + w >= 2) {
                count++;
            }


        }
        System.out.println(count);
    }
}
