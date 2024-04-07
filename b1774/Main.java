package b1774;

import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int x,y, index;
        Pos(int x, int y, int index){
            this.x = x;
            this.y =y;
            this.index = index;
        }
    }
    static class Distance implements Comparable<Distance>{
        Pos posA;
        Pos posB;
        double distance;
        public Distance(Pos posA, Pos posB){
            this.posA = posA;
            this.posB = posB;
            distance =Math.sqrt( Math.pow((posA.x - posB.x), 2) + Math.pow((posA.y - posB.y),2) );
        }

        @Override
        public int compareTo(Distance o) {
            return Double.compare(this.distance, o.distance);
        }
    }
    Set<String> set = new HashSet<>();
    static Pos arr[] = new Pos[1001];
    static int roots[] = new int[1001];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1774/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);


        for(int i = 1; i <= N; i++){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            arr[i] = new Pos(x,y, i);
            roots[i]  = i;
        }

        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            union(a,b);
        }

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        for(int i =1; i < N; i++){
            for(int k =i+1; k <= N; k++){
                int aRoot = find(i);
                int bRoot = find(k);
                if(aRoot == bRoot) continue;
                pq.add(new Distance(arr[i], arr[k]));
            }
        }
        double totalDist = 0.00;

        while (!pq.isEmpty()) {
            Distance curr = pq.poll();
            Pos a = curr.posA;
            Pos b = curr.posB;

            int aRoot = find(a.index);
            int bRoot = find(b.index);

            if(aRoot == bRoot) continue;
            union(a.index,b.index);
            totalDist += curr.distance;
        }
        System.out.printf("%.2f \n", totalDist);
    }

    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot > bRoot) roots[bRoot] = aRoot;
        else roots[aRoot] = bRoot;
    }

}
