package b17404;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static int dp [][][];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b17404/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr =new int[N][3];
        dp = new int[N][4][4];
        for(int i = 0; i < N  ; i++) for(int k = 0; k < 4  ; k++) Arrays.fill(dp[i][k], -1);
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        System.out.println(recur(0,3 , 3));
    }

    static int recur(int index, int prev, int start){
        if(index == N) return 0;

        if(dp[index][prev][start] != -1) return dp[index][prev][start];
        int ret = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            if(prev == i) continue;
            if(index == N-1){
                if(start == i) continue;
                ret  = min(ret, recur(index+1, i, i) + arr[index][i]);
            }if(index == 0){
                ret = min(ret, recur(index+1, i, i) + arr[index][i]);
            }else {
                ret = min(ret, recur(index+1, i, start) + arr[index][i]);
            }
        }
        dp[index][prev][start] = ret;
        return dp[index][prev][start];
    }
    static int min (int a , int b){
        return a  > b ? b : a;
    }
}
