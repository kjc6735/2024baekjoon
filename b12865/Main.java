package b12865;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int arr[][], dp[][];
    static int max = 0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b12865/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new int[N][101010];
        for(int i = 0; i < N; i++)  Arrays.fill(dp[i], -1);
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        System.out.println(recur(0, 0));
    }
    static int recur(int index, int w){
        if(w > K) return Integer.MIN_VALUE;
        if(index == N) return 0;

        if(dp[index][w] != -1) return dp[index][w];
        dp[index][w] =  max(recur(index + 1, w + arr[index][0]) + arr[index][1], recur(index+1, w));
        return dp[index][w];
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
    static int min(int a, int b){
        return a > b ? b : a;
    }
}
