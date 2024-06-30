package b10815;
import java.io.*;
import java.util.*;
public class Main {
    static int arr[] = new int[500001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,0,N);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            int tmp = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            boolean check = false;
            while (start <= end){
                int mid = (start + end) /2;

                if(arr[mid] == tmp) {
                    check = true;
                    break;
                }else if(arr[mid] > tmp){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }
            }
            sb.append(check ? 1 : 0).append(" ");
        }
        System.out.println(sb.toString());
    }
}
