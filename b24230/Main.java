package b24230;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree = new ArrayList[200_001];
    static {
        for(int i = 0; i < tree.length; i++) tree[i] = new ArrayList<>();
    }
    static int[] colors = new int[200_001];
    static int N;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b24230/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) colors[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            tree[a].add(b);
        }

        System.out.println(fn(1, colors[1]));

    }

    static int fn(int curr, int color){
        if(tree[curr].size() == 0){
            if(color == colors[curr]) {
                return 0;
            }
            return 1;
        }

        int cnt = 0;
        if(colors[curr] != 0 && color != colors[curr]){
            cnt ++;
        }

        for(int i = 0; i < tree[curr].size(); i++){
            cnt += fn(tree[curr].get(i), colors[curr]);
        }
        return cnt;
    }
}
