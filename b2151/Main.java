package b2151;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Pos{
        int x,y;
        Pos(int x, int y ){
            this.x =x;
            this.y = y;
        }
    }
    static BufferedReader br;
    static int N;
    static char map[][] = new char[50][50];
    static int min = Integer.MAX_VALUE;
    static int dir[][] ={
        {-1,0},{0,1},{1,0},{0,-1}
    };

    static boolean visited[][][] = new boolean[50][50][4];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2151/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++) map[i] = br.readLine().toCharArray();
        Pos start = null;
        for(int i = 0; i < N ; i++) for(int k = 0; k < N ; k++) if(map[i][k] == '#') { start = new Pos(i,k); break; }

        for(int i = 0;  i < 4; i++){
            find(start, 1600 + i ,0);
        }
        System.out.println(min);
    }

    static void find(Pos pos, int currDir, int cnt){
        int currX = pos.x;
        int currY = pos.y;
        if(currDir == -1 ) currDir = 3;
        if(currDir == 4) currDir = 0;
        for(int i = 0; i < 4; i++){
            Queue<int[]> queue = new LinkedList<>();
            int x = currX;
            int y  =currY;
            while (inRange(x + dir[currDir%4][0], y + dir[currDir%4][1]) ){
                x += dir[currDir%4][0];
                y += dir[currDir%4][1];
                if(map[x][y] == '*') break;
                if(visited[x][y][currDir % 4] || visited[x][y][(currDir + 2) % 4] ) break;
                if(map[x][y] == '#'){
                    min  = Math.min(min, cnt);
//                    print();
                    break;
                }
                if(map[x][y] == '!'){
                    visited[x][y][(currDir % 4)] = true;
                    visited[x][y][(currDir +2) % 4] = true;

                    find(new Pos(x,y),currDir -1, cnt + 1 );
                    find(new Pos(x,y),currDir +1, cnt + 1);
                }
            }
            int tmpX = currX;
            int tmpY = currY;
            while (tmpX != x || tmpY != y){
                visited[tmpX][tmpY][(currDir % 4)] = false;
                visited[tmpX][tmpY][(currDir +2) % 4] = false;
                tmpX += dir[currDir%4][0];
                tmpY += dir[currDir%4][1];
            }
        }
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++){
            for(int k = 0; k < N ; k++){
                boolean check = false;
                for(int a  = 0; a < 4; a++){
                    if(visited[i][k][a]){
                        check = true;
                    }
                }
                sb.append(check ? 1 : 0).append(" ");

            }
            sb.append("\n");
        }
        System.out.println("==============");
        System.out.println(sb.toString());
        System.out.println("==============");

    }
    static boolean inRange(int x, int y){
        return x >=0 && y >= 0 && x < N && y < N;
    }
}
