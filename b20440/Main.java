package b20440;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;int value;
        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }
    static class Result implements Comparable<Result>{
        int value;
        int start;
        int end;
        public Result(int value, int start, int end){
            this.value = value;
            this.start = start;
            this.end = end;

        }
        @Override
        public int compareTo(Result o) {
            if(o.value != this.value){
                return o.value - this.value;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b20440/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a,0) + 1);
            map.put(a-1, map.getOrDefault(a-1,0));
            map.put(b-1, map.getOrDefault(b-1,0));
            map.put(b, map.getOrDefault(b,0) -1);
        }
        Iterator<Integer> key = map.keySet().iterator();
        ArrayList<Node> arr = new ArrayList<>();
        for (Iterator<Integer> it = key; it.hasNext(); ) {
            Integer k = it.next();
            arr.add(new Node(k, map.get(k)));
        }
        Collections.sort(arr);
        for(int i = 1 ; i < arr.size();i++){
            arr.get(i).value = arr.get(i-1).value + arr.get(i).value;
        }

        int startIdx = 0;

        PriorityQueue<Result> pq = new PriorityQueue<>();
        for(int i = 1 ; i < arr.size();i++){
            if(arr.get(i).value != arr.get(i-1).value){
                pq.add(new Result(arr.get(i-1).value, startIdx, arr.get(i).idx));
                startIdx = arr.get(i).idx;
            }
        }

        Result result = pq.poll();
        System.out.println(result.value);
        System.out.println(result.start  +" " + result.end);
    }
}
