package b14244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b14244/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int i = 0, last = 0;
        for(i = 0; i < N-M+1; i++){
            sb.append(i).append(" ").append(i+1).append('\n');
        }
        last = i -1;
        for(i = i+1; i < N; i++){
            sb.append(last).append(" ").append(i).append('\n');
        }
        System.out.println(sb.toString());

    }
}
