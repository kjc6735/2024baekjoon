package b3273;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[100000];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b3273/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println(arr[i]);
        }

        Arrays.sort(arr, 0, N);
        int target = Integer.parseInt(br.readLine());

        int start = 0;
        int end = N-1;
        int cnt = 0;
        while (end > start){
            int sum = arr[start] + arr[end];
            System.out.println(start + " " + end + " " + sum);
            if(sum == target){
                cnt ++;
                start ++;
                end --;
            }else if(sum < target){
                start++;
            }else {
                end--;
            }
        }

        System.out.println(cnt);
    }
}
