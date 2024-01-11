package b1325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static ArrayList<Integer>[] arr;
    static int dp[];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1325/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        arr = new ArrayList[N+1];
        for(int i = 0; i <= N ; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr[b].add(a);
        }
        int max = 0;

        for (int i = 0; i < N; i++) {


        }
    }

}
