package b3197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static BufferedReader br;
    static int player1[] = new int[]{-1,-1};
    static int player2[] = new int[]{-1,-1};
    static char[][] map = new char[1500][1500];
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[1500][1500];
    static Queue<int[]> findQueue = new LinkedList<>();

    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        input();
        visited[player1[0]][player1[1]] = true;
        findQueue.add(new int[]{player1[0], player1[1]});

        for(int i = 0; i < 1500; i ++){
            find();
            boolean check = isConnected();
            if(!check)continue;
            System.out.println(i+1);
            return ;
        }
    }

    private static boolean isConnected(){
        Queue<int[]> q = findQueue;
        HashSet<String> Xset = new HashSet<>();
        Queue<int[]>  Xqueue = new LinkedList<>();
        while(!q.isEmpty()){
            int pos[] = q.poll();
            for(int d = 0 ; d < 4 ; d ++) {
                int x = pos[0] + dir[d][0];
                int y = pos[1] + dir[d][1];
                if(!inRange(x,y)) continue;
                if(visited[x][y]) continue;
                if(map[x][y] == 'L') return true;
                if(map[x][y] == '.'){
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                }else {
                    if(Xset.contains(x + " " + y)) continue;
                    Xqueue.add(new int[]{x,y});
                    Xset.add(x + " " + y);
                }
            }
        }
        while (!Xqueue.isEmpty()) findQueue.add(Xqueue.poll());
        return false;
    }

    private static void find(){
        int size = queue.size(); // . 의 갯수
        for(int i = 0; i < size; i++){
            int pos[] = queue.poll();
            for(int d = 0 ; d < 4 ; d ++) {
                int x = pos[0] + dir[d][0];
                int y = pos[1] + dir[d][1];
                if(!inRange(x,y)) continue;
                if(map[x][y] != 'X') continue;
                queue.add(new int[]{x,y});
                map[x][y] = '.';
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    private static void input()throws Exception{
        for(int i =0 ; i<  r; i++){
            map[i] = br.readLine().toCharArray();
            for(int k = 0; k < c; k++){
                if(map[i][k] == '.') queue.add(new int[]{i,k});
                if(map[i][k] == 'L') {
                    queue.add(new int[]{i,k});
                    if(player1[0] == -1){
                        player1[0] = i;
                        player1[1] = k;
                    }else {
                        player2[0] = i;
                        player2[1] = k;
                    }
                }
            }
        }
    }
}
