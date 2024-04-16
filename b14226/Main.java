package b14226;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    static class Node{
        int time;
        int show;
        int saved;

        Node(int time, int show, int saved){
            this.time = time;
            this.show = show;
            this.saved = saved;
        }

    }
    static BufferedReader br;
    static int S;
    static boolean visited[] = new boolean[1001];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b14226/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(0, 1, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.show == S) {
                System.out.println(node.time);
                break;
            }

            if(node.show > S) continue;
            if(node.show <= 0) continue;

            if( !set.contains(node.show * 1000 + node.show)) {
                queue.add(new Node(node.time + 1, node.show, node.show ));
                set.add(node.show * 1000 + node.show);
            }

            if( !set.contains((node.show + node.saved) * 1000 + node.saved)){
                queue.add(new Node(node.time + 1, node.show + node.saved, node.saved));
                set.add((node.show + node.saved) * 1000 + node.saved);
            }
            if(node.show -1 >= 0 && !set.contains((node.show-1)*1000 + node.saved)){
                queue.add(new Node(node.time + 1, node.show - 1, node.saved));
                set.add((node.show-1)*1000 + node.saved);
            }
        }
    }
}
