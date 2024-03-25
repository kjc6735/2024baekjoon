package b1011;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1011/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= test_case; tc ++){
            String st[] = br.readLine().split(" ");
            long x = Long.parseLong(st[0]);
            long y = Long.parseLong(st[1]);
            HashSet<Long> set = new HashSet<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(x, 0,0));
            boolean check = false;
            int resultIdx = 0;
            while (!queue.isEmpty()){
                Node node = queue.poll();
                for(long i = node.distance -1; i <= node.distance+1; i++){
                    if( i < 0) continue;
                    if (set.contains(node.idx + i)) continue;
                    if((node.idx + i) == y) {
                        check = true;
                        resultIdx = node.cnt;
                        break;
                    }
                    queue.add(new Node(node.idx + i, i, node.cnt +1));
                    set.add(node.idx + i);
                }
                if(check) break;
            }
            sb.append(resultIdx).append("\n");
        }

        System.out.println(sb.toString());

    }
    static class Node{
        int cnt;
        long idx;
        long distance;
        Node(long idx, long distance, int cnt){
            this.idx = idx;
            this.distance = distance;
            this.cnt = cnt;
        }


    }
}
