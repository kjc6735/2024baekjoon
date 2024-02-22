package b2675;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2675/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < test_case; tc ++){
            String str[] = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);

            for(int i = 0; i < str[1].length(); i++){
                for(int k = 0 ; k < N; k++){
                    sb.append(str[1].charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }
}

