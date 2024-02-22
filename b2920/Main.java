package b2920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        String result = "";
        if(str[0].charAt(0) < str[1].charAt(0)){
            result = "ascending";
        }else{
            result = "descending";
        }
        for(int i = 0; i < 7 ; i++){
            if(result.equals("ascending") && str[i].charAt(0) > str[i+1].charAt(0)){
                System.out.println("mixed");
                return ;
            }
            if(result.equals("descending") && str[i].charAt(0) < str[i+1].charAt(0)){
                System.out.println("mixed");
                return ;
            }
        }
        System.out.println(result);

    }
}
