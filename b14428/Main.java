package b14428;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, k,start,end;
    static long[] arr = new long[400_000];
    static int[] arr2 = new int[400_000];
    static BufferedReader br;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14428/input.txt"));
        init();
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
    private static int min(int a, int b){
        long min = Long.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        while (a <= b) {
            if(a%2 == 1){
                long tmp = min;
                min = arr[a] > tmp ? tmp : arr[a];
                if(tmp == arr[a]){
                    min2 = arr2[a] > min2  ? min2 : arr2[a];
                }else {
                    min2 = arr[a] > tmp ? min2 : arr2[a];
                }
                a++;
            }
            if(b%2 == 0){
                long tmp = min;
                min = arr[b] > tmp ? tmp : arr[b];
                if(tmp == arr[b]){
                    min2 = arr2[b] > min2  ? min2 : arr2[b];
                }else {
                    min2 = arr[b] > tmp ? min2 : arr2[b];
                }
                b--;
            }
            a/=2;
            b/=2;
        }
        return min2;
    }

    private static void modify(int b, long c) {
        arr[b] = c;
        while (b != 0) {
            if(b%2 == 1) b-=1;
            arr[b/2]= arr[b] > arr[b + 1] ? arr[b+1] : arr[b];
            if(arr[b] == arr[b+1]){
                arr2[b/2] = arr2[b] > arr2[b+1]  ?arr2[b+1] : arr2[b];
            }else {
                arr2[b/2] =arr[b] > arr[b+1] ? arr2[b+1] : arr2[b];
            }
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
        Arrays.fill(arr, Long.MAX_VALUE);
        Arrays.fill(arr2, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            arr[i + start] = Long.parseLong(st.nextToken());
            arr2[i + start] = i+1;
        }
        M = Integer.parseInt(br.readLine());
        for(int i = end-1; i >= 1 ; i-=2){
            arr[i/2] = arr[i] > arr[i-1] ? arr[i-1] : arr[i];
            if(arr[i] == arr[i-1]){
                arr2[i/2] = arr2[i] > arr2[i-1]  ?arr2[i-1] : arr2[i];
            }else {
                arr2[i/2] =arr[i] > arr[i-1] ? arr2[i-1] : arr2[i];
            }
        }
//        for(int i =1; i < end ; i++) {
//            System.out.print(arr[i]+ " ");
//        }
//        System.out.println();
//        for(int i =1; i < end ; i++) {
//            System.out.print(arr2[i]+ " ");
//        }
    }
}
