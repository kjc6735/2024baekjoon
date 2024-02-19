package sw11446;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("sw11446/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= test_case ; tc++ ){
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i < n; i++){
                int candy = Integer.parseInt(st.nextToken());
                cnt += (candy / m);
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb.toString());

    }
}
