package b10836;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int M,N,map[][];
    static int cntArr[][];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b10836/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        map = new int[M][M];

        for(int i = 0; i < M; i++) Arrays.fill(map[i], 1);

        for(int i =0; i < N; i++){
            str = br.readLine().split(" ");
            int idx = 0;
            int x = M-1;
            int y = 0;
            for(int k = 0; k < 3; k++){
               int tmp = Integer.parseInt(str[k]);
               for(int a = 0; a < tmp ; a++) {
                   if (x != 0) {
                       map[x--][y] += k;
                   } else {
                       map[x][y++] += k;
                   }
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            for(int k = 0; k < M ; k++){

                if(i >= 1 && k >= 1){
                    sb.append(map[0][k]).append(" ");
                }else{
                    sb.append(map[i][k]).append(" ");

                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            for(int k = 0; k < M ; k++){
                sb.append(map[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
