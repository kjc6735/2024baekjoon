package b1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][] = new int[100][100];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b1010/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= tc; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = fn(b,a);
            sb.append(tmp).append("\n");

        }
        System.out.println(sb);
    }

    private static int fn(int a, int b) {
        if(arr[a][b] > 0) {
            return arr[a][b];
        }
        if( a == b || b == 0) return arr[a][b] = 1;
        return arr[a][b] = fn(a-1, b-1) + fn(a-1, b);


    }
}
