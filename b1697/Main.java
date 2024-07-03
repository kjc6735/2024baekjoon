package b1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[] = new boolean[200_001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        visited[N] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == M){
                System.out.println(curr[1]);
                return ;
            }

            if((curr[0] -1) >= 0 && !visited[curr[0] - 1]){
                queue.add(new int[]{curr[0] - 1, curr[1] + 1}); visited[curr[0]-1] = true;
            }
            if(100000 >= (curr[0]+1) && !visited[curr[0] + 1]){
                queue.add(new int []{curr[0] + 1, curr[1] + 1}); visited[curr[0] + 1] = true;
            }

            if(100000 >=(curr[0]*2) && !visited[curr[0] * 2]){
                queue.add(new int []{curr[0] * 2, curr[1] + 1}); visited[curr[0] * 2] = true;
            }
        }

    }
}
