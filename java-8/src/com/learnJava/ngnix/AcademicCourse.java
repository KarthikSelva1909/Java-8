package com.learnJava.ngnix;

import java.util.Arrays;
import java.util.Scanner;

public class AcademicCourse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of Courses in Academic Program");

        int N = sc.nextInt();
        System.out.println("Enter Courses " + N);

        int[][] m = new int[4][4];


        for (int i = 0; i < 4; i++) {
            System.out.println("Enter Elements of courses " + i);
            for (int j = 0; j < 4; j++) {
                m[i][j] = Integer.valueOf(sc.nextInt());
            }
        }
        sc.close();
        System.out.println(Arrays.deepToString(m));
    }
}
