package b1275;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long tree[];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1275/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int  k = 0;
        while ((int) Math.pow(2,++k) <= N){}

        int start = (int) Math.pow(2, k);
        int end = start *2;
        System.out.println("end " +  " "+ end);
        tree = new long[end+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) tree[start+ i] = Long.parseLong(st.nextToken());
        for(int i = end-1; i >= 0 ; i-=2) tree[i/2] = tree[i] + tree[i-1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            int x = a > b ? b : a;
            int y = a > b ? a : b;
            sb.append(x == y ? tree[x] : sum(start + x -1, start + y - 1)).append("\n");
            update(start + c -1, d);
//            print(end);
        }
        System.out.print(sb.toString());
    }
    static void print(int n){
        for(int i = 1; i<= n; i++){
            System.out.print(tree[i]+ " ");
        }
        System.out.println();
    }
    static void update(int treeIdx, long updateValue){
        long diff = updateValue - tree[treeIdx];
        while (treeIdx > 0){
            tree[treeIdx] += diff;
            treeIdx/=2;
        }
    }

    static long sum(int a, int b){
        long s = 0;
        while (a <= b){
            if(a%2 == 1) s += tree[a++];
            if(b%2 == 0) s += tree[b--];
            a/=2;
            b/=2;
        }
        return s;
    }
}
