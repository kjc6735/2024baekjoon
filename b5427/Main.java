package b5427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x, y, cnt;
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
    static char map[][] = new char[1000][1000];
    static boolean visited[][] = new boolean[1000][1000];

    static int dir [][] = {
            {0,1}, {0,-1}, {1,0},{-1,0}
    };
    static int N,M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b5427/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= test_case; tc ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
             M =Integer.parseInt(st.nextToken());
             N = Integer.parseInt(st.nextToken());
            Queue<Pos> userPos = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();
            for(int i = 0; i < N ; i++){
                map[i] = br.readLine().toCharArray();
                for(int k = 0; k < M; k++){
                    if(map[i][k] == '@') userPos.add(new Pos(i,k,0));
                    else if (map[i][k] =='*') fire.add(new int[]{i,k});
                }
            }

            while (!userPos.isEmpty()){
                while (!fire.isEmpty()){
                    int[] firePos =fire.poll();
                    for(int d = 0; d < 4; d++){
                        int x = firePos[0] + dir[d][0];
                        int y = firePos[1] + dir[d][1];

                        if(!inRange(x,y)) continue;
                        if(map[x][y] != '.') continue;

                        map[x][y] = '*';

                    }
                }
                boolean goOut = false;
                while (!userPos.isEmpty()){
                    Pos user = userPos.poll();
                    if(map[user.x][user.y] == '*') continue;
                    for(int d = 0; d < 4; d++){
                        int x = user.x + dir[d][0];
                        int y = user.y + dir[d][1];

                        if(!inRange(x,y)) {
                            goOut = true;
                            break;
                        }
                        if(map[x][y] != '.') continue;
                        if(visited[x][y]) continue;

                        visited[x][y] = true;


                    }
                }
            }

        }


    }

    static boolean inRange(int x, int y){
        return x >= 0 && y>=0 && x < N && y < M;
    }
}
