package b2357;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2357/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = 0;
        while (Math.pow(2,++k) < N);
        int start =(int) Math.pow(2, k);
        int last = start * 2;

        int arr[][] = new int[2][last];
        Arrays.fill(arr[0], Integer.MAX_VALUE);

        for(int i = 0; i< N ; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[0][start + i] = tmp;
            arr[1][start + i] = tmp;
        }
        //0 최소 1 최대
        for(int i = last - 1 ; i >= 0 ; i-=2){
            arr[0][i/2] = arr[0][i] > arr[0][i-1] ? arr[0][i-1] : arr[0][i];
            arr[1][i/2] = arr[1][i] < arr[1][i-1] ? arr[1][i-1] : arr[1][i];
        }
        StringBuilder  sb = new StringBuilder();
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a += (start -1);
            b += (start -1);
            int max = 0;
            int min = Integer.MAX_VALUE;

            while (a <= b) {
                if(a % 2 == 1) {
                    min = min > arr[0][a] ? arr[0][a] : min;
                    max = max > arr[1][a] ? max : arr[1][a];
                    a++;
                }
                if(b % 2== 0) {
                    min = min > arr[0][b] ? arr[0][b] : min;
                    max = max > arr[1][b] ? max : arr[1][b];
                    b --;
                }
                a/=2;
                b/=2;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
