package b1938;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,currPos[] = new int[]{-1,-1}, dest[] = new int[]{-1,-1};
    static int currDir = -1;
    static int eDir = -1;
    static char[][] map;
    static BufferedReader br;
    static boolean visited[][][];
    static int[][] dir = {
        {-1,0}, {0,1}, {1, 0}, {0,-1}
    };
    static int dir2[][][] = {
        {
            {-1,0},
            {1,0}
        },{
            {0,-1},
            {0,1}
        }
    };
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1938/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        // 0 세로 1 가로
        init();
        Queue<Node> queue = new LinkedList<>();
        visited[currPos[0]][currPos[1]][currDir] = true;
        queue.add(new Node(currPos[0], currPos[1], currDir, 0));
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.pos[0] == dest[0] && node.pos[1] == dest[1] && eDir == node.dir){
                result = node.cnt;
                break;
            }
            int x1 = node.pos[0] + dir2[node.dir][0][0];
            int y1 = node.pos[1] + dir2[node.dir][0][1];
            int x2 = node.pos[0] + dir2[node.dir][1][0];
            int y2 = node.pos[1] + dir2[node.dir][1][1];
            for(int i = 0; i < 4; i++){
                int tmpX1 = x1 + dir[i][0];
                int tmpY1 = y1 + dir[i][1];
                int tmpX2 = x2 + dir[i][0];
                int tmpY2 = y2 + dir[i][1];
                int currX = node.pos[0] + dir[i][0];
                int currY = node.pos[1] + dir[i][1];
                if(!inRange(currX, currY) || !inRange(tmpX1, tmpY1) || !inRange(tmpX2, tmpY2) ||
                        visited[currX][currY][node.dir]) continue;
                queue.add(new Node(currX, currY, node.dir, node.cnt + 1));
                visited[currX][currY][node.dir] = true;
            }
            int nextDir = node.dir == 0 ? 1 : 0;
            if(check(node.pos[0], node.pos[1]) && !visited[node.pos[0]][node.pos[1]][nextDir]){
                queue.add(new Node(node.pos[0], node.pos[1], nextDir, node.cnt + 1));
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);

    }


    static boolean check(int x, int y){
        for(int i = -1; i <= 1; i++){
            for(int k = -1; k <= 1 ; k++){
                int xx = x + i;
                int yy = y + k;
                if(!inRange(xx,yy) || map[xx][yy] == '1') return false;
            }
        }
        return true;
    }



    static boolean inRange(int x , int y){
        return x < N && y < N && x >= 0 && y >= 0 && map[x][y] == '0';
    }
    static class Node{
        int[] pos = new int[2];
        int dir;
        int cnt;
        StringBuilder sb;


        Node(int x , int y , int dir, int cnt){
            this.pos[0] = x;
            this.pos[1] = y;
            this.dir = dir;
            this.cnt = cnt;
            this.sb = sb;
        }
    }


    static void init()throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            for(int k = 0; k < N ; k++){
                if(map[i][k] == 'B' ){
                    if(currPos[0] != -1 && currDir == -1 ){
                        currDir = i == currPos[0] ? 1 :0 ;

                    }
                    if(currPos[0] < 0) {
                        currPos[1] = k;
                        currPos[0] = i;
                    }else {
                        currPos[1] += k;
                        currPos[0] += i;
                    }
                }else if(map[i][k] == 'E'){
                    if(dest[0] != -1 && eDir == -1 ){
                        eDir = i == dest[0] ? 1 :0 ;
                    }
                    if(dest[0] < 0) {
                        dest[1] = k;
                        dest[0] = i;
                    }else {
                        dest[1] += k;
                        dest[0] += i;
                    }
                }
                if(map[i][k] == '0' || map[i][k] == '1') continue;
                map[i][k] = '0';
            }
        }
        currPos[0]/=3;
        currPos[1]/=3;
        dest[0]/=3;
        dest[1]/=3;
        visited = new boolean[N][N][2];
    }

    static void print(){
        for(int i =0 ; i < N ; i++){
            for(int k = 0; k < N ; k++){
                System.out.print(map[i][k ]  + " ");
            }
            System.out.println();
        }
    }
}
