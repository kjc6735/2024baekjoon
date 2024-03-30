package b4386;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Star{
        double x,y;
        Star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static class Edge{
        int from, to;
        double distance;
        Edge(int from, int to,double distance){
            this.from =from;
            this.to =to;
            this.distance = distance;
        }
    }
    static Star[] starts = new Star[101];
    static int roots[] = new int[101];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b4386/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i < N ; i++) roots[i] = i;
        for(int i =0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            starts[i] = new Star(a,b);
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o1.distance, o2.distance);
        });

        for(int i = 0; i < N ; i++){
            Star currStar = starts[i];
            for(int k = i+1; k < N; k++){
                Star nextStar = starts[k];
                double dist = Math.sqrt(Math.pow((currStar.x - nextStar.x) ,2 ) + Math.pow(currStar.y - nextStar.y,2));
                pq.add(new Edge(i,k,dist));
            }
        }
        double sum = 0;
        while (!pq.isEmpty()){
            Edge curr = pq.poll();
            int aRoot = find(curr.from);
            int bRoot = find(curr.to);
            if(aRoot == bRoot) continue;
            union(curr.from, curr.to);
            sum += curr.distance;

        }

        System.out.printf("%.2f", sum);
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot > bRoot) roots[aRoot] =bRoot;
        else roots[bRoot] = aRoot;
    }

    static int find(int a){
        if(roots[a] ==a )return a;
        return roots[a] = find(roots[a]);
    }
}
