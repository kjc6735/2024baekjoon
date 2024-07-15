package b7562;

import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean visited [][]= new boolean[301][301];
    static int dir[][] = {
        {2,1},
        {-2,1},
        {2,-1},
        {-2,-1},
        {-1,2},
        {1,-2},
        {-1,-2},
        {1,2}
    };
    static int N;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        System.setIn(new FileInputStream("b7562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= test_case; tc ++){
            N=  Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start1 = Integer.parseInt(st.nextToken());
            int start2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end1 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());
            init();
            visited[start1][start2] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start1, start2, 0});
            while (!queue.isEmpty()){
                int curr[] = queue.poll();
                if(curr[0] == end1 && curr[1] == end2) {
                    sb.append(curr[2]).append("\n");
                    break;
                }

                for(int i = 0; i < dir.length; i++){
                    int x = curr[0] + dir[i][0];
                    int y = curr[1] + dir[i][1];
                    if(!inRange(x,y)) continue;
                    if(visited[x][y]) continue;
                    queue.add(new int[]{x,y,curr[2]+1});
                    visited[x][y] = true;
                }
            }
        }
        System.out.print(sb.toString());
    }
    static void init(){
        for(int i = 0; i <= N ;i++){
            Arrays.fill(visited[i], false);
        }
    }
    static boolean inRange(int x, int y){
        return x >= 0 && y>=0 && x < N&&  y < N;
    }
}
