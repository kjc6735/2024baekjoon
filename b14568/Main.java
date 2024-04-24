package b14568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b14568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int a = 1 ; a < N; a++){ // 남규
            for(int b = 1; b< N; b++){ // 영훈
                for(int c = 1; c <N; c++){ // 택희
                    if(a - b < 2) continue;
                    if(c %2 == 1) continue;
                    if(a + b + c != N ) continue;
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);

    }
}
