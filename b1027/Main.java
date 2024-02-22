package b1027;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1027/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int map[] = new int[N];
        for(int i = 0; i < N; i++) map[i] = Integer.parseInt(str[i]);

        int max = 0;

        if(N == 0 || N == 1) {
            System.out.println(0);
            return ;
        }
        for(int i = 0; i <N ; i++) {
            float d = -Float.MAX_VALUE;
            int cnt = 0;
            for(int k = i + 1; k < N; k++){
                float currD = (float) (map[k] - map[i]) / (k - i);
                //currD > d
                if(Float.compare(currD,d) > 0){
                    d = currD;
                    cnt ++;
                }
            }
            d =  -Float.MAX_VALUE;
            for(int k = i-1; k >=0 ; k--){
                float currD = (float) (map[k] - map[i]) / (i-k);
                if(Float.compare(currD,d) > 0){
                    d = currD;
                    cnt ++;
                }
            }
            max = max > cnt ? max : cnt;
        }
        System.out.println(max);
    }
}
