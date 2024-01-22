package b11053;

import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b11053/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = 1; i <= n ; i++ ){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]) {
                    if(dp[i] < (dp[j]+1)) dp[i] = dp[j] + 1;
                }
            }
            if(ans < dp[i]) ans = dp[i];
        }
        System.out.println(ans);
    }

}