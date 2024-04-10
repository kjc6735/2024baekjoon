package b2589;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int N,M;
    static Set<String> set = new HashSet<>();
    static int dir[][] = {
        {0,1}, {1,0}, {0,-1}, {-1,0}
    };
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2589/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int max = 0;
        boolean[][] visited = new boolean[N][M];
        for(int a =  0; a < N; a++){
           for(int b = 0 ; b < M; b++){
               if(map[a][b] == 'W') continue;
               for(int i = 0; i < N; i++) Arrays.fill(visited[i], false);
               Queue<int[]> queue = new LinkedList<>();
               queue.add(new int[]{a, b, 0});
               visited[a][b] = true;
               while (!queue.isEmpty()){
                   int[] c = queue.poll();
                   max = Math.max(max, c[2]);
                   for(int d = 0 ; d< 4; d++){
                       int x = c[0] + dir[d][0];
                       int y = c[1] + dir[d][1];
                       if(!inRange(x,y)) continue;

                       if(map[x][y] == 'W') continue;
                       if(visited[x][y]) continue;
                       visited[x][y] = true;
                       queue.add(new int[]{x,y,c[2] + 1});
                   }
               }
           }
        }
        System.out.println(max);
    }
    static boolean inRange(int x, int y){
        return x>= 0 && y>=0&& x < N && y < M;
    }
}
