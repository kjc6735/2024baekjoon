package b25577;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[2][100001];
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b25577/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = arr[0][i];
            map.put(arr[0][i], i);
        }
        Arrays.sort(arr[0], 0, N);
        int cnt = 0;
        for(int i = 0 ; i < N ;i++){
            if(arr[0][i] == arr[1][i]) continue;

            int changeIdx = map.get(arr[0][i]);

            map.put(arr[0][i], i);
            map.put(arr[1][i], changeIdx);

            int tmp = arr[1][i];
            arr[1][i] = arr[1][changeIdx];
            arr[1][changeIdx] = tmp;
            cnt ++;
        }
        System.out.println(cnt);
    }
}
