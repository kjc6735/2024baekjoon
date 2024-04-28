package b1816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1816/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(long i = 0 ; i < N ; i++){
            long tmp = Long.parseLong(br.readLine());
            long div = 0;
            for (div = 2; div <= 1000000; div ++){
                if(tmp%div  == 0 ) break;
            }
            if(div == 1000001) sb.append("YES");
            else sb.append("NO");

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
