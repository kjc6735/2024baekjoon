package b17304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Integer> provider[]= new HashSet[200_001];
    static Set<Integer>  reciver[] = new HashSet[200_001];
    static Set<String> guilty = new HashSet<>();
    static boolean visited[] = new boolean[200_001];
    static {
        for(int i = 0; i < 200_001; i++){
            provider[i] = new HashSet<>();
            reciver[i] = new HashSet<>();
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reciver[b].add(a);
        }

        

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                System.out.println("NO");
                return ;
            }
        }

        System.out.println("YES");



    }

}
