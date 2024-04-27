package b14697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b14697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int a = 0; a <= 50;a++){
            for(int b = 0; b <= 50; b++){
                for(int c = 0; c <= 50; c++){
                    int result = a * A + b * B + c * C;
                    if(result == N){
                        System.out.println(1);
                        return ;
                    }
                }
            }
        }
        System.out.println(0);

    }
}
