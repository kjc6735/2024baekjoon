package b1208;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N,S;
    static int arr[] = new int[1024];
    static Map<Integer, Integer> map = new HashMap<>();
    static long cnt = 0;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1208/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        left(0, 0);
        right(N/2, 0);
        if(S == 0) System.out.println(cnt-1);
        else System.out.println(cnt);
    }

    private static void left(int start, int sum){
        if(start == N/2) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }
        left(start + 1, sum);
        left(start + 1, sum+ arr[start]);
    }
    private static void right(int start, int sum){
        if(start == N) {
            cnt += map.getOrDefault(S - sum, 0);
            return;
        }
        right(start + 1, sum);
        right(start + 1, sum+ arr[start]);
    }




}
