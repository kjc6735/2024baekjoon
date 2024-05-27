package b1149;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static int maxValue = Integer.MAX_VALUE;
    static int dp[][];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N][3];
        dp = new int[N][4];
        for(int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        for(int i = 0; i < N ; i++) Arrays.fill(dp[i], -1);
        System.out.println(recur(0,3));
        for(int i = 0; i < N ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }

    static int recur(int index, int prev){
        if(index == N) return 0;
        if(dp[index][prev] != -1) return dp[index][prev];
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            if(prev == i) continue;
            ret = min(ret, recur(index+1, i) + arr[index][i]);
        }
        dp[index][prev] = ret;
        return dp[index][prev];
    }

    static int max(int a, int b){
        return a > b ? a  : b;
    }
    static int min(int a, int b){
        return a > b ? b  : a;
    }
}
