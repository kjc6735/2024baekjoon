package b16562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[] = new boolean[10001];
    static int price[] = new int[10001];
    static ArrayList<Integer>[] arr = new ArrayList[10001];
    static{
        for(int i = 0; i < 10001; i++){
            arr[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b16562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++)
            price[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);

        }

        int sum = 0;
        for(int i = 1 ; i <= N ; i++){
            if(visited[i]) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            int min = price[i];
            while (!queue.isEmpty()){
                int curr = queue.poll();
                for(int next: arr[curr]){
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                    min = min > price[next] ? price[next] :min;
                }
            }
            sum+= min;
        }

        if(sum <= k) {
            System.out.println(sum);
        }else{
            System.out.println("Oh no");
        }
    }
}
