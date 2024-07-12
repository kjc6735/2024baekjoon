package b14267;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] users = new ArrayList[100001];
    static int[] result = new int[100001];
    static int[] value = new int[100001];
    static {
        for(int i = 0; i < users.length; i++) users[i] = new ArrayList<>();
    }

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14267/input.txt"));
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = 0;
        for(int i = 1; i <= N ;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == -1) {
                start = i; continue;
            }
            users[tmp].add(i);
        }
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            value[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start,value[start]});
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            result[curr[0]] = curr[1];

            for(int user : users[curr[0]]){
                queue.add(new int[]{user, curr[1] + value[user] });
            }
        }
        for(int i = 1; i <= N ; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
