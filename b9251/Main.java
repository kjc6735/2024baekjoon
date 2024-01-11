package b9251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b9251/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int dp[][] = new int[a.length()+1][b.length()+1];

        for(int i =0 ; i < a.length(); i++){
            for(int k = 0; k < b.length(); k++){
                if(a.charAt(i) == b.charAt(k)){
                    dp[i+1][k+1] = dp[i][k] + 1;
                }else {
                    dp[i + 1][k + 1] =Math.max(dp[i+1][k], dp[i][k + 1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
