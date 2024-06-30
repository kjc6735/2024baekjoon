package b1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean arr[] = new boolean[4_000_001];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 2; i <= N; i++){
            if(arr[i]) continue;
            list.add(i);
            for(int k = i; k <= N ; k+=i){
                arr[k] = true;
            }
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;

        while ( end < list.size() ){
            if (sum > N) {
                sum -= list.get(start++);
            }else if (sum < N) {
                sum += list.get(end++);
            }else{
                cnt++;
                sum -= list.get(start++);
            }
        }

        if(list.size() > 0 && list.get(--end) == N) cnt ++;
        System.out.println(cnt);
    }
}
