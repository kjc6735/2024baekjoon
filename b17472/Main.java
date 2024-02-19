package b17472;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int LINE = 9;
    static int dir[][] = {
            {1,0},{-1,0}, {0,1}, {0,-1}
    };
    static int N, M, map[][], result = Integer.MAX_VALUE;
    static BufferedReader br;
    static ArrayList<ArrayList<int[]>> islandPointList =  new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17472/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        findIsland();

    }

    private static void find(int idx){
        if(idx >= islandPointList.size()){
            int cnt = getLineCnt();
            result = result > cnt ? result : cnt;
            return ;
        }
        for(int i = 0;  i < islandPointList.get(idx).size(); i++){
            int[] curr = islandPointList.get(idx).get(i);
            for(int d = 0 ;d < 4; d ++ ){
                int conn = connect(curr[0], curr[1], d);
                if(conn == 0) continue;
                find(idx + 1);
                int[] re = new int[]{ -1 * curr[0], -1 * curr[1]};

            }
        }
    }

    static int getLineCnt(){
        int cnt = 0;
        for(int i = 0; i < N; i ++){
            for(int k =0 ;k <  M; k++){
                if(map[i][k] == LINE) cnt++;
            }
        }

        return cnt;
    }

    static private int connect(int xx, int yy, int d, int replace){
        int x = xx + dir[d][0];
        int y = yy + dir[d][1];
        while (inRagne(x,y) && map[x][y] = ){
            map[x][y] = replace;
            i
            x += dir[d][0];
            y += dir[d][1];
        }
    }

    private static void findIsland(){
        int index = 2;
        for(int i = 0; i < N; i ++){
            for(int k =0 ;k <  M; k++){
                if(map[i][k] != 1) continue;
                Queue<int[]> queue = new LinkedList<>();
                islandPointList.add(new ArrayList<>());
                queue.add(new int[]{i,k});
                while (!queue.isEmpty()){
                    int[] curr = queue.poll();
                    map[curr[0]][curr[1]] = index;
                    for(int d = 0; d < 4; d++){
                        int x = curr[0] + dir[d][0];
                        int y = curr[1] + dir[d][1];
                        if(!inRagne(x,y) || map[x][y] != 1) continue;
                        map[x][y] = index;
                        queue.add(new int[]{x,y});
                        islandPointList.get(islandPointList.size()).add(new int[]{x,y});
                    }
                }
                index++;
            }
        }
    }

    private static void print(){
        for(int i = 0; i < N; i ++){
            for(int k =0 ;k <  M; k++){
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
    }
    private static boolean inRagne(int x, int y){
        return x < N && y < M && x >= 0 && y >= 0;
    }
    private static void setMap() throws Exception{
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i ++){
            str = br.readLine().split(" ");
            for(int k =0 ;k <  M; k++){
                map[i][k] = Integer.parseInt(str[k]);
            }
        }
    }
}
