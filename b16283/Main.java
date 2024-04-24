package b16283;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b16283/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int n = Integer.parseInt(str[2]);
        int w = Integer.parseInt(str[3]);
        boolean check  = false;
        int ansA = 0;
        int ansB = 0;
        int cnt = 0;
        for(int i = 1; i < n ; i++){
            int aa = a * i;
            int bb = b * (n-i);
            if( aa + bb == w) {
                cnt ++;
                ansA = i;
                ansB = n-i;
            }
        }
        if(cnt == 1){
            System.out.println(ansA + " "+ ansB);
        }else System.out.println(-1);
    }
}
