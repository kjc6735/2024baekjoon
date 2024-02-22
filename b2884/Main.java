package b2884;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  throws  Exception{
        System.setIn(new FileInputStream("b2884/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int h = Integer.parseInt(str[0]) * 60;
        int m = Integer.parseInt(str[1]);

        int result = h + m - 45;

        if(result < 0) {
            result = 24*60 + result;
        }

        System.out.println(result/60 + " " + result%60);



    }
}
