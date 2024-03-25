package b11505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int DIV = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b11505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int k = 1;
        while ((k = k * 2)< N) {}
        int start = k;
        int last = start * 2;
        int arr[] = new int[last];

        for(int i = 0; i < N ; i++) arr[start + i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) {

            }else {

            }

        }

    }
}
