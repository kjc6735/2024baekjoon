package b9465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br;
    static int arr[][] = new int[2][100_000];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b9465/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= test_case; tc ++){
            int n = Integer.parseInt(br.readLine());
            int result[][] = new int[2][n];
            for(int i = 0; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int k = 0; k < n ; k++){
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            //1
            result[0][0] = arr[0][0];
            result[1][0] = arr[1][0];
            if(n != 1) {
                result[0][1] = arr[0][1] + arr[1][0];
                result[1][1] = arr[1][1] + arr[0][0];
            }
            for(int i = 2; i < n;i++){
                result[0][i] = Math.max(Math.max(result[1][i-1], result[0][i-2]), result[1][i-2]) + arr[0][i];
                result[1][i] = Math.max(Math.max(result[0][i-1], result[0][i-2]), result[1][i-2]) + arr[1][i];
            }
            if(n == 1) {
                sb.append(Math.max(arr[0][0], arr[1][0])).append("\n");
            }else {
                sb.append(Math.max(Math.max(Math.max(result[0][n-1], result[1][n-1]), result[1][n-2]), result[0][n-2])).append("\n");
            }
//            System.out.println(Arrays.toString(result[0]));
//            System.out.println(Arrays.toString(result[1]));

        }
        System.out.print(sb.toString());
    }
}