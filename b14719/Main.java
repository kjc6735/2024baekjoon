package b14719;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[501];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < W ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i =1; i < W-1; i++){
            int k = min(find(0, i-1) , find(i+1, W-1));
            if(arr[i] < k) cnt += (k-arr[i]);
        }


        System.out.println(cnt);
        return ;
    }

    static int find(int l, int r){
        int result = 0;
        for(int i = l; i <= r; i++){
            result = max(arr[i], result);
        }
        return result;
    }
    static int max(int a, int b){
        return a > b ? a : b;
    }

    static int min(int a, int b){
        return a > b ? b : a;
    }
}
