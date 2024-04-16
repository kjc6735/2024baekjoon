package b30467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N, S, MAX = 0;
    static long arr[] = new long[400_000];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b30467/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int k = 0;
        while (Math.pow(2,++k) < N){}
        int start = (int) Math.pow(2, k);
        int last = start * 2;

        st = new StringTokenizer(br.readLine());

        for(int i =0 ; i < N ; i++) arr[start + i] = Long.parseLong(st.nextToken());


        for(int i = 0; i < N - S; i++){
            for(int a = i; a < i + S; a++) {

            }
        }


    }


    static int segment (int start, int end){ // start <= d <= end
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (!queue.isEmpty()){
            int size = queue.size();

            if(size%2 == 1) {

            }
        }

        return cnt;
    }
}


