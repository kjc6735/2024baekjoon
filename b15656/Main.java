package b15656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M, arr[] = new int[9];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b15656/input.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0, N);
        for(int i = 0; i < N; i++){
            fn(i,1, String.valueOf(arr[i]));
        }
        System.out.println(sb.toString());
    }

    static void fn(int index, int cnt, String str){
        if(cnt == M) {
            sb.append(str).append('\n');
            return ;
        }

        for(int i = 0 ;i < N; i++){
            fn(i , cnt + 1, str + " " + arr[i]);
        }
    }
}
