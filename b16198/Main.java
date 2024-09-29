package b16198;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static long arr[] = new long[10];
    static int N;
    static long max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N ; i++) arr[i] = Long.parseLong(st.nextToken());
        for(int i = 1; i < N-1; i++){
            fn(1 << i,arr[i+1] * arr[i-1]);
        }
        System.out.println(max);
    }

    static public void fn( int visited, long sum){
        if(Long.bitCount(visited) == N -2){
            max =max(max, sum);
            return ;
        }
        for(int i =0 ; i < N; i++){
            if((visited & (1 << i)) != 0) continue;
            int left = findLeft(0, i-1, visited);
            int right = findRight(i+1, N-1,visited);
            if(right == -1 || left == -1) continue;
            fn(visited | (1 << i), sum + (arr[left] * arr[right]));
        }
    }

    static long max(long a, long b){
        return a > b ? a : b;
    }
    static public int findLeft(int left, int right, int visited){
        for(int i = right ; i  >= left ; --i){
            if((visited & (1 << i)) == 0) return i;
        }
        return -1;
    }
    static public int findRight(int left, int right, int visited){
        for(int i = left ; i  <= right ; i++){
            if((visited & (1 << i)) == 0) return i;
        }
        return -1;
    }
}
