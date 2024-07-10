package b3584;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr = new ArrayList[10001];
    static {
        for(int i =0; i < arr.length; i++) arr[i] = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b3584/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= test_case; tc++){
            for(int i =0; i < arr.length; i++) arr[i] = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i = 0; i <  N-1 ;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b].add(a);
            }
            st = new StringTokenizer(br.readLine());
            int dest1 = Integer.parseInt(st.nextToken());
            int dest2 = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();

            Queue<Integer> queue = new LinkedList<>();
            queue.add(dest1);
            set.add(dest1);
            while (!queue.isEmpty()){
                int curr = queue.poll();
                for(int a : arr[curr]){
                    queue.add(a);
                    set.add(a);
                }
            }

            queue.clear();
            queue.add(dest2);
            while (!queue.isEmpty()){
                int curr = queue.poll();
                if(set.contains(curr)) {
                    System.out.println(curr);
                    break;
                }
                for(int a : arr[curr]){
                    queue.add(a);
                }
            }
        }
    }
}
