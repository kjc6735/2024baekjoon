package b1799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int max[] = new int[2];

    static int N = 0, arr[][] = new int[10][10];
    static boolean visited[][] = new boolean[20][20];
    static int dir[][] = {
            {1,1}, {1,-1},{-1,1}, {-1,-1}
    };

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1799/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        fn(0, 0, 0);
        fn(1, 0, 1);

        System.out.println(max[0] + max[1]);
    }
    public static int calIncr(int ind) {
        //크기가 홀 수일 경우 -> 2증가
        if (N % 2 == 1) return 2;
        //크기가 짝수일 경우
        if (ind % N == N-1) return 1;
        else if (ind % N == N-2) return 3;
        else return 2;
    }



    private static void fn(int index, int cnt, int c){
        if(index >= N*N){
            max[c] = Math.max(cnt , max[c]);
            return ;
        }

        int x = index/N;
        int y = index % N;

        if (arr[x][y] == 0) {
            fn(index + calIncr(index), cnt, c);
            return;
        }

        if(isValid(x,y)){
            visited[x][y] = true;
            fn(index + calIncr(index), cnt+1, c);
            visited[x][y] = false;
        }
        fn(index +  calIncr(index), cnt, c);
    }

    static boolean isValid(int x, int y){
       return  check(x,y,0) && check(x,y,1) && check(x,y,2) && check(x,y,3);
    }

    static boolean check(int x, int y, int dirIndex){
        while (inRange(x + dir[dirIndex][0] , y + dir[dirIndex][1])){
            if(visited[x + dir[dirIndex][0] ][ y + dir[dirIndex][1]]) return false;
            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
        }
        return true;
    }
    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}
