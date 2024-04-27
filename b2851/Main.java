package b2851;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2851/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int tmp = 0;
        for(int i = 0; i < 10; i++) {
            tmp += Integer.parseInt(br.readLine());
            int curr = Math.abs(100 - tmp);
            int maxCurr = Math.abs(100 - max);
            if(curr < maxCurr ){
                max = tmp;
            }else if(curr == maxCurr){
                max = Math.max(tmp, max);
            }
        }
        System.out.println(max);
    }
}
