package b1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static long arr [];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1253/input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i  <N  ; i++) arr[i] = Long.parseLong(str[i]);


        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            while(start < end){
                if(start == i) { start ++; continue;}
                if(end == i) { end--; continue;}

                if(arr[start] + arr[end]  < arr[i]) {
                    start ++;
                }else if(arr[start] + arr[end] > arr[i]){
                    end --;
                }else {
                    cnt ++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
