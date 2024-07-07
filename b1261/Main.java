package b1261;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int visited[][] = new int[101][101];

    static {
        for(int i = 0; i <  101; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
//            for(int k = 0; k < 101; k++){
//                Arrays.fill(visited[i][k], Integer.MAX_VALUE);
//            }
        }
    }
    static int N,M;
    static String[] arr = new String[101];

    static int dir[][] = new int [][]{{-1,0}, {1,0}, {0,-1},{0,1}};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1261/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M  = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i <  N ; i++) arr[i] = br.readLine();

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0,0});
        visited[0][0] = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int curr[] = queue.poll();

            for(int d = 0; d < 4 ; d++){
                int x = curr[0] + dir[d][0];
                int y = curr[1] + dir[d][1];
                if(!inRange(x,y)) continue;
                int cnt = arr[x].charAt(y) =='1' ? curr[2] + 1 : curr[2];
                if(visited[x][y] <= cnt) continue;
                visited[x][y] = cnt;
                queue.add(new int[]{x,y, cnt});
            }
        }

        System.out.println(visited[N-1][M-1]);
    }
    static void print(){
        for(int i = 0 ; i<  N ;i++){
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    static boolean inRange(int x, int y){
        return x>= 0 && y>= 0 && x< N && y < M;
    }

}
