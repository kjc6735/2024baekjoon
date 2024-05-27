package b5972;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {

    static int N,M;
    static ArrayList<Node>[] list = new ArrayList[50_001];
    static boolean visited[] = new boolean[50_001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b5972/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= N ; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M ; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        int sum = 0;
        int dist[] = new int[N+1];
        int start = 1;
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            int now = pq.poll().index;

            if(visited[now]) continue;
            visited[now] = true;
            for(Node next : list[now]) {
                if(dist[next.index] > dist[now]+ next.cost) {
                    dist[next.index] = dist[now] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        System.out.println(dist[N]);
    }
}
