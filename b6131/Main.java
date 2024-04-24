package b6131;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b6131/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for(int b = 1; b <= 500; b++){
            for(int a = 1; a <= 500; a++){
                if(a*a - b*b == N) cnt ++;
            }
        }
        System.out.println( cnt);
    }
}
