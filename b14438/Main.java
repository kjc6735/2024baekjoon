package b14438;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k,start,end;
    static long[] arr = new long[400_000];
    static BufferedReader br;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14438/input.txt"));
        init();
        for(int i = 1; i<end ; i++) System.out.print(arr[i] + " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 2) sb.append(min(start + b - 1,start + c -1)).append("\n");
            else modify(start + b - 1,(long)c);
        }

        System.out.print(sb.toString());

    }
    private static long min(int a, int b){
        long min = Long.MAX_VALUE;
        while (a <= b) {
            if(a%2 == 1){
                min = arr[a] > min ? min : arr[a];
                a++;
            }
            if(b%2 == 0){
                min = arr[b] > min ? min : arr[b];
                b--;
            }
            a/=2;
            b/=2;
        }
        return min;
    }

    private static void modify(int b, long c) {
        arr[b] = c;
        while (b != 0) {
            if(b%2 == 1) b-=1;
            arr[b/2]= arr[b] > arr[b + 1] ? arr[b+1] : arr[b];
            b/=2;
        }
    }

    private static void init()throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = 0 ;
        while ((int)Math.pow(2,++k) < N ){}
        start = (int) Math.pow(2,k);
        end = start*2;
        System.out.println(end -1);
        Arrays.fill(arr, Long.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            arr[i + start] = Long.parseLong(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        for(int i = end-1; i >= 1 ; i-=2){
            arr[i/2] = arr[i] > arr[i-1] ? arr[i-1] : arr[i];
        }

    }
}
