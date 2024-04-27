package b14400;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14400/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X[]= new int[N];
        int Y[] = new int[N];
        ArrayList<int[]> arr= new ArrayList<>();
        for(int i = 0; i  < N ; i++){

            int x = sc.nextInt();
            int y = sc.nextInt();
            X[i] = x;
            Y[i] = y;
        }

        Arrays.sort(X);
        Arrays.sort(Y);

        long sum = 0;
        for(int i = 0 ;i < N ; i++){
            int x = Math.abs(X[i]  - X[(N-1)/2]);
            int y = Math.abs(Y[i] - Y[(N-1)/2]);
            sum += (x + y);
        }

        System.out.println(sum);

    }
}
