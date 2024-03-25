package b11657;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int start;
        int end;
        int value;
        public Edge (int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    static int N,M;
    static Edge edges[];
    static long dist[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b11657/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
//        for(int i = 0; i <= N; i++) Arrays.fill(map[i], Integer.max());
        dist[1] = 0;
        for(int i =0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }

        for(int i = 1; i < N; i++){
            for(int k = 0; k < M ; k++){
                if(dist[edges[k].start] != Integer.MAX_VALUE &&  dist[edges[k].end]> dist[edges[k].start] + edges[k].value ){
                    dist[edges[k].end] =  dist[edges[k].start] + edges[k].value;
                }
            }
        }
        boolean check = false;

        for(int i = 0; i < M ; i++){
            if(dist[edges[i].start] != Integer.MAX_VALUE && dist[edges[i].end]> dist[edges[i].start] + edges[i].value) {
                check = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(!check){
            for(int i = 2; i <= N ; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    sb.append("-1\n");
                }else sb.append(dist[i]).append("\n");
            }
        }else{
            sb.append("-1\n");
        }
        System.out.print(sb.toString());
    }
}
