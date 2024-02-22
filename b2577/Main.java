package b2577;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2577/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int r = a * b* c;
        String str = String.valueOf(r);
        int result[] = new int[10];
        for(int i = 0; i < str.length(); i++){
            result[str.charAt(i) - '0']++;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(result[i]);
        }


    }
}
