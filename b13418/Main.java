package b13418;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int start, end, type;

        Edge(int start, int end , int type){
            this.start = start;
            this.end = end;
            this.type = type;
        }
    }
    static BufferedReader br;
    static int N, M;
    static int roots[] = new int[1001];
    static int roots2[] = new int[1001];

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b13418/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i<=  N ; i++) {
            roots[i] = i;
            roots2[i] = i;
        }

        PriorityQueue<Edge> pq1 = new PriorityQueue<>(((o1, o2) -> o1.type - o2.type));
        PriorityQueue<Edge> pq2 = new PriorityQueue<>(((o1, o2) -> o2.type - o1.type));

        for(int i = 0; i < M+1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq1.add(new Edge(a,b,c == 1 ? 0 : 1));
            pq2.add(new Edge(a,b,c == 1 ? 0 : 1));
        }
        int min = 0, max = 0;
        while (!pq1.isEmpty()){
            Edge curr = pq1.poll();
            if(union(curr.start, curr.end, roots)) min+= curr.type;

            curr = pq2.poll();
            if(union(curr.start, curr.end, roots2)) max+= curr.type;
        }

        System.out.println(max*max - min*min);

    }

    static int find(int arr[], int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr, arr[a]);
    }


    static boolean union(int a, int b, int arr[]){
        int aRoot = find(arr,a);
        int bRoot = find(arr,b);

        if(aRoot == bRoot) return false;

        if(aRoot < bRoot) arr[bRoot] = aRoot;
        else arr[aRoot] = bRoot;
        return true;
    }
}