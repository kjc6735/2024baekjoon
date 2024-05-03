<<<<<<< HEAD
package b17142;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int N,M;
    static int arr[][];
    static int dir[][] = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    static int wallCnt = 0;
    static int min = Integer.MAX_VALUE;

    static List<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b17142/input.txt"));
        br= new BufferedReader(new InputStreamReader(System.in));

        String[] str= br.readLine().split(" ");
        N =Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][N];

        input();
        if(!hasZero(arr)){
            System.out.println(0);
            return ;
        }
        find(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static void find(int cnt, int n){
        if(Integer.bitCount(n) == M){
            int tmp[][] = new int[N][N];
            copy(tmp, arr);
            int total = virus.size() + wallCnt;
            Queue<int[]> queue = new LinkedList<>();
            for(int i = 0 ; i < virus.size(); i++) {
                if((n & (1 << i)) == 0) continue;
                int x = virus.get(i)[0];
                int y = virus.get(i)[1];
                queue.add(new int[]{x,y, 0});
                tmp[x][y] = 3;
            }
            boolean check = false;



            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size;i++){
                    int[] curr = queue.poll();
                    for(int d = 0; d<  4; d++) {
                        int x = curr[0] + dir[d][0];
                        int y = curr[1] + dir[d][1];
                        if(!inRange(x,y)) continue;
                        if(tmp[x][y] == 1 || tmp[x][y] == 3) continue;
                        if(tmp[x][y] == 0) total ++;
                        tmp[x][y] = 3;

                        if(total== N*N){
                            check = true;
                            min = Math.min(min, curr[2]  +1);
                            break;
                        }
                        queue.add(new int[]{x,y, curr[2] + 1});
                    }
                    if(check) break;
                }
                if(check) break;
            }
        }

        if(virus.size() == cnt) return ;
        find(cnt + 1, n | (1 << cnt));
        find(cnt + 1, n);
    }

    static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    static void input() throws Exception{
        for(int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 2) {
                    virus.add(new int[]{i,k});
                }else if(arr[i][k] == 1) wallCnt ++;

            }
        }
    }
    static boolean hasZero(int tmp[][]){
        for(int i = 0; i < N ; i++) {
            for(int k = 0; k < N; k++){
                if(tmp[i][k] == 0) return true;
            }
         }
        return false;
    }
    static void copy(int a[][], int b[][]){
        for(int i = 0; i < N ; i++) {
            for(int k = 0; k < N; k++){
                a[i][k] = b[i][k];
            }
        }
    }


}
=======
//package b17142;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static class Pos{
//        int x; int y;
//        Pos(int x, int y){
//            this.x = x;
//            this.y = y;
//
//        }
//    }
//    static int arr[][] = new int[50][50];
//    static int tmp[][] = new int[50][50];
//    static int min = Integer.MAX_VALUE;
//    static int dir[][]= {
//            {0,1}, {0,-1}, {1,0},{-1,0}
//    };
//    static int N,M;
//    static int wallCnt = 0;
//    static ArrayList<Pos> vList = new ArrayList<>();
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("b17142/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st= new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//        for(int i = 0; i < N ; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int k = 0; k < N; k++){
//                arr[i][k] = Integer.parseInt(st.nextToken());
//                if(arr[i][k] == 2){
//                    vList.add(new Pos(i,k));
//                }else if(arr[i][k] == 1){
//                    wallCnt++;
//                }
//            }
//        }
//
//        find(0, 0);
//        System.out.println(min);
//    }
//
//    static void find(int start, int bit){
//
//        if(Integer.bitCount(bit) == M){
//            int cnt = M + wallCnt;
//            copy(tmp, arr);
//            Queue<Pos> queue = new LinkedList<>();
//            for(int i = 0; i < vList.size(); i++){
//                if(( bit & 1 << i) != 0) {
//                    queue.add(new Pos(vList.get(i).x, vList.get(i).y));
//                    tmp[vList.get(i).x][vList.get(i).y] = 3;
//                }
//            }
//            int second = 0;
//            while (!queue.isEmpty()){
//                int size = queue.size();
//                int tmpCnt = cnt;
//                for(int i = 0 ; i < size; i++){
//                    Pos curr = queue.poll();
//
//                    for(int d = 0 ; d< 4; d++){
//                        int x = curr.x + dir[d][0];
//                        int y = curr.y + dir[d][1];
//                        if(!inRange(x,y)) continue;
//                        if(tmp[x][y] == 1 || tmp[x][y] == 3) continue;
//                        tmp[x][y] = 3;
//                        queue.add(new Pos(x,y));
//                        cnt ++;
//                    }
//                }
//
//                if(cnt == N*N) break;
//                if(tmpCnt)
//                second ++;
//
//            }
//            if(isValid(tmp)){
//                min = Math.min(min,second);
//
//            }
//
//            return ;
//        }
//        if(start == vList.size()) return ;
//
//        find(start + 1, bit | 1 << start);
//        find(start + 1, bit);
//
//    }
//    public static void print(int arr[][]){
//        System.out.println("=================");
//        for(int i = 0;  i < N ; i++){
//            for(int k = 0; k < N ; k++){
//                System.out.print(arr[i][k] + " ");
//            }
//            System.out.println();
//        }
//    }
//    static boolean inRange(int x,int y){
//        return x >= 0 && y >= 0 && x < N && y < N;
//    }
//
//    static void copy (int arr[][], int arr2[][]){
//        for(int i = 0; i < N ; i++){
//            for(int k = 0; k < N ; k++){
//                arr[i][k] = arr2[i][k];
//            }
//        }
//    }
//
//    static boolean isValid(int a[][]){
//        for(int i = 0; i < N ; i++){
//            for(int k = 0; k < N ; k++){
//                if(a[i][k] == 0) return false;
//            }
//        }
//        return true;
//    }
//}
>>>>>>> 025faca (TEST)
