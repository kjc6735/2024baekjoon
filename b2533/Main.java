package b2533;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static int arr[][] = new int[1_000_001][2];
    static ArrayList<Integer> tree[] = new ArrayList[1_000_001];
    static {
        for(int i = 0; i < tree.length; i++) tree[i] = new ArrayList<>();
    }
    static boolean visited[] = new boolean[1_000_001];

    static int cnt = 0;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("b2533/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        fn(1);
        System.out.println(arr[1][1] < arr[1][0] ?  arr[1][1] :  arr[1][0]);
    }

    public static void fn(int index) {
        visited[index] = true;
        arr[index][0] = 1;
        for(int i = 0; i <tree[index].size();i++){
            if(visited[tree[index].get(i)]) continue;
            fn(tree[index].get(i));
            arr[index][1] += arr[tree[index].get(i)][0];
            arr[index][0] +=  (arr[tree[index].get(i)][1] < arr[tree[index].get(i)][0] ?  arr[tree[index].get(i)][1] :  arr[tree[index].get(i)][0]);
        }
    }
}
