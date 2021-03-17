package com.learnJava.ngnix;

import java.io.*;


public class NPureNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static String Solve(int n) {
        String[] v = new String[n + 1];
        v[0] = "44";
        v[1] = "55";
        int count = 2;

        int val = -1;
        int i = 0;
        while (count < n) {

            i++;
            int x = val + 1;
            val = x + (int) Math.pow(2, i) - 1;

            for (int k = x; k <= val; k++) {

                v[count] = ("4" + v[k] + "4");
                count++;
                if (count >= n) {
                    break;


                }

            }
            for (int k = x; k <= val; k++) {

                v[count] = ("5" + v[k] + "5");
                count++;
                if (count >= n) {
                    break;


                }


            }
        }

        return v[n - 1];


    }
}