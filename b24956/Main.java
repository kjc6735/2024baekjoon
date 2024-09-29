package b24956;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long w = 0;
        long wh = 0;
        long whe = 0;
        long whee = 0;
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'W'){
                w++;
            }else if(str.charAt(i) == 'H'){
                wh = (wh + w) % MOD;
            }else if (str.charAt(i) == 'E'){
                whee = (whee + whe) % MOD;
                whe *= 2;
                whe += wh;
                whe %= MOD;
            }
        }
        System.out.println(whee);


    }
}
