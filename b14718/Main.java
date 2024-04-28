package b14718;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int a[] = new int[100];
    static int b[] = new int[100];
    static int c[] = new int[100];
    static int arr[][] = new int[100][3];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b14718/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            arr[i][0] = a[i];
            arr[i][1] = b[i];
            arr[i][2] = c[i];
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<  N; i++){
            for(int k = 0 ; k < N ; k++){
                for(int j = 0; j < N ; j++){
                    int cnt = 0;
                    for(int t = 0; t < N; t++){
                        if(a[i] >= arr[t][0] && b[k] >= arr[t][1] && c[j]>= arr[t][2] ){
                            cnt ++;
                        }
                    }
                    if(cnt < K ) continue;
                    min = Math.min(min, a[i] + b[k] + c[j]);
                }
            }
        }
        System.out.println(min);
    }
}
