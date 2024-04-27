package b1145;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[5];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1145/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 1; ; i++) {
            int cnt = 0;
            for(int k = 0; k < 5; k++) if(i %arr[k] == 0) cnt ++;
            if(cnt >= 3) {
                System.out.println(i);
                return;
            }
        }
    }
}
