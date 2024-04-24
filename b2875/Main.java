package b2875;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2875/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int a = 0; a <= M; a++){ // man cnt
            if(a * 2 > N) continue;
            int result = (N - a*2)+(M - a);
            if(result < K) continue;
            max = a;
        }
        System.out.println(max);
    }
}
