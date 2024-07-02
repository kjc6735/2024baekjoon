package b2487;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int shuffle[] = new int [20001];
    static int arr[][] = new int[2][20001];
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2487/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
            shuffle[i] = arr[0][i];
        }
        int s = 0;
        while (s != 10 && !check((s%2))){
            for(int i = 1 ; i <= N ; i++){
                arr[(s+1)%2][i] = arr[(s%2)][shuffle[i]];
            }
            s++;
        }
        System.out.println(s + 1);
    }
    static boolean check(int idx){
        for(int i = 1; i <= N; i++) {
            if(arr[idx][i] != i) return false;
        }
        return true;
    }
}
