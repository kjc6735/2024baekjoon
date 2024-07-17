package b12947;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b12947/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int sub = 0;
        for(int i = 0; i < depth; i++){
            max++;
            int cnt = Integer.parseInt(st.nextToken());
            if(cnt == 1){
                max = max > sub + 1 ? max : sub + 1;
                sub = 0;
            }else {
                sub +=2;
            }
        }
        System.out.println(Math.max(sub,max));
    }


}
