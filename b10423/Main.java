package b10423;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo (Edge o){
            return this.weight - o.weight;
        }
    }
    static BufferedReader br;
    static int N,M,K;
    static int roots[] = new int[1001];
    static Set<Integer> provider = new HashSet<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b10423/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++){
            roots[i] = i;
        }
        for(int i = 0; i < K; i++) provider.add(Integer.parseInt(st.nextToken()));

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a,b,c));
        }
        int total = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(!union(edge.start, edge.end)) continue;
            total += edge.weight;
        }

        System.out.println(total);
        for(int i = 1; i <= N ;i++){
            System.out.print(roots[i] + " ");
        }
    }

    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }

    static boolean union (int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(provider.contains(aRoot) && provider.contains(bRoot)) return false;
        if(aRoot == bRoot) return false;

        if(provider.contains(aRoot)){
            roots[bRoot]= aRoot;
        }else if(provider.contains(bRoot)){
            roots[aRoot] = bRoot;
        }else {
            if(aRoot < bRoot) roots[aRoot] = bRoot;
            else roots[bRoot] = aRoot;
        }
        return true;
    }
}
