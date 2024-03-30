package b2268;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k,start,end;
    static long[] arr = new long[4_000_000];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2268/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
         start = (int) Math.pow(2,k);
         end = start*2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0) sb.append(sum(start + b - 1,start + c -1)).append("\n");
            else modify(start + b - 1,(long)c);
        }
        System.out.print(sb.toString());

    }
    private static void print(){
        for(int i = 1 ; i <= end-1 ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
    private static void modify(int b, long c) {
        long diff = c - arr[b];
        while (b != 0) {
            arr[b] += diff;
            b/=2;
        }
    }

    private static long sum(int b, int c) {
        int idxA = b > c ? c : b;
        int idxB = b > c ? b : c;

        long sum = 0;
        while (idxA  <= idxB){
            if(idxA%2 == 1) sum += arr[idxA++];
            if(idxB%2 == 0) sum += arr[idxB--];
            idxA/=2;
            idxB/=2;
        }
        return sum;
    }

    private static void init(){
        k = 0 ;
        while ((int)Math.pow(2,++k) < N ){}
    }
}
