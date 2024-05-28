package b20544;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int dp[][][][] = new int[1001][5][5][3];
    static long dp2[][][][] = new long[1001][5][5][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < dp.length; i++){
            for(int k = 0; k < dp[i].length; k++){
                for(int t = 0 ; t< dp[i][k][t].length; t++) {
                    for (int j = 0; j < 3; j++) {
                        dp[i][k][t][j] = -1;
                        dp2[i][k][t][j] = -1;
                    }
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        System.out.println( fn(1,0,0,0));

    }
    static int fn(int index,int prevCnt,  int prevSum,int two){
        if(prevCnt > 2) return 0;
        if(index == N) {
            if(two == 0) return 0;
            return 1;
        }

        if(dp[index][prevCnt][prevSum][two] != -1){
            return dp[index][prevCnt][prevSum][two];
        }


        int a = fn(index+1, 0, 0, two);
        int b = fn(index+1, prevCnt+1, 1, two);
        int c = 0;
        if(prevSum != 2) {
            c = fn(index+1, prevCnt+1, 2, 1);
        }

        dp[index][prevCnt][prevSum][two] = (a + b + c) %1_000_000_007;
        return dp[index][prevCnt][prevSum][two];
    }




    public static long recursion(int index, int beforebeforeMap, int beforeMap, int flag) {

        if (index == N + 1) {
            if (flag == 1) {
                return 1;
            }
            return 0;
        }

        if (dp2[index][beforebeforeMap][beforeMap][flag] != -1) {
            return dp2[index][beforebeforeMap][beforeMap][flag];
        }

        long count = 0;
        // 연속해서 3 번 나오는 경우
        if (beforeMap > 0 && beforebeforeMap > 0) {
            count = recursion(index + 1, beforeMap, 0, flag) % 1000000007;
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    // 크기가 2인 선인장이 연속 2번 나오는지 확인
                    if (beforeMap != 2) {
                        count = count % 1000000007 + recursion(index + 1, beforeMap, i, 1) % 1000000007;
                    }
                } else {
                    count = count % 1000000007 + recursion(index + 1, beforeMap, i, flag) % 1000000007;
                }
            }
        }
        return dp2[index][beforebeforeMap][beforeMap][flag] = count;
    }
}
