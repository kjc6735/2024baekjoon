package b1939;

import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int a;
        int b;
        int v;

        public Node(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return o.v - this.v;
        }
    }
    static int roots[] = new int[10_001];
    static {
        for(int i = 0; i < roots.length; i++){
            roots[i]= i;
        }
    }
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1939/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a,b,c));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (!nodes.isEmpty()){
            Node node = nodes.poll();

            union(node.a, node.b);
            if(find(a) == find(b)){
                System.out.println(node.v);
                return ;
            }
        }
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot > bRoot){
            roots[aRoot] = bRoot;
        }else {
            roots[bRoot] = aRoot;
        }
    }
    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }

}
