package b10897;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long INF = 1_000_000_007;
        long prevCnt = 1; // 누적
        long sum = 0;
        long prevSelect = 1;
        for(long gen = 1; gen<= G; gen++){
            long find = Long.parseLong(st.nextToken());
            sum += prevCnt; // 맨 앞 시작 번호
            prevCnt *= (gen); // 현재의 갯수

            sum %= INF;
            prevCnt %= INF;
            prevSelect %= INF;

            long add = ((prevSelect-1L) * gen) % INF;
            long select = (sum+find -1L + add) % INF;
            prevSelect = add + find;
            sb.append(select).append("\n");
        }
        System.out.print(sb.toString());
    }
}
