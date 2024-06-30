package b2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] arr = new long[1_000_002];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        Arrays.sort(arr,1, N+1);
        arr[N+1] = arr[N];

        long sum = 0;
        for(int i = 0; i <= N ; i++){
            sum += (arr[N+1 - i] - arr[N - i]) * (i) ;
            if(sum < M) continue;
            if(sum == M) {
                System.out.println( arr[N - i]);
                break;
            }
            sum -= (arr[N+1 - i] - arr[N - i]) * (i) ;
            M = M - sum;

            long start = 0;
            long end =arr[N+1 - i] - arr[N - i];
            long mid = 0;
            while (start <= end){
                mid = (start+end)/2;

                if(mid * i < M){
                    start = mid + 1;
                }else if(mid * i > M) {
                    end = mid -1;
                }else {
                    break;
                }
            }
            System.out.println(arr[N+1 - i] - mid);
            break;
        }
    }
}
