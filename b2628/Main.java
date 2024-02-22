package b2628;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int dir[][] = {
            {0,1},  {0, -1}, {1,0}, {-1, 0}

    };
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2628/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str [] = br.readLine().split(" ");

        int a = Integer.parseInt(str[1]);
        int b = Integer.parseInt(str[0]);
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[a*2][b*2];
        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            int tmp = 2*y -1;
            if(x == 0) {
                for(int k = 0; k < b*2; k++){
                    map[tmp][k] = 1;
                }
            }else {
                for(int k = 0; k < a*2; k++){
                    map[k][tmp] = 1;
                }
            }
        }
//        print(map,a,b);
        int max = 0;
        for(int i = 0; i < a*2 ; i++){
            for(int k = 0; k < b*2; k++) {
                if(map[i][k] == 1) continue;
                Queue<int[]> queue = new LinkedList<>();
                int cnt = 1;
                queue.add(new int[]{i,k});
                map[i][k] = 1;
                while (!queue.isEmpty()){
                    int[] curr = queue.poll();
                    for(int d = 0 ; d < dir.length; d++){
                        int x = curr[0] + dir[d][0];
                        int y = curr[1] + dir[d][1];
                        if(x >= a*2-1 || y >= b *2 -1 || x < 0 || y < 0 ) continue;
                        if(map[x][y] == 1 ) continue;
                        if(!(x%2 == 1 || y%2 == 1))cnt ++;
                        queue.add(new int[]{x,y});
                        map[x][y] = 1;
                    }
                }

                if(cnt > max) max = cnt;
            }
        }

        System.out.println(max);
    }

    static void print(int[][] map, int a, int b){
        for(int i = 0; i < a*2;i++){
            for(int k = 0; k <b*2; k++){
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }

    }
}

