package b13913;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result[] = new int[100_001];
    static int visited[] = new int[100_001];
    static Node node[] = new Node[100_001];
    static {
        Arrays.fill(visited, -1);
        Arrays.fill(result, -1);

    }
    static class Node{
        int idx;
        Node next;
        Node prev;

        Node(int id, Node prev){
            this.idx = id;
            this.prev = prev;
        }
    }
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("b13913/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        queue.add(N);
        visited[N] = N;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == M) {
                ;
                StringBuilder sb = new StringBuilder();
                deque.addFirst(M);
                while (curr != N){
                    curr = visited[curr];
                    deque.addFirst(curr);
                }
                System.out.println(deque.size()-1);
                while(!deque.isEmpty()){
                    sb.append(deque.poll()).append(" ");
                }
                System.out.println(sb.toString());
                return ;
            }

            if(curr - 1 >= 0 && visited[curr-1] == -1 ){
                queue.add(curr-1);
                visited[curr-1] = curr;
            }
            if(curr +1 <= 100_000 && visited[curr+1] == -1){
                queue.add(curr+1);
                visited[curr+1] = curr;
            }
            if(curr *2 <= 100_000 && visited[curr*2] == -1){
                queue.add(curr * 2);
                visited[curr * 2] = curr;
            }

        }
    }
}
