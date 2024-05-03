package b15651;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b15651/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N ; i++){
            fn( 1, String.valueOf(i));
        }
        System.out.println(sb.toString());
    }

    static void fn(int cnt, String str ){
        if(cnt == M){
            sb.append(str).append('\n');
            return ;
        }

        for(int i = 1; i <= N ; i++){
            fn(cnt + 1, str + " " + i);
        }
    }
}
