package b26159;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int child;
        int value;
        Node(int c, int v){
            this.child = c;
            this.value = v;
        }
    }
    static ArrayList<Node>[] nodes = new ArrayList[100_000];

    static {
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new ArrayList<>();
        }
    }
    static int N;
    static boolean visited[] = new boolean[100_000];
    static String[] str = new String[100_000];

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b26159/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N-1; i++){
            str[i] = br.readLine();
        }
        String tmp[] = br.readLine().split(" ");
        for(int i =0; i < N-1; i++){
            String s[] = str[i].split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int value = Integer.parseInt(tmp[i]);
            nodes[a].add(new Node(b,value));
        }

    }
}
