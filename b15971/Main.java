package b15971;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]>[] arr;
    static boolean visited[] = new boolean[100_001];
    static {
        arr = new ArrayList[100_001];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b15971/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int pos1 = Integer.parseInt(st.nextToken());
        int pos2 = Integer.parseInt(st.nextToken());

        for(int i =0 ; i < N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[a].add(new int[]{b,w});
            arr[b].add(new int[]{a,w});
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{pos1, 0,0 }); // 위치, 토탈값, 최대값
        visited[pos1] = true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int currIdx = curr[0];
            if(currIdx == pos2){
                System.out.println(curr[1] - curr[2]);
                return ;
            }
            for(int[] next: arr[currIdx]){
                if(visited[next[0]]) continue;
                visited[next[0]] = true;
                queue.add(new int[]{next[0], next[1] + curr[1], curr[2] < next[1] ? next[1] : curr[2] });
            }
        }
    }
}
