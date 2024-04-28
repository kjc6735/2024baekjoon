package b15593;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int arr[][], time[] = new int[1001];
    static int N;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b15593/input.txt"));
        br = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i =0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            for(int k= arr[i][0] ; k < arr[i][1]; k++){
                time[k] ++;
            }
        }
        int cnt = 0;
//        for(int i = 0; i <1001 ; i++) if(time[i] != 0) cnt ++;

        for(int i = 0; i < N ;i++){
            for(int k = arr[i][0] ; k < arr[i][1] ;k ++){
                time[k]--;
            }
            int c = 0 ;
            for(int a = 0; a < 1001; a++){
                if(time[a] != 0) c ++;
            }
            cnt = Math.max(cnt, c);
            for(int k = arr[i][0] ; k < arr[i][1] ;k ++){
                time[k]++;
            }
        }
        System.out.println(cnt);
    }

}
