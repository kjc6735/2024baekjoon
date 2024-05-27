package b1941;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char map[][] = new char[5][5];
    static int total = 0;
    static int dir[][] = {
            {0,1}, {1,0},{-1,0},{0,-1}
    };

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1941/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
           map[i] = br.readLine().toCharArray();
        }

        fn(0,0,0,0);
        System.out.println(total);
    }

    static void fn(int index,  int yCnt, int sCnt, int visited){
        if(yCnt >= 4) return ;
        if(yCnt + sCnt == 7) {
            if(isOK(visited)) total++;
            return ;
        }
        if(index == 25) return ;
        if(map[index/5][index % 5] == 'Y'){
            fn(index + 1, yCnt+1, sCnt, visited |( 1 << index));
        }else {
            fn(index + 1,  yCnt, sCnt + 1, visited | (1 << index));
        }
        fn(index + 1,yCnt, sCnt, visited);
    }

    static boolean isOK (int visited){
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < 25; i++){
            if(  (visited & (1 << i)) != 0){
                queue.add(new int[]{i / 5, i % 5});
                visited ^= ( 1<<i);
                break;
            }
        }

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];
                if(!inRange(x,y) || ((visited &(1 << (x * 5 + y))) == 0)){
                    continue;
                }
                visited ^= (1 << (x * 5 + y));
                queue.add(new int[]{x,y});
            }
        }

        return visited == 0;
    }

    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

}
