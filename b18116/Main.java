package b18116;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


    static int roots[] = new int[1_000_001];
    static int cnt[] = new int[1_000_001];
    static {
        for(int i = 0; i < 1_000_001; i++){
            roots[i] = i;
            cnt[i] = 1;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b18116/input.txt"));


        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }else{
                int q = Integer.parseInt(st.nextToken());
                sb.append(cnt[find(q)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return ;
        if(aRoot < bRoot){
            cnt[aRoot] += cnt[bRoot];
            cnt[bRoot] = 0;
            roots[bRoot] = aRoot;
        }else {
            cnt[bRoot] += cnt[aRoot];
            cnt[aRoot] = 0;
            roots[aRoot] = bRoot;
        }
    }
    static int find(int a){
        if(roots[a] == a) return a;
        return roots[a] = find(roots[a]);
    }
}
