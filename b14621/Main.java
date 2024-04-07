package b14621;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start, end;
        int distance;

        Edge(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
    static BufferedReader br;
    static int N, M;
    static int roots[] = new int[1001];
    static char nodeType[] = new char[1001];
    static Edge[] edges = new Edge[10001];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14621/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nodeType[i] = st.nextToken().toCharArray()[0];
        }
        init();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int idx = 0;
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(nodeType[a] != nodeType[b]){
               pq.add( new Edge(a,b, dist));
            }
        }
        int total = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int aRoot = find(edge.start);
            int bRoot = find(edge.end);
            if(aRoot == bRoot) continue;
            union(aRoot,bRoot);
            total+=edge.distance;
        }
       boolean check = true;
        for(int i = 2; i <= N; i++){
            if(find(1) == find(i)) continue;
            check = false;
            break;
        }
        if(!check) System.out.println(-1);
        else System.out.println(total);
//        System.out.println(total);
//        for(int i = 1; i <= N ; i++){
//            System.out.print(roots[i] + " ");
//        }
    }

    static void init(){
        for(int i = 0;  i <= N ; i++){
            roots[i] = i;
        }
    }
    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot > bRoot) roots[b] = aRoot;
        else roots[a] = bRoot;

    }
}
