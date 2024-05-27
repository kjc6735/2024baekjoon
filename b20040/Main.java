package b20040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int parents[] = new int[1_000_001];
    static BufferedReader br;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        for(int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot) {
                System.out.println(i+1);
                return ;
            }else {
                union(aRoot,bRoot);
            }
        }
        System.out.println(0);
    }

    public static void init(){
        for(int i = 0 ; i < N; i++){
            parents[i] = i;
        }
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return ;

        if(aRoot < bRoot) {
            parents[aRoot] = bRoot;
        }else {
            parents[bRoot] = aRoot;
        }
    }

    public static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
