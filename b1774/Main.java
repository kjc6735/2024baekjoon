package b1774;

import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
    static Pos arr[] = new Pos[1001];
    static int roots[] = new int[1001];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1774/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);


        for(int i = 1; i <= N; i++){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            arr[i] = new Pos(x,y);
            roots[i]  = i;
        }

        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            union(a,b);
        }


    }

    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot > bRoot) roots[bRoot] = aRoot;
        else roots[aRoot] = bRoot;
    }


}
