package b15486;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[1_500_000][2];
    static int dp[] = new int[1_500_001];
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b15486/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.fill(dp, -1);

        System.out.println(recur(0));
        System.out.println();

    }
    static int recur(int cur) {
        if(cur > N) return Integer.MIN_VALUE;
        if(cur == N ) return 0;
        if(dp[cur] != -1) return dp[cur];
        dp[cur] = max( recur(cur+1) , recur(cur + arr[cur][0]) + arr[cur][1] );
        return dp[cur];

    }

    static int max(int a, int b){
        return a < b ? b : a;
    }
}
