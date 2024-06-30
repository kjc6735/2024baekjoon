package b2003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long arr[] = new long[10_000];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i  < N ; i++) arr[i] = Integer.parseInt(st.nextToken());


        int start = 0;
        int end = 0;
        long sum = arr[0];
        int cnt = 0;

        while (end < N && start < N){

            if(sum == M){
                cnt ++;
            }

            if(sum < M && end < N-1){
                end+=1;
                sum += arr[end];
            }else{
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(cnt);


    }
}
