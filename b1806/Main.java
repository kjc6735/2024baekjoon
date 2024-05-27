package b1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int [100_001];
    static int sum[] = new int[100_001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int s = arr[start];
        int result = Integer.MAX_VALUE;
        while (start <= end && end < N){
            if(s < S) s += arr[++end];
            else if (s > S) s-= arr[start++];
            else {
                result = Math.min(result, end - start);
                s-= arr[start++];
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result + 1);
    }
}
