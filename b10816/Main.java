package b10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[500_000];
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, 0, N);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <  M ; i++){
            int tmp = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            int r = -1;

            while (start <= end){
                int mid = (start + end) /2;

                if(arr[mid] < tmp) {
                    start = mid + 1;
                }else if(arr[mid] > tmp){
                    end = mid - 1;
                }else {
                    r = mid;
                    start = mid + 1;
                }
            }


            start = 0;
            end = N-1;
            int l = 0;
            while (start <= end){
                int mid = (start + end) /2;

                if(arr[mid] < tmp) {
                    start = mid + 1;
                }else if(arr[mid] > tmp){
                    end = mid - 1;
                }else {
                    l = mid;
                    end = mid - 1;
                }
            }
            sb.append(r - l  + 1).append(' ');
        }
        System.out.println(sb.toString());
    }
}
