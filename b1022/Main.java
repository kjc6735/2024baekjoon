package b1022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int dir[][] = {
            {0,1}, {-1,0}, {0,-1}, {1,0}
    };
    static int max;

    static int[][] arr = new int[10001][10001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1022/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int r1 = Integer.parseInt(str[0]);
        int c1 = Integer.parseInt(str[1]);
        int r2 = Integer.parseInt(str[2]);
        int c2 = Integer.parseInt(str[3]);

        max = Math.max( Math.abs(r1), Math.abs(r2) );
        int max2 = Math.max(Math.abs(c1) , Math.abs(c2));
        max = Math.max(max2, max) + 5000;
        int dirIdx = 0;
        int currX = 5000;
        int currY = 5000;
        int index = 1;

        arr[currX][currY] = index++;
        int cnt = 0;
        int mCnt = 1;
        int tmpCnt = 0;
        while(true){
            int x = currX + dir[dirIdx%4][0];
            int y = currY + dir[dirIdx%4][1];
            if(!inRange(x,y)){ break;}
            currX += dir[dirIdx%4][0];
            currY += dir[dirIdx%4][1];
            arr[currX][currY] = index++;
            tmpCnt++;
            if(tmpCnt == mCnt){
                tmpCnt = 0;
                cnt ++;
                if(cnt == 2){
                    mCnt ++;
                    cnt = 0;
                    dirIdx++;
                }
            }
        }
        print2();
//        print(r1,c1,r2,c2);

    }
    static boolean inRange(int x, int y){
        return x >= 0 && y>=0 && x <= max && y <= max;
    }
    static void print2(){

        for(int i = 0; i <arr.length ; i++){
            for(int k =0; k< arr[i].length ; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }

    static void print(int r1, int c1, int r2, int c2){
        r1 += 5000; r2+= 5000; c1+=5000; c2+= 5000;

        for(int i = r1; i <r2 ; i++){
            for(int k =c1; k< c2 ; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }
}
