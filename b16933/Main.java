package b16933;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String map[];
    static int dir[][] = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static int N,M,K;
    static boolean visited[][][];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b16933/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][11];
        map = new String[N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine();
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1,0,0 }); // x,y,cnt, 벽 부순 갯수
        visited[0][0][0] = true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == N-1 && curr[1] == M-1) {
                System.out.println(curr[2] );
                return ;
            }

            for(int i = 0; i < 4; i++){
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];
                if(!inRange(x,y)) continue;

                if(map[x].charAt(y) == '0' && !visited[x][y][curr[3]]) {
                    visited[x][y][curr[3]] = true;
                    queue.add(new int[]{ x,y,curr[2]+1, curr[3], curr[4] == 0 ? 1: 0 });
                }else if(map[x].charAt(y) == '1' && curr[3] < K &&  !visited[x][y][curr[3] + 1]){
                    if(curr[4] == 0) {
                        queue.add(new int[]{ x,y,curr[2]+1, curr[3] + 1, curr[4] == 0 ? 1: 0 });
                        visited[x][y][curr[3] + 1] = true;
                    } else queue.add(new int[]{ curr[0], curr[1], curr[2]+1, curr[3] , curr[4] == 0 ? 1: 0 });
                }
            }
        }
        System.out.println(-1);
    }
    static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
